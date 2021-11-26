package com.smartadmin.master.module.system.systemconfig.constant;

import com.smartadmin.master.utils.SmartVerificationUtil;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
public enum SystemConfigDataType {
    /**
     * 整数
     */
    INTEGER(SmartVerificationUtil.INTEGER),
    /**
     * 文本
     */
    TEXT(null),
    /**
     * url地址
     */
    URL(SmartVerificationUtil.URL),
    /**
     *  邮箱
     */
    EMAIL(SmartVerificationUtil.EMAIL),
    /**
     * JSON 字符串
     */
    JSON(null),
    /**
     * 2019-08
     */
    YEAR_MONTH(SmartVerificationUtil.YEAR_MONTH),
    /**
     * 2019-08-01
     */
    DATE(SmartVerificationUtil.DATE),
    /**
     * 2019-08-01 10:23
     */
    DATE_TIME(SmartVerificationUtil.DATE_TIME),
    /**
     * 10:23-10:56
     */
    TIME_SECTION(SmartVerificationUtil.TIME_SECTION),
    /**
     * 10:23
     */
    TIME(SmartVerificationUtil.TIME);

    private String valid;


    SystemConfigDataType(String valid){
        this.valid = valid;
    }

    public String getValid() {
        return valid;
    }
}
