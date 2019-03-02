package com.utravel.service.impl;

import com.utravel.common.JsonBean;
import com.utravel.dao.UserMapper;
import com.utravel.domain.User;
import com.utravel.service.UserService;
import com.utravel.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Override
    public User login(User user) {

        User user1 = userDao.selectByName(user.getUname());

        if (user1 == null){
            throw new RuntimeException("用户不存在");
        }else if (!user1.getPassword().equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }else{
             return user1;
        }
    }

    @Override
    public void refister(User user) {
        User user1 = userDao.selectByName(user.getUname());
        if (user1!=null){
            throw new RuntimeException("用户名已存在");
        } else {
            userDao.insertSelective(user);
        }
    }

    @Override
    public void updateUser(User user) {
        User user1 = userDao.selectByName(user.getUname());
        if ((user1!=null)&& (user1.getUid()!=user.getUid())){
            throw new RuntimeException("该名号不可用");
        }else {
            userDao.updateByPrimaryKeySelective(user);
        }
    }

}
