package com.example.demo;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.json.JSONUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HutoolTest {

    //    private static byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
    private static byte[] key = "abcdabcdabcdabcd".getBytes();

    public static void main(String[] args) {

//        File file = new File("E:\\test\\excel - 副本.zip");
//
//        System.out.println(file.getName());
//        String md5 = SecureUtil.md5(file);
//       String s = testIn();
//        testOut(s);
//        System.out.println("bianli24服务".getBytes());

//        String content = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJtZW1iZXJfaWQiOiIxMCIsImlhdCI6MTYwMzI2ODE5NSwicGxhdGZvcm0iOiJDT05UUkFDVF9CRCJ9.xKefUfQYc6rCCu9T-uqOFW6raNQyUMzRpw0K3Fn3DUU";
////
////        String recordId = "123";
////
////        String pefix = testIn(content + "_" + recordId);
////
////        System.out.println(pefix);
////
////        testOut(pefix);

//        nameList();

        timeCompare("2020-10-24", "2022-10-03");
//        NumberTest();
    }

    public static void nameList() {

        List<String> listName = ListUtil.list(true,
                "黄鸿光",
                "吴利容", "李德洪", "瞿志远",
                "刘时爱", "严春辉", "周石初",
                "游桥生", "李智彪", "周龙田",
                "廖天宇", "潘彬科", "张祖骏",
                "申彬", "汪朋", "林卓崇",
                "米向明", "黄荣州", "冯文斐",
                "郑彬", "刘时峰", "朱杰",
                "黄柏樑", "罗闯", "唐俊杰"

        );

        System.out.println("listName" + listName.size());

        List<String> nameList = ListUtil.list(true, listName);

        Map map = pinyinPWDTest(nameList);

        System.out.println(JSONUtil.parseObj(map));
        System.out.println(map.size());

    }


    public static Map<String, String> pinyinPWDTest(List<String> listName) {

        Map<String, String> map = new LinkedHashMap<>();

        for (String name : listName) {

            map.put(PinyinUtil.getPinyin(name, ""), password(name));

        }

        return map;
    }

    public static String password(String name) {

        String email = "@bianli24.com";

        int length = name.length();

        String first = name.substring(0, 1);
        String last = name.substring(1, length);

        String pinyinFirst = PinyinUtil.getPinyin(first, "");
        String pinyinLast = PinyinUtil.getPinyin(last, "");

        String pwd = pinyinLast + "." + pinyinFirst + email;

        return pwd;
    }


    public static String testIn(String content) {
        AES aes = SecureUtil.aes(key);

        return aes.encryptHex(content);
    }

    public static void testOut(String encryptHex) {
        AES aes = SecureUtil.aes(key);

        System.out.println(aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8));
    }

    public static void timeCompare(String startTime, String endTime) {

        int compare = DateUtil.compare(DateUtil.parseDate(startTime), DateUtil.parseDate(endTime));
        long year = DateUtil.betweenYear(DateUtil.parseDate(startTime), DateUtil.parseDate(endTime), true);
        System.out.println(compare);
        System.out.println("year" + year);
    }

    public static void NumberTest() {

        Integer i = 1;
        Long l = 1L;
        System.out.println("i.equals(l)" + String.valueOf(i).equals(String.valueOf(l)));
    }


}
