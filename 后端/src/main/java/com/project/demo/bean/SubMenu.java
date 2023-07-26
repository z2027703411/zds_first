package com.project.demo.bean;

import lombok.Data;

import java.util.Date;

//二级菜单实体类
@Data
public class SubMenu {
    private int Id;
    private String title;
    private String path;
    private String mid;
    private Date addTime;
}
