package com.project.demo.bean;

import lombok.Data;

import java.util.Date;

@Data
public class EmailVcode {
   private int Id;
   private String email;
   private String vcode;
   private Date addTime;
}
