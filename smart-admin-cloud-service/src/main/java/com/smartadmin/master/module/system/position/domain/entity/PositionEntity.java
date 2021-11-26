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
@TableName("t_position")
public class PositionEntity extends BaseEntity {

    /**
     * 岗位名称
     */
    private String positionName;

    /**
     * 岗位描述
     */
    private String remark;

}
