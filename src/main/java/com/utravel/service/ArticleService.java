package com.utravel.service;

import com.utravel.common.PageBean;
import com.utravel.domain.Article;
import com.utravel.vo.VArticle;

import java.util.ArrayList;
import java.util.Map;

public interface ArticleService {
    public void addVArt(Article article, String imgPath);

    public Map<String, Object> findAllByPageAndInfo(int page, String keyword);

    public Map<String,Object> findAllNewDate(Integer page);


    public Map<String,Object> findAllByPageAndSize(int page, int size);

    public int getCount();

    public int updateClickNum(Integer aid);

    VArticle findByAid(Integer aid);
}
