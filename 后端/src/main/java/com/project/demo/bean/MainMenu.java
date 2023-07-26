package com.project.demo.bean;

import lombok.Data;

import java.util.Date;
import java.util.List;

//主菜单
@Data
public class MainMenu {
    private int Id;
    private String title;
    private String path;
    private Date addTime;
    private List<SubMenu> sList;
}
