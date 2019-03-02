package com.utravel.dao;

import com.utravel.domain.Article;
import com.utravel.vo.VArticle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VArticleMapper {
    List<VArticle> selectAllByInfo(@Param("keyword") String keyword);
    List<VArticle> selectAllByTimeDown();

    List<VArticle> selectAllByPageAndSize(@Param("page")int page, @Param("size")int size);
   // List<VArticle> selectByInfoAndPage(@Param("keyword") String keyword, @Param("page")int page, @Param("size") int size);
    VArticle selectById(Integer aid);
    List<VArticle> selectAll();
    List<VArticle> selectAllBYDate();
}