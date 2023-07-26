package com.project.demo.dao;

import com.project.demo.bean.EmailVcode;
import com.project.demo.util.EmailSend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailVcodeDao {
    //将邮箱验证码保存在数据库中
    public int  addVcode(EmailVcode emailVcode);
    //查询该邮箱的验证码
    public List<EmailVcode>emailVcodeList(String email);

}
