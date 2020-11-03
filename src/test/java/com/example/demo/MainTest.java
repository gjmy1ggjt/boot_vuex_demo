package com.example.demo;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.*;

public class MainTest {

    public static void main(String[] args) {
//        testScheduleThread();
//        testScheduleRoundThread();
//        testFixedThread2();
   String x = "http://10.10.1.139:8912/wx_mini_contract/signUrlByRecordId?recordId=94&type=wxe";

   String y = "wx_mini_contract/signUrlByRecordId";
//   String y = "wx_mini_contract//signUrlByRecordId";


//        System.out.println(x.contains(y));
//        hanzi_daozhuang();

        Object s = 1110;

        if (s instanceof Number) {
            System.out.println("num");
        }

    }

    public static void hanzi_daozhuang(){
        String name = "林卓吧";

        int length = name.length();

        String first = name.substring(0, 1);
        String last = name.substring(1, length);
        System.out.println("f" + first + "-----last" + last);

    }

    public static void testCacheThread() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }

    public static void testFixedThread() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {


                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void testFixedThread2() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;

            FixedTask fixedTask = new FixedTask();

            fixedThreadPool.execute(fixedTask);
        }
    }

    public static void testScheduleThread() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
    }

    public static void testScheduleRoundThread() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
    }

    public static void testSingleThread() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    static class FixedTask implements Runnable {

        @Override
        public void run() {
            System.out.println("测试 FixedTask");
        }
    }

     static class FixedTask2 implements Callable {

         @Override
         public Object call() throws Exception {
             System.out.println("测试 FixedTask");
             return null;
         }
     }




}
