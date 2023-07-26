package com.project.demo.dao;

import com.project.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//mapper层

@Repository
public interface UserDao {
    //获取信息
    public List<User> getUserList(User user);
    //注册用户
    public int addUser(User user);
}
