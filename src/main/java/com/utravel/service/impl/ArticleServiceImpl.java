package com.utravel.service.impl;

import com.utravel.dao.ArticleMapper;
import com.utravel.dao.ImgMapper;
import com.utravel.domain.Article;
import com.utravel.domain.Img;
import com.utravel.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper artDao;

    @Autowired
    private ImgMapper imgDao;

    @Override
    public void addVArt(Article article, String[] imgs) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       
        article.setDeploytime(sdf.format(new Date()));
        article.setClicknumber(0);
        artDao.insertSelective(article);

        for (String item:imgs) {
            Img img = new Img();
            img.setImgurl(item);
            img.setTname(article.getTitle());
            imgDao.insertSelective(img);
        }


    }
}
