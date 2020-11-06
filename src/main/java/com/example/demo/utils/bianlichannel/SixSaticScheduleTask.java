package com.example.demo.utils.bianlichannel;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.example.demo.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.*;

import static com.example.demo.utils.bianlichannel.SixConsts.*;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SixSaticScheduleTask {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
//        定时7分钟执行一次
    @Scheduled(fixedRate = TOUCH_TEST_TIME)
    private void configureTasks() {

        System.out.println("定时任务开启" + DateUtil.now());

        for (Integer grade : SixConsts.gradeList) {
            List<Integer> channelList = null;

            if (1 == grade) {
                channelList = SixConsts.firstChannelList;
            } else {
                channelList = SixConsts.otherChannelList;
            }
            taskOneGrade(channelList, grade);

        }
//   批量转动的接口是 转动一整个机器
        Map map = new HashMap();
        map.put("params", PUSH_BATCH_PARAMS);
        String result = HttpUtil.post(PUSH_BATCH_URL, map);

        /*try {
//           从redis取值一层货道后, 休眠二分钟, 再取下一次 (也可以直接在调用接口之前 休眠14分钟)
            Thread.sleep(SLEEP_MORE_MINUTE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println("接口请求结果:" + result);
    }

    private void taskOneGrade(List<Integer> channelList, Integer grade) {
        for (Integer channel : channelList) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("deviceCode设备码", DEVICE_CODE);
            row.put("货道", channel);
            row.put("层数", grade + "");

            String finishNumberKey = DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + channel + POINT + grade;

            boolean bhd = redisTemplate.hasKey(finishNumberKey);

            Object finishNumber = "完成转动时, 无法从redis获取转动状态的数字";

            if (bhd) {
                finishNumber = redisTemplate.opsForValue().get(finishNumberKey);
            }
            row.put("完成后返回数字", finishNumber);
            row.put("设备转动时间", "暂时无法获取");
            row.put("获取数据的时间", DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_PATTERN));

            excelExportList.add(row);
        }
        COUNT++;
        Console.log("定时任务开启第{}次, 第{}层的{}货道redis取值完毕", COUNT, grade, channelList);
        System.out.println("定时任务开启第" + COUNT + "次");

        if (COUNT == EXCEL_SIZE) {
            System.out.println("开始生成excel");
            COUNT = 0;
            ExcelUtils excelUtils = new ExcelUtils();
            String fileName = "E:/test/six/excel/" + DEVICE_CODE + "___" + DateUtil.format(new Date(), DatePattern.CHINESE_DATE_TIME_PATTERN) + ".xlsx";
            excelUtils.exportLocal(fileName, excelExportList);
            excelExportList = new ArrayList<>(EXCEL_LIST_SIZE);
        }

    }


    public static String requestGet(String url, Map paramMap) {

        String result = HttpRequest.get(url)//头信息，多个头信息多次调用此方法即可
                .form(paramMap)
                .execute().body();

        return result;
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("params", PUSH_BATCH_PARAMS);
//
//        String result = HttpUtil.post(PUSH_BATCH_URL, map);

        String result = requestGet(PUSH_BATCH_URL, map);

        System.out.println(result);
    }
}