package com.utravel.controller;

import com.utravel.common.JsonBean;
import com.utravel.domain.User;
import com.utravel.service.UserService;
import com.utravel.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    public JsonBean login(User user, HttpSession session){

        JsonBean bean = null;
        try {
            User u = userService.login(user);
            session.setAttribute("user",u);
           bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
           bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/reg.do")
    public JsonBean register(User user){

        JsonBean bean = null;
        try {
            userService.refister(user);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }


    @RequestMapping("/getUser.do")
    public JsonBean getUser(HttpSession session){
        JsonBean bean = null;
        try {
            User u = (User) session.getAttribute("user");
            if (u!=null){
                bean = JsonUtils.createJsonBean(1,u);
            }else {
                bean = JsonUtils.createJsonBean(0,"未登录");
            }

        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/update.do")
    public JsonBean updateUser(User user,HttpSession session){
        JsonBean bean = null;
        try {
            User u = (User) session.getAttribute("user");
            if (u == null){
                bean = JsonUtils.createJsonBean(0,"用户未登录");
            }else {
                user.setUid(u.getUid());
                userService.updateUser(user);
                bean = JsonUtils.createJsonBean(1,null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/quit.do")
    public JsonBean quit(HttpSession session){
        JsonBean bean = null;
        try {
            session.setAttribute("user",null);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}

