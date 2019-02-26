package com.utravel.controller;

import com.utravel.common.JsonBean;
import com.utravel.domain.Article;
import com.utravel.domain.User;
import com.utravel.service.ArticleService;
import com.utravel.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/addArt.do")
    public JsonBean addArt(Article article, String imgPath, HttpSession session){
        JsonBean bean = null;
       User user = (User) session.getAttribute("user");
        article.setUid(user.getUid());
        try {
            articleService.addVArt(article,imgPath);
            bean = JsonUtils.createJsonBean(1,null);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }

    @RequestMapping("/artList.do")
    public JsonBean showAll(int page, String info){
        JsonBean bean = null;
        try {
            Map<String, Object> map = articleService.findAllByPageAndInfo(page, info);
            bean = JsonUtils.createJsonBean(1,map);
        } catch (Exception e) {
            e.printStackTrace();
            bean = JsonUtils.createJsonBean(0,e.getMessage());
        }
        return bean;
    }
}
