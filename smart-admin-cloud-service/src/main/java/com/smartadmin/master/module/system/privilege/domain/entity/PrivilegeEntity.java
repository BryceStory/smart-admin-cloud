package com.smartadmin.master.module.system.privilege.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.smartadmin.master.common.domain.BaseEntity;

import java.io.Serializable;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
public class PrivilegeEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7454048316440813226L;

    /**
     * 功能权限类型：1.模块 2.页面 3.功能点 4.子模块
     */
    private Integer type;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 路由name 英文关键字
     */
    @TableField(value = "`key`")
    private String key;


    private String url;

    /**
     * 排序
     */
    private Integer sort;


    /**
     * 父级key
     */
    private String parentKey;
}
