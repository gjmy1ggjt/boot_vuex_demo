package com.example.demo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MkDirsTest {

    private static int ADD_YEAR = 2;

    private static int ADD_MONTH = 1;

    private static String SPLIT_TIME = "\\";

    private static String PAN_PATH = "E:\\test\\dir_time";

    public static void mkdir(String path) {
        File fd = null;
        try {
            fd = new File(path);
            if (!fd.exists()) {
                fd.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fd = null;
        }
    }


    public static void nowYearsTime() {

        Calendar now = Calendar.getInstance();

        System.out.println(now.get(Calendar.YEAR));
        System.out.println(now.get(Calendar.MONDAY) + 1);
        System.out.println(now.get(Calendar.DAY_OF_MONTH));

    }

    public static void towYearsTime() {

        Calendar now = Calendar.getInstance();

        System.out.println(now.get(Calendar.YEAR) + 2);
        System.out.println(now.get(Calendar.MONDAY) + 1);
        System.out.println(now.get(Calendar.DAY_OF_MONTH));

    }

    public static void main(String[] args) {

//        nowYearsTime();
//        towYearsTime();
        dirTwoYears();
    }

    public static void dirTwoYears() {

        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);

        int endYear = year + ADD_YEAR;

        int month = now.get(Calendar.MONDAY) + 1;

        int day = now.get(Calendar.DAY_OF_MONTH);

        for (int y = year; y <= endYear; y++) {

            if (y == year) {

                for (int m = month; m <= 12; m++) {

                    if (m == month) {

                        for (int d = day; d <= getLastDayByMonth(); d++) {

                            String path = PAN_PATH + getTimePath(y) + getTimePath(m) + getTimePath(d);

                            mkdir(path);
                        }

                    } else {

                        for (int d = 1; d <= getLastDayByMonth(); d++) {

                            String path = PAN_PATH + getTimePath(y) + getTimePath(m) + getTimePath(d);

                            mkdir(path);
                        }
                    }
                }
            } else {

                for (int m = 1; m <= 12; m++) {

                    for (int d = 1; d <= getLastDayByMonth(); d++) {

                        String path = PAN_PATH + getTimePath(y) + getTimePath(m) + getTimePath(d);

                        mkdir(path);
                    }
                }
            }
        }
    }

    private static String getTimePath(int time) {

        return SPLIT_TIME + time;
    }

    private static int getLastDayByMonth() {
        Calendar cale = Calendar.getInstance();
        cale = Calendar.getInstance();
        return cale.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
