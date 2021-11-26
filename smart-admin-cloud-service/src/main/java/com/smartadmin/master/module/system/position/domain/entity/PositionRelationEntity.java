package com.smartadmin.master.module.system.position.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.smartadmin.master.common.domain.BaseEntity;
import lombok.Data;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/19
 */
@Data
@TableName("t_position_relation")
public class PositionRelationEntity extends BaseEntity {

    /**
     * 岗位ID
     */
    private Long positionId;

    /**
     * 员工ID
     */
    private Long employeeId;

}
