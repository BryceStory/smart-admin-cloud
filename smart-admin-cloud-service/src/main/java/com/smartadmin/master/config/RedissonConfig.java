//package com.smartadmin.master.config;
//
//import com.smartadmin.master.utils.SmartRedisUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//
//import java.io.File;
//import java.io.IOException;
//
///**
// * @author Bryce
// * @desc
// * @date 2021/11/25
// */
//
//@Slf4j
//@Configuration
//@ConditionalOnProperty(name = "redisson.file", matchIfMissing = false)
//public class RedissonConfig {
//    @Autowired
//    private ResourceLoader resourceLoader;
//
//    @Value("${redisson.file}")
//    private String redissonPath;
//
//    public final static String CONFIG_PATH = "config/";
//
//    @Bean
//    public RedissonClient redisson() throws IOException {
//        if (StringUtils.isBlank(redissonPath)) {
//            log.error("--the redissonPath is null,redissonPath=" + redissonPath);
//            return null;
//        }
//
//        Config config = null;
//
//        try {
////            Resource resource = resourceLoader.getResource(redissonPath);
////            File file = resource.getFile();
//            File file = new File(redissonPath);
//            log.info("----file=" + file.getPath());
//            config = Config.fromYAML(file);
//            log.info("----config=" + config.toYAML());
//            RedissonClient redissonClient = Redisson.create(config);
//            SmartRedisUtil.initRedissonClient(redissonClient);
//            return redissonClient;
//
//        } catch (Exception e) {
//            log.info("----无法通过外部文件加载redisson配置，重新从jar包的resource目录获取");
//            config = Config.fromYAML(Thread.currentThread().getContextClassLoader().getResource(redissonPath));
//            RedissonClient redissonClient = Redisson.create(config);
//            SmartRedisUtil.initRedissonClient(redissonClient);
//            return redissonClient;
//        }
//    }
//
//
//}
