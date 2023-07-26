package com.project.demo.util;

import lombok.Data;

//分页封装方法
@Data
public class QueryInfo {
    private String query;//查询信息
    private int pageNum=1;//当前页.第几页开始
    private int pageSize=1;//每页最大数

    //书名
    private String name;
}
