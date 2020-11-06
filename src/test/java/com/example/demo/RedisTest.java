//package com.example.demo;
//
//
//import cn.hutool.core.lang.Console;
//import cn.hutool.cron.CronUtil;
//import cn.hutool.cron.task.Task;
//import com.example.demo.utils.RedisUtils;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static com.example.demo.MyJob.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RedisTest {
//    @Autowired
//    private RedisUtils redisUtils;
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//
//    @Test
//    public void contextLoads() {
////		redisUtils.set("user", user);
//
//        boolean b = redisTemplate.hasKey(NETTY_DEVICE_STATUS + DEVICE_CODE);
//
////        Object obj = redisTemplate.opsForValue().get(NETTY_DEVICE_STATUS + DEVICE_CODE);
////
////        String bytesss = stringRedisTemplate.opsForValue().get(NETTY_DEVICE_STATUS + DEVICE_CODE);
//
//        boolean bhd1 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 1 + POINT + 1);
//        boolean bhd2 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 2 + POINT + 1);
//        boolean bhd3 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 3 + POINT + 1);
//        boolean bhd4 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 4 + POINT + 1);
//        boolean bhd5 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 5 + POINT + 1);
//        boolean bhd6 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 6 + POINT + 1);
//        boolean bhd7 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 7 + POINT + 1);
//        boolean bhd9 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 9 + POINT + 1);
//
//        Object shd = redisTemplate.opsForValue().get(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 1 + POINT + 1);
//
////		System.out.println(unserialize(bytes.getBytes()) + "---------------------");
////		System.out.println(status + "---------------------");
//
//    }
//
//    @Test
//    public void test() {
//        CronUtil.schedule("*/2 * * * * *", new Task() {
//            @Override
//            public void execute() {
//                Console.log("Task excuted.");
//            }
//        });
//
//// 支持秒级别定时任务
//        CronUtil.setMatchSecond(true);
//        CronUtil.start();
//    }
//
////    @Test
////    public void testWork() throws SchedulerException {
////        MainScheduler mainScheduler = new MainScheduler();
////        mainScheduler.schedulerJob();
////    }
//
//}
