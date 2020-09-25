package com.example.demo.utils.bianlichannel;

import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Consts {

//    每50次 生成一个 excel
    public static int EXCEL_SIZE = 50;

    public static int EXCEL_LIST_SIZE = 50 * 8;

    public final static String NETTY_DEVICE_STATUS = "netty_device_status_";

    public final static String DEVICE_PUSH_STATUS = "device_push_status_";

    public final static String DEVICE_CODE = "1059450058";

    public final static String POINT = ",";

    public final static String TOKEN = "token";

    public static List<Map> excelExportList = new ArrayList<>(EXCEL_SIZE);

    public static List<Integer> channelList = ListUtil.of(1, 2, 3, 4, 5, 6, 7, 9);

    public static String GRADE = "1";

    public static int COUNT = 0;

//    定时5分钟
    public static final long TOUCH_LINE_TIME = 1000 * 60 * 5L;

    public static final long TOUCH_TEST_TIME = 1000 * 60 * 1L;

    public static String PUSH_BATCH_URL = "https://sapi-test.bianli24.com/superpeanut/device/push/batch";
//    public static String PUSH_BATCH_URL = "https://sapi.bianli24.com/superpeanut/device/push/batch";

    public static String PUSH_BATCH_PARAMS = "3qMKrgQDwptmkiBiHo3M4QQ85fRtxGhAW1246fczNxQ8NX2MAFLcpNHSvFB8+kFY2v5TLrJLFcKdlshnEQpL1FxlPXoY+ZlWoCLDF8ONjqLLmO5CIGGRZagS+LeZd0N8pjSwugsCio8dj504H9Ob9vaQbmj/ZGmtSV0FJaFslT8/wVqEYRb7Ugz+bQwhuT8tSAHX5w5AXWdXNo4Mp+OHvnTar72k7QyQoSvJYOHAnrQ=";



}
