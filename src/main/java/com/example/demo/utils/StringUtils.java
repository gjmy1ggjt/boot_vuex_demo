package com.example.demo.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/23.
 */
public class StringUtils {

    public static boolean isNotBlank(String s) {

        if (s == null || s.length() <= 0) {

            return false;

        } else {

            return true;
        }
    }

    public static boolean isBlank(String s) {
        return !isNotBlank(s);
    }

    public static void main(String[] args) {
        List<String> listStr = new ArrayList<>();

        List<String> listEmp = null;

        Map map = null;

        Map map1 = new HashMap();

        System.out.println(CollUtil.isEmpty(listStr));
        System.out.println(CollUtil.isNotEmpty(listEmp));

        System.out.println(CollUtil.isNotEmpty(map));
        System.out.println(CollUtil.isEmpty(map1));


        for (int i = 1; i <= 100; i++) {

            listStr.add(i + "");

        }

        List<String> l = ListUtil.page(5, 10, listStr);
        System.out.println(l.toString());
    }

}
