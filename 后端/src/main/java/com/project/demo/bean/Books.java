package com.project.demo.bean;


import lombok.Data;

import java.util.Date;

@Data
public class Books{
    private int Id;
    private String name;
    private boolean state;
    private String stock;
    private String publish;
    private String author;
    private Integer typeId;
    private Date addTime;
}
