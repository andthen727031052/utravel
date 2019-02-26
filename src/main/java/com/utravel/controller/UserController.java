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

    @RequestMapping("/getUser.do")
    public JsonBean getUser(HttpSession session){
        JsonBean bean = null;
        try {
            User u = (User) session.getAttribute("user");
            bean = JsonUtils.createJsonBean(1,u);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}

