package com.smartadmin.master.module.system.employee;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.smartadmin.master.common.domain.PageResultDTO;
import com.smartadmin.master.common.domain.ResponseDTO;
import com.smartadmin.master.constant.JudgeEnum;
import com.smartadmin.master.module.system.employee.constant.EmployeeResponseCodeConst;
import com.smartadmin.master.module.system.employee.domain.bo.EmployeeBO;
import com.smartadmin.master.module.system.employee.domain.dto.EmployeeDTO;
import com.smartadmin.master.module.system.employee.domain.dto.EmployeeQueryDTO;
import com.smartadmin.master.module.system.employee.domain.entity.EmployeeEntity;
import com.smartadmin.master.module.system.employee.domain.vo.EmployeeVO;
import com.smartadmin.master.module.system.position.PositionDao;
import com.smartadmin.master.module.system.position.domain.dto.PositionRelationResultDTO;
import com.smartadmin.master.module.system.privilege.service.PrivilegeEmployeeService;
import com.smartadmin.master.utils.SmartPageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Bryce
 * @desc 员工管理
 * @date 2021/11/19
 */
@Service
public class EmployeeService {

    private static final String RESET_PASSWORD = "123456";

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private PositionDao positionDao;

    @Autowired
    private PrivilegeEmployeeService privilegeEmployeeService;

    /*
    员工基本信息缓存
     */
    private static final ConcurrentHashMap<Long, EmployeeBO> employeeCache = new ConcurrentHashMap<>();

    public List<EmployeeVO> getAllEmployee() {
        return employeeDao.selectAll();
    }

    /**
     * @return
     * @desc 通过Id查询员工信息
     * @author Bryce
     * @date 2021/11/23
     */
    public EmployeeBO getById(Long id) {
        EmployeeBO employeeBO = employeeCache.get(id);

        if (employeeBO == null) {
            EmployeeEntity employeeEntity = employeeDao.selectById(id);
            if (employeeEntity != null) {
                boolean superman = privilegeEmployeeService.isSuperman(id);
                employeeBO = new EmployeeBO(employeeEntity, superman);
                employeeCache.put(employeeEntity.getId(), employeeBO);
            }
        }
        return employeeBO;
    }

    /**
     * 查询员工列表
     *
     * @param queryDTO
     * @return
     */
    public ResponseDTO<PageResultDTO<EmployeeVO>> selectEmployeeList(EmployeeQueryDTO queryDTO) {
        Page pageParam = SmartPageUtil.convert2QueryPage(queryDTO);
        queryDTO.setIsDelete(JudgeEnum.NO.getValue());
        List<EmployeeDTO> employeeList = employeeDao.selectEmployeeList(pageParam, queryDTO);
        List<Long> employeeIdList = employeeList.stream().map(EmployeeDTO::getId).collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(employeeIdList)) {
            List<PositionRelationResultDTO> positionRelationResultDTOList = positionDao.selectEmployeesRelation(employeeIdList);
            Map<Long, List<PositionRelationResultDTO>> employeePositionMap = new HashMap();

            for (PositionRelationResultDTO positionRelationResultDTO : positionRelationResultDTOList) {
                List<PositionRelationResultDTO> relationResultDTOList = employeePositionMap.get(positionRelationResultDTO.getEmployeeId());
                //匹配对应的岗位
                if (relationResultDTOList == null) {
                    relationResultDTOList = new ArrayList<>();
                    employeePositionMap.put(positionRelationResultDTO.getEmployeeId(), relationResultDTOList);
                }
                relationResultDTOList.add(positionRelationResultDTO);
            }

            for (EmployeeDTO employeeDTO : employeeList) {
                List<PositionRelationResultDTO> relationResultDTOList = employeePositionMap.get(employeeDTO.getId());
                if (relationResultDTOList != null) {
                    employeeDTO.setPositionRelationList(relationResultDTOList);
                    employeeDTO.setPositionName(relationResultDTOList.stream().map(PositionRelationResultDTO::getPositionName).collect(Collectors.joining(",")));
                }
            }
        }
        return ResponseDTO.succData(SmartPageUtil.convert2PageResult(pageParam, employeeList, EmployeeVO.class));
    }


    /**
     * @return
     * @desc 更新禁用状态
     * @author Bryce
     * @date 2021/11/23
     */
    public ResponseDTO<String> updateStatus(Long employeeId, Integer status) {

        if (null == employeeId) {
            return ResponseDTO.wrap(EmployeeResponseCodeConst.EMP_NOT_EXISTS);
        }
        EmployeeBO entity = getById(employeeId);
        if (null == entity) {
            return ResponseDTO.wrap(EmployeeResponseCodeConst.EMP_NOT_EXISTS);
        }
        List<Long> empIds = Lists.newArrayList();
        empIds.add(employeeId);
        employeeDao.batchUpdateStatus(empIds, status);
        employeeCache.remove(employeeId);

        return ResponseDTO.succ();
    }
}
