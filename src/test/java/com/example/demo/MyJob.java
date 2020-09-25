//package com.example.demo;
//
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.core.collection.ListUtil;
//import cn.hutool.core.date.DatePattern;
//import cn.hutool.core.date.DateUtil;
//import cn.hutool.core.date.LocalDateTimeUtil;
//import cn.hutool.http.Header;
//import cn.hutool.http.HttpRequest;
//import cn.hutool.http.HttpUtil;
//import com.example.demo.utils.ExcelUtils;
//import org.junit.runner.RunWith;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class MyJob implements Job {
//
//    private static int excelSize = 10;
//
//    public final static String NETTY_DEVICE_STATUS = "netty_device_status_";
//
//    public final static String  DEVICE_PUSH_STATUS = "device_push_status_";
//
//    public final static String DEVICE_CODE = "1059450058";
//
//    public final static String POINT = ",";
//
//    public final static String TOKEN = "token";
//
//    public static List<Map> list = new ArrayList<>(excelSize);
//
//    public static List<Integer> channelList = ListUtil.of(1, 2, 3, 4, 5, 6, 7, 9);
//
//    public static String grade = "1";
//
//    public static int count = 0;
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    public void execute(JobExecutionContext context)
//            throws JobExecutionException {
//
//        for (Integer channel : channelList) {
//
//            Map<String, Object> row = new LinkedHashMap<>();
//            row.put("deviceCode设备码", DEVICE_CODE);
//            row.put("货道", channel);
//            row.put("层数", grade);
//
//            Object finishNumber = "redis不存在返回数字的key" + DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + channel + POINT + grade;
//            boolean bhd = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + channel + POINT + grade);
//
//            if (true == bhd) {
//                finishNumber  = redisTemplate.opsForValue().get(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + channel + POINT + grade);
//            }
//            row.put("完成后返回数字", finishNumber);
//
//            row.put("设备转动时间", "暂时无法获取");
//
//            row.put("获取数据的时间", DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_PATTERN));
//
//            list.add(row);
//        }
//        count ++ ;
//
//        if (count == excelSize) {
//            count = 0;
//
//            ExcelUtils excelUtils = new ExcelUtils();
//            excelUtils.exportLocal("E:/test/writeMapTest" + DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_PATTERN) + ".xlsx" , list);
//            list = new ArrayList<>(excelSize);
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println();
//
//    }
//
//    public static String requestGet(String url, Map paramMap) {
//
//        String result = HttpRequest.get(url)
//                .header("token", TOKEN)//头信息，多个头信息多次调用此方法即可
//                .form(paramMap)
//                .execute().body();
//
//        return result;
//    }
//
//
//    @Scheduled(cron = "0 0 */2 * * ?")//每隔两个小时执行一次
//    public void work() {
//        boolean bhd = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 1 + POINT + grade);
//
//    }
//}