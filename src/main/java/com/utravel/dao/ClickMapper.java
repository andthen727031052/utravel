package com.utravel.dao;

import com.utravel.domain.Click;

public interface ClickMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Click record);

    int insertSelective(Click record);

    Click selectByPrimaryKey(Integer cid);

    Click selectByClick(Click click);

    int updateByPrimaryKeySelective(Click record);

    int updateByPrimaryKey(Click record);
}