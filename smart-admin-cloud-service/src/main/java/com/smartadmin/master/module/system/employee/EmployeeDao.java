package com.smartadmin.master.module.system.employee;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smartadmin.master.module.system.employee.domain.dto.EmployeeDTO;
import com.smartadmin.master.module.system.employee.domain.dto.EmployeeQueryDTO;
import com.smartadmin.master.module.system.employee.domain.entity.EmployeeEntity;
import com.smartadmin.master.module.system.employee.domain.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bryce
 * @desc 员工dao接口
 * @date 2021/11/19
 */

@Mapper
@Component
public interface EmployeeDao extends BaseMapper<EmployeeEntity> {
    /**
     * 查询员工列表
     *
     * @param page
     * @param queryDTO
     * @return
     */
    List<EmployeeDTO> selectEmployeeList(Page page, @Param("queryDTO") EmployeeQueryDTO queryDTO);
    /**
     * 查询所有员工
     *
     * @return
     */
    List<EmployeeVO> selectAll();

    /**
     * 批量更新禁用状态
     *
     * @param employeeIds
     * @param isDisabled
     */
    void batchUpdateStatus(@Param("employeeIds") List<Long> employeeIds, @Param("isDisabled") Integer isDisabled);
}
