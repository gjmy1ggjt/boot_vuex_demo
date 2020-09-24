package com.example.demo.utils.bianlichannel;

import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Consts {

    public static int excelSize = 10;

    public final static String NETTY_DEVICE_STATUS = "netty_device_status_";

    public final static String  DEVICE_PUSH_STATUS = "device_push_status_";

    public final static String DEVICE_CODE = "1059450058";

    public final static String POINT = ",";

    public final static String TOKEN = "token";

    public static List<Map> list = new ArrayList<>(excelSize);

    public static List<Integer> channelList = ListUtil.of(1, 2, 3, 4, 5, 6, 7, 9);

    public static String grade = "1";

    public static int count = 0;
}
