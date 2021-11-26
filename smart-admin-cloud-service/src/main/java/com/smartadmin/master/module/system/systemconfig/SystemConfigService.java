package com.smartadmin.master.module.system.systemconfig;

import com.smartadmin.master.module.system.systemconfig.constant.SystemConfigEnum;
import com.smartadmin.master.module.system.systemconfig.domain.dto.SystemConfigDTO;
import com.smartadmin.master.module.system.systemconfig.domain.entity.SystemConfigEntity;
import com.smartadmin.master.utils.SmartBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Bryce
 * @desc
 * @date 2021/11/23
 */
@Slf4j
@Service
public class SystemConfigService {
    /**
     * 系统配置缓存
     */
    private ConcurrentHashMap<String, SystemConfigEntity> systemConfigMap = new ConcurrentHashMap<>();

    public SystemConfigDTO getCacheByKey(SystemConfigEnum.Key key) {
        SystemConfigEntity entity = this.systemConfigMap.get(key.name().toLowerCase());
        if (entity == null) {
            return null;
        }
        return SmartBeanUtil.copy(entity, SystemConfigDTO.class);
    }

}
