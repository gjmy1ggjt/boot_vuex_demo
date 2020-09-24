package com.example.demo.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Slf4j
public class ExcelUtils {
    /**
     * 导出
     * @param response
     * @param fileName
     * @param rows
     */
    public void export(HttpServletResponse response, String fileName, List<Map> rows){
//        Assert.isBlank(fileName,"文件名不能为空");
        ExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getWriter();
        writer.write(rows, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        try {
            response.setHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes(), "ISO-8859-1")+".xlsx");
        } catch (UnsupportedEncodingException e) {
            log.error("编码格式不支持");
        }
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            writer.flush(out);
            writer.close();
        } catch (IOException e) {
            log.error("导出Excel错误",e);
        }finally {
            IoUtil.close(out);
        }
    }

    public void exportLocal(String fileName, List<Map> rows){

        ExcelWriter writer = ExcelUtil.getWriter(fileName);
// 合并单元格后的标题行，使用默认标题样式
//        writer.merge(rows.size() - 1, "一班成绩单");
// 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);
// 关闭writer，释放内存
        writer.close();

    }

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", cn.hutool.core.date.DateUtil.date());

        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());

        List<Map> rows = CollUtil.newArrayList(row1, row2);
        excelUtils.exportLocal("E:/test/writeTest.xlsx", rows);
    }
}
