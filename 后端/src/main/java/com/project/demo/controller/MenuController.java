package com.project.demo.controller;

import com.project.demo.bean.MainMenu;
import com.project.demo.dao.MenuDao;
import com.project.demo.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuDao menuDao;
    @RequestMapping("/getAllMenuList")
    public AjaxResult getMainMenuList(){
        List<MainMenu> mainMenuList = menuDao.getMainMenuList();
        if(mainMenuList.size()!=0){
            return AjaxResult.result("200","success",mainMenuList);
        }else{
            return AjaxResult.result("404","fail",mainMenuList);
        }
    }
}
