//package com.smartadmin.master.utils;
//
//import org.redisson.api.RBucket;
//import org.redisson.api.RedissonClient;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Bryce
// * @desc
// * @date 2021/11/25
// */
//public class SmartRedisUtil {
//
//    private static RedissonClient redissonClient;
//
//    public static void initRedissonClient(RedissonClient redissonClient) {
//        if (redissonClient != null) {
//            SmartRedisUtil.redissonClient = redissonClient;
//        }
//    }
//
//    /***
//     *
//     *@desc 获得RedissonClient对象
//     *@return org.redisson.api.RedissonClient
//     *@author Bryce
//     *@date 2021/11/25
//     */
//    public static RedissonClient getClient() {
//        return SmartRedisUtil.redissonClient;
//    }
//
//    /***
//     *
//     *@desc 将key对应的存货时间设置为liveSeconds
//     *@return
//     *@author Bryce
//     *@date 2021/11/25
//     */
//    public static void expire(String key, long liveSeconds) {
//        RBucket<Object> objectRBucket = SmartRedisUtil.redissonClient.getBucket(key);
//        objectRBucket.expire(liveSeconds, TimeUnit.SECONDS);
//    }
//
//    /***
//     *
//     *@desc 将对应的value值存入redis对应的key中
//     *@return
//     *@author Bryce
//     *@date 2021/11/25
//     */
//    public static void set(String key, String value) {
//        RBucket<Object> bucket = SmartRedisUtil.redissonClient.getBucket(key);
//        bucket.set(value);
//    }
//
//}
