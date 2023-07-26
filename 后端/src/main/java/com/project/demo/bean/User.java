package com.project.demo.bean;

import lombok.Data;

import java.util.Date;

//用户实体类
@Data
public class User {
    private int Id;//主键
    private String userId;
    private String name;
    private String password;
    private String email;
    private String image;
    private Date addTime;

    //验证码
    private String vcode;
}
