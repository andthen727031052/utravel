package com.utravel.service.impl;

import com.utravel.dao.ArticleMapper;
import com.utravel.dao.ClickMapper;
import com.utravel.domain.Article;
import com.utravel.domain.Click;
import com.utravel.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ClickServiceImpl implements ClickService {

    @Autowired
    private ClickMapper clickDao;

    @Autowired
    private ArticleMapper artDao;

    @Override
    public void updateClick(int uid, int aid) {
        Click click = new Click();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currentDate = sdf.format(new Date());
        click.setCreatedate(currentDate);
        click.setUid(uid);
        click.setAid(aid);
        Click click1 = clickDao.selectByClick(click);
        if (click1!=null){
            throw  new RuntimeException("一篇游记每天只能赞一次");
        }else {
            clickDao.insertSelective(click);
            Article article = artDao.selectByPrimaryKey(aid);
            article.setClicknumber(article.getClicknumber()+1);
            artDao.updateByPrimaryKeySelective(article);
        }
    }
}
