package com.example.demo.controller;

import com.example.demo.entity.StaticFileObj;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.DataGrid;
import com.example.demo.utils.RedisUtils;
import com.example.demo.utils.excel.ExcelData;
import com.example.demo.utils.excel.ExportExcelUtils;
import com.example.demo.vo.UserListRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/23.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "path/{id}", method = RequestMethod.GET)
    public DataGrid<User> getPath(@PathVariable("id") String id) {
        return userService.getOne(id);
    }

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public DataGrid<User> getParam(@RequestParam("id") String id) {

        return userService.getOne(id);
    }

    @RequestMapping(value = "/one/formdate", method = RequestMethod.GET)
    public DataGrid<User> getFormdate(String id) {

        return userService.getOne(id);
    }

    @RequestMapping(value = "/save_json", method = RequestMethod.POST)
    public DataGrid<String> saveJson(@RequestBody User user) {

        return userService.save(user);
    }

    @RequestMapping(value = "/save_formdata", method = RequestMethod.POST)
    public DataGrid<String> saveFormdata(User user) {

        return userService.save(user);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public DataGrid<String> delete(@PathVariable("id") String id) {

        return userService.deleteOne(id);
    }

    @RequestMapping(value = "/delete/one", method = RequestMethod.GET)
    public DataGrid<String> deleteParam(@RequestParam("id") String id) {

        return userService.deleteOne(id);
    }

    @RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
    public DataGrid<String> deleteBatch(@RequestParam("listId") List<String> listId) {

        return userService.deleteBatch(listId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public DataGrid<String> update(@RequestBody User user) {

        return userService.update(user);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public DataGrid<User> list(@RequestBody UserListRequestVo requestVo) {

        return userService.list(requestVo);
    }

    @RequestMapping(value = "/drop", method = RequestMethod.GET)
    public DataGrid<User> drop() {

        return userService.dropUser();
    }

    @RequestMapping(value = "/data/reset", method = RequestMethod.GET)
    public DataGrid<String> reset() {

        return userService.resetDatas();
    }

    @RequestMapping(value = "/data/uploadImg", method = RequestMethod.POST)
    public DataGrid<StaticFileObj> uploadImg(@RequestParam("file") MultipartFile file) {

        return userService.uploadImg(file);
    }

    @RequestMapping(value = "/excel/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) {

        List<String> titleList = new ArrayList<>();

        List<List<Object>> rows = new ArrayList<>();

        if (titleList.size() == 0) {

            titleList.add("序号");
            titleList.add("类名位置");
            titleList.add("方法名");
            titleList.add("意思描述");
            titleList.add("原始提示文字");
            titleList.add("最终提示中文");
            titleList.add("最终提示英文");
        }
        String fileName = "导出excel" + System.currentTimeMillis() + ".xlsx";
        ExcelData excelData = new ExcelData();
        excelData.setName("导出excel");
        excelData.setRows(rows);
        excelData.setTitles(titleList);

        try {
            ExportExcelUtils.exportExcel(response, "导出excel.xlsx", excelData);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


