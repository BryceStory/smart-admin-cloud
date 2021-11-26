package com.smartadmin.master.module.system.position;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smartadmin.master.module.system.position.domain.dto.PositionRelationResultDTO;
import com.smartadmin.master.module.system.position.domain.entity.PositionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/19
 */
@Mapper
@Component
public interface PositionDao extends BaseMapper<PositionEntity> {

    /**
     * 批量查询员工岗位信息
     *
     * @param employeeIdList
     * @return
     */
    List<PositionRelationResultDTO> selectEmployeesRelation(@Param("employeeIdList") List<Long> employeeIdList);
}
