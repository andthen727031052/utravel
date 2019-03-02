package com.utravel.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.utravel.common.PageBean;
import com.utravel.dao.ArticleMapper;
import com.utravel.dao.ImgMapper;
import com.utravel.dao.VArticleMapper;
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

    @Autowired
    private VArticleMapper vartDao;

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


    }

    @Override
    public Map<String, Object> findAllByPageAndInfo(int page, String keyword) {
        PageHelper.startPage(page,5);
        List<VArticle> list = vartDao.selectAllByInfo(keyword);
        Map<String, Object> map = new HashMap<>();
       map.put("total", ((Page)list).getTotal());
       // map.put("total", getCount());
        map.put("rows", list);
        return map;
    }



    @Override
    public Map<String, Object> findAllNewDate(Integer page) {
        //PageHelper.startPage(page,5);
       // List<VArticle> list = vartDao.selectAllByTimeDown();
        int start = (page-1) *5;
        int end = page*5;
        int count = getCount();
        if (end>count){
            end = count;
        }
        List<VArticle> list = vartDao.selectAllBYDate();
        Map<String, Object> map = new HashMap<>();
       // map.put("total", ((Page)list).getTotal());
         map.put("total", getCount());
        map.put("rows", list.subList(start,end));
        return map;
    }



    @Override
    public int getCount() {
        return artDao.selectCount();
    }

    @Override
    public int updateClickNum(Integer aid) {
        Article article = artDao.selectByPrimaryKey(aid);
        article.setClicknumber(article.getClicknumber()+1);
        artDao.updateByPrimaryKeySelective(article);
        return  article.getClicknumber();
    }

    @Override
    public VArticle findByAid(Integer aid) {
        return vartDao.selectById(aid);
    }




      @Override
    public Map<String, Object> findAllByPageAndSize(int page, int size) {
        int start = (page-1) *size;
        int end = page*size;
        int count = getCount();
        if (end>count){
            end = count;
        }
        List<VArticle> articleList = vartDao.selectAll();
       // List<VArticle> list = vartDao.selectAllByPageAndSize(start,end);
        Map<String, Object> map = new HashMap<>();
        map.put("total", getCount());
        map.put("rows", articleList.subList(start,end));


        return map;
    }
}
