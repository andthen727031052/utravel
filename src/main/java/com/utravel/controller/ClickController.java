package com.utravel.controller;

import com.utravel.common.JsonBean;
import com.utravel.domain.User;
import com.utravel.service.ArticleService;
import com.utravel.service.ClickService;
import com.utravel.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.font.CreatedFontTracker;

import javax.servlet.http.HttpSession;

@RestController
public class ClickController {

    @Autowired
    private ClickService clickService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/click.do")
    public JsonBean artClick(int aid, HttpSession session){
        JsonBean bean = null;
        User user = (User)session.getAttribute("user");
        if (user==null){
            bean = JsonUtils.createJsonBean(0,"请先登录再进行操作");
        }else {
            Integer clicknumber = null;
            try {
                clickService.updateClick(user.getUid(),aid);
                clicknumber = articleService.findByAid(aid).getClicknumber();
                bean = JsonUtils.createJsonBean(1,clicknumber);
            } catch (Exception e) {
                e.printStackTrace();
                bean = JsonUtils.createJsonBean(0,e.getMessage());
            }

        }
        return bean;
    }
}
