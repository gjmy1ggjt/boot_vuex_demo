package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

//    用户id - 新增时后台产生唯一主键
    private String id;

//    用户角色
    private String code;

//    用户名称
    private String name;

    //    用户性别
    private String sex;

    //    用户年龄
    private Integer age;

    private Date birth;

//    用户地址
    private String textarea;

    //  用户照片
    private String photoUrl;

//    关联老师id
    private String teacherId;
}
