package com.smartadmin.master.module.system.privilege.service;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.smartadmin.master.common.exception.SmartBusinessException;
import com.smartadmin.master.module.system.privilege.domain.entity.PrivilegeEntity;
import com.smartadmin.master.module.system.systemconfig.SystemConfigService;
import com.smartadmin.master.module.system.systemconfig.constant.SystemConfigEnum;
import com.smartadmin.master.module.system.systemconfig.domain.dto.SystemConfigDTO;
import com.smartadmin.master.utils.SmartStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
@Service
public class PrivilegeEmployeeService {

    @Autowired
    private SystemConfigService systemConfigService;
    /**
     * 后台用户权限缓存 <id,<controllerName,methodName></>></>
     */
    private ConcurrentMap<Long, Map<String, List<String>>> employeePrivileges = new ConcurrentLinkedHashMap.Builder<Long, Map<String, List<String>>>().maximumWeightedCapacity(1000).build();
    private ConcurrentMap<Long, List<PrivilegeEntity>> employeePrivilegeListMap = new ConcurrentLinkedHashMap.Builder<Long, List<PrivilegeEntity>>().maximumWeightedCapacity(1000).build();

    /**
     * @return
     * @desc 判断是否为超级管理员
     * @author Bryce
     * @date 2021/11/23
     */
    public boolean isSuperman(Long employeeId) {
        SystemConfigDTO systemConfig = systemConfigService.getCacheByKey(SystemConfigEnum.Key.EMPLOYEE_SUPERMAN);
        if (systemConfig == null) {
            throw new SmartBusinessException("缺少配置项" + SystemConfigEnum.Key.EMPLOYEE_SUPERMAN + "]");
        }

        List<Long> superManIdList = SmartStringUtil.splitConvertToLongList(systemConfig.getConfigValue(), ",");
        return superManIdList.contains(employeeId);

    }
}
