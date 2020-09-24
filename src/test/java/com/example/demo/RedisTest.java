package com.example.demo;


import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import static com.example.demo.MyJob.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void contextLoads() {
//		redisUtils.set("user", user);

        boolean b = redisTemplate.hasKey(NETTY_DEVICE_STATUS + DEVICE_CODE);

        Object obj = redisTemplate.opsForValue().get(NETTY_DEVICE_STATUS + DEVICE_CODE);

        String bytesss = stringRedisTemplate.opsForValue().get(NETTY_DEVICE_STATUS + DEVICE_CODE);

        boolean bhd = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 1 + POINT + 1);

        Object shd = redisTemplate.opsForValue().get(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 1 + POINT + 1);

        JSONObject jsonObject = JSONObject.parseObject(bytesss);
//		System.out.println(unserialize(bytes.getBytes()) + "---------------------");
//		System.out.println(status + "---------------------");

    }

    @Test
    public void test() {
        CronUtil.schedule("*/2 * * * * *", new Task() {
            @Override
            public void execute() {
                Console.log("Task excuted.");
            }
        });

// 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }

    @Test
    public void testWork() throws SchedulerException {
        MainScheduler mainScheduler = new MainScheduler();
        mainScheduler.schedulerJob();
    }

}
