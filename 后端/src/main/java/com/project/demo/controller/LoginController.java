package com.project.demo.controller;

import com.project.demo.bean.EmailVcode;
import com.project.demo.bean.User;
import com.project.demo.dao.EmailVcodeDao;
import com.project.demo.dao.UserDao;
import com.project.demo.util.AjaxResult;
import com.project.demo.util.EmailSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@RestController
public class LoginController {
//    @CrossOrigin

    @Autowired//注入
     UserDao userDao;
    //测试用的
    @RequestMapping("/test")
    public String test(){
        Random ne=new Random();//实例化一个random的对象ne

        int x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
        String userId= UUID.randomUUID().toString().replaceAll("-","");
        System.out.println("产生的随机数是:"+x);//输出
        System.out.println("userId"+userId);
        return "ok";
    }



    //登录
    @RequestMapping("/login")
    public AjaxResult login(@RequestBody User user){
        System.out.println(user);
        List<User> userList = userDao.getUserList(user);
        if(userList.size()!=0){
            System.out.println(userList.get(0));
            return AjaxResult.result("200","success",userList.get(0));
        }else{
            return AjaxResult.result("100","fail",userList.get(0));
        }
    }

    @Autowired
    EmailVcodeDao emailVcodeDao;

    //这个方法是来看这个邮箱存在了没有
    public boolean isEmail(String email){
        User user=new User();
        user.setEmail(email);
        List<User> userList = userDao.getUserList(user);
        if(userList.size()!=0){
            return true;
        }else{
            return false;
        }
    }

    //发送qq邮箱验证码接口
    @RequestMapping("/sendEmail")
    public AjaxResult sendEmail(String email,int state){
        //这里前端要先处理一下，当点下获取验证码按钮时候在60秒内不能再点击，后台就不用去判断他有没有重复点击获取验证码

        //这里如果想判断邮箱是否存在
        if(state==1){
            boolean b= isEmail(email);
            if(b==true){
                return AjaxResult.result("303","账户已经存在",null);
            }
        }

        //随机生成4位数字作为验证码
        Random ne=new Random();
        int vcode=ne.nextInt(9999-1000+1)+1000;

        EmailVcode emailVcode=new EmailVcode();
        emailVcode.setAddTime(new Date());
        emailVcode.setEmail(email);
        emailVcode.setVcode(vcode+"");

        try {
            EmailSend.sendMail(email,vcode+"");
            /**保存邮箱验证码在数据库中**/
            emailVcodeDao.addVcode(emailVcode);
            return AjaxResult.result("200","success",null);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.result("404","fail",null);
        }
    }

    //注册接口
    @RequestMapping("/register")
    public AjaxResult register(@RequestBody User user){
        //先判断验证码正不正确
        List<EmailVcode> emailVcodes = emailVcodeDao.emailVcodeList(user.getEmail());
        if(emailVcodes.size()==0){
            return AjaxResult.result("404","该邮箱没有验证码",null);
        }else if(emailVcodes.get(0).getVcode().equals(user.getVcode())==false){

            return AjaxResult.result("303","验证码错误",null);
        }else{
            System.out.println("图片："+user.getImage());
            //验证码正确
            user.setAddTime(new Date());
            //利用UUID生成加密Id
            String userId= UUID.randomUUID().toString().replaceAll("-","");
            user.setUserId(userId);
            userDao.addUser(user);
            return AjaxResult.result("200","successs",null);
        }
    }

}
