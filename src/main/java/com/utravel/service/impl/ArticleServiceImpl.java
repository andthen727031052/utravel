package com.utravel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.utravel.common.PageBean;
import com.utravel.dao.ArticleMapper;
import com.utravel.dao.ImgMapper;
import com.utravel.domain.Article;
import com.utravel.domain.Img;
import com.utravel.service.ArticleService;
import com.utravel.vo.VArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper artDao;

    @Autowired
    private ImgMapper imgDao;

    @Override
    public void addVArt(Article article, String imgPath) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       
        article.setDeploytime(sdf.format(new Date()));
        article.setClicknumber(0);
        artDao.insertSelective(article);
        String[] imgs= imgPath.split(";");
        for (String item:imgs) {
            Img img = new Img();
            img.setImgurl(item);
            img.setTname(article.getTitle());
            imgDao.insertSelective(img);
        }

        /*for (String item:imgs) {
            Img img = new Img();
            img.setImgurl(item);
            img.setTname(article.getTitle());
            imgDao.insertSelective(img);
        }*/


    }

    @Override
    public Map<String, Object> findAllByPageAndInfo(int page, String keyword) {
        PageHelper.startPage(page,5);
        List<VArticle> list = artDao.selectAllByInfo(keyword);
        Map<String, Object> map = new HashMap<>();
        map.put("total", ((Page)list).getTotal());
        map.put("rows", list);
        return map;
    }


}
