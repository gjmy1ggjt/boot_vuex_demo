package com.example.demo.utils.bianlichannel;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import com.example.demo.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.demo.utils.bianlichannel.Consts.*;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedRate = 5000)
    private void configureTasks() {

        for (Integer channel : channelList) {

            Map<String, Object> row = new LinkedHashMap<>();
            row.put("deviceCode设备码", DEVICE_CODE);
            row.put("货道", channel);
            row.put("层数", grade);

            boolean bhd = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + channel + POINT + grade);

            Object finishNumber = redisTemplate.opsForValue().get(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + channel + POINT + grade);

            row.put("完成后返回数字", finishNumber);

            row.put("设备转动时间", "暂时无法获取");

            row.put("获取数据的时间", DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_PATTERN));

            list.add(row);
        }
        count ++ ;
        System.out.println("定时任务开启" + count);
        if (count == excelSize) {
            System.out.println("开始生成excel");
            count = 0;

            ExcelUtils excelUtils = new ExcelUtils();
            excelUtils.exportLocal("E:/test/writeMapTest" + DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_PATTERN) + ".xlsx" , list);
            list = new ArrayList<>(excelSize);
        }
    }

    public static String requestGet(String url, Map paramMap) {

        String result = HttpRequest.get(url)
                .header("token", TOKEN)//头信息，多个头信息多次调用此方法即可
                .form(paramMap)
                .execute().body();

        return result;
    }
}