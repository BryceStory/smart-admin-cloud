package com.smartadmin.master.module.system.systemconfig.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.smartadmin.master.common.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
@Data
@TableName(value = "t_system_config")
public class SystemConfigEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5238504854767312848L;

    /**
     * 参数key
     */
    private String configKey;

    /**
     * 参数的值
     */
    private String configValue;

    /**
     * 参数名称
     */
    private String configName;

    /**
     * 参数类别
     */
    private String configGroup;

    /**
     * 是否使用0 是 1否
     */
    private Integer isUsing;

    /**
     * 备注
     */
    private String remark;
}
