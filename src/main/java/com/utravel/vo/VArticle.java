package com.utravel.vo;

import com.utravel.domain.Img;
import com.utravel.domain.User;

import java.util.List;

public class VArticle {
    private Integer aid;

    private String  uname;

    private String title;

    private String deploytime;

    private String place;

    private String contents;

    private Integer clicknumber;

    private List<Img> imgList;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeploytime() {
        return deploytime;
    }

    public void setDeploytime(String deploytime) {
        this.deploytime = deploytime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getClicknumber() {
        return clicknumber;
    }

    public void setClicknumber(Integer clicknumber) {
        this.clicknumber = clicknumber;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public List<Img> getImgList() {
        return imgList;
    }

    public void setImgList(List<Img> imgList) {
        this.imgList = imgList;
    }
}
