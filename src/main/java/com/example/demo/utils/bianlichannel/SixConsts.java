package com.example.demo.utils.bianlichannel;

import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SixConsts {

    public final static String NETTY_DEVICE_STATUS = "netty_device_status_";

    public final static String DEVICE_PUSH_STATUS = "device_push_status_";

//    public final static String DEVICE_CODE = "1059450058";

    //    public final static String DEVICE_CODE = "1050010003";
//    public final static String DEVICE_CODE = "1050010004";
//    public final static String DEVICE_CODE = "1050010005";
//    public final static String DEVICE_CODE = "1050010007";
    public final static String DEVICE_CODE = "1059450091";

//    public final static String DEVICE_CODE = "1050010010";


    public final static String POINT = ",";

    public final static String TOKEN = "token";

//    public static List<Integer> channelList = ListUtil.of(1, 2, 3, 4, 5, 6, 7, 9);


    public static List<Integer> otherChannelList = ListUtil.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static List<Integer> firstChannelList = ListUtil.of(1, 3, 5, 7, 9);

    public static List<Integer> gradeList = ListUtil.of(1, 2, 3, 4, 5, 6);

    //    每50次 生成一个 excel
    public static int EXCEL_SIZE = 6;

    public static int EXCEL_LIST_SIZE = EXCEL_SIZE * 8;

    public static int COUNT = 0;

    public static List<Map> excelExportList = new ArrayList<>(EXCEL_SIZE);

    //    定时5分钟
    public static final long SLEEP_MORE_MINUTE = 1000 * 60 * 13L;

    public static final long TOUCH_TEST_TIME = 1000 * 60 * 1 * 14L;

    public static String PUSH_BATCH_URL = "https://sapi-test.bianli24.com/superpeanut/device/push/batch";
//    public static String PUSH_BATCH_URL = "https://sapi.bianli24.com/superpeanut/device/push/batch";

    public static String PUSH_BATCH_PARAMS = "3qMKrgQDwptmkiBiHo3M4QQ85fRtxGhAW1246fczNxQ8NX2MAFLcpNHSvFB8+kFY2v5TLrJLFcKdlshnEQpL1FxlPXoY+ZlWoCLDF8ONjqLLmO5CIGGRZagS+LeZd0N8pjSwugsCio8dj504H9Ob9vaQbmj/ZGmtSV0FJaFslT8/wVqEYRb7Ugz+bQwhuT8tSAHX5w5AXWdXNo4Mp+OHvnTar72k7QyQoSvJYOHAnrQ=";


}
