package com.utravel.service.impl;

import com.utravel.dao.ImgMapper;
import com.utravel.domain.Img;
import com.utravel.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgDao;

    @Override
    public void addImg(Img img) {
        imgDao.insertSelective(img);
    }
}
