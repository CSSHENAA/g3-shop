package com.soft.entity;

/**商品表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 19:31
 */

import java.util.Date;

public class Goods {
    private Integer id;
    private String goodsname;//商品名称
    private Double price;//原价
    private String picture;//图片
    private Date credate;//创建时间
    private String introduce;//详细信息介绍
    private String classname;//类别


    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", credate=" + credate +
                ", introduce='" + introduce + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }

    public Goods() {
    }

    public Goods(Integer id, String goodsname, Double price, String picture, Date credate, String introduce, String classname) {
        this.id = id;
        this.goodsname = goodsname;
        this.price = price;
        this.picture = picture;
        this.credate = credate;
        this.introduce = introduce;
        this.classname = classname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}