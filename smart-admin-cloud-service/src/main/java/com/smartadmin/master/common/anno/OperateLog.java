package com.smartadmin.master.common.anno;

import java.lang.annotation.*;

/**
 * @author Bryce
 * @desc [ 用户操作日志 ]
 * @date 2021/11/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface OperateLog {
}
