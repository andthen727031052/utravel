package com.utravel.dao;

import com.utravel.domain.Article;
import com.utravel.domain.Article;
import com.utravel.vo.VArticle;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer aid);

    List<VArticle> selectAllByInfo(String info);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}