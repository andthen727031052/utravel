package com.utravel.service;

import com.utravel.common.PageBean;
import com.utravel.domain.Article;
import com.utravel.vo.VArticle;

import java.util.Map;

public interface ArticleService {
    public void addVArt(Article article, String imgPath);

    public Map<String, Object> findAllByPageAndInfo(int page, String keyword);
}
