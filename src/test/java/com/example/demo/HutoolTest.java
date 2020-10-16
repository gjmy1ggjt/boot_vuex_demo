package com.example.demo;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import org.apache.catalina.security.SecurityUtil;

import java.io.File;
import java.util.Date;

public class HutoolTest {

    public static void main(String[] args) {
        File file = new File("E:\\test\\excel - 副本.zip");

        System.out.println(file.getName());
        String md5 = SecureUtil.md5(file);

        System.out.println(md5);
    }


}
