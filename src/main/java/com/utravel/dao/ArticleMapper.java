package com.utravel.dao;

import com.utravel.domain.Article;
import com.utravel.domain.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}