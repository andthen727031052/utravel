package com.utravel.dao;

import com.utravel.domain.Img;

public interface ImgMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(Img record);

    int insertSelective(Img record);

    Img selectByPrimaryKey(Integer imgid);

    Img selectByTitle(String title);

    int updateByPrimaryKeySelective(Img record);

    int updateByPrimaryKey(Img record);
}