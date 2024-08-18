package com.soft.entity;

/**购物车
 * @author : css
 * @version : 1.0
 * @date : 2024/7/25 11:27
 */
public class GoodsCar {
    private Integer goodsid;//商品id
    private Integer memberid;//会员id
    private Double price;//价格
    private Integer number;//数量
    private String picture;//图片
    private String goodsname;//商品名称

    private Integer id;//id

    public GoodsCar() {
    }

    @Override
    public String toString() {
        return "GoodsCar{" +
                "goodsid=" + goodsid +
                ", memberid=" + memberid +
                ", price=" + price +
                ", number=" + number +
                ", picture='" + picture + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", id=" + id +
                '}';
    }

    public GoodsCar(Integer goodsid, Integer memberid, Double price, Integer number, String picture, String goodsname) {
        this.goodsid = goodsid;
        this.memberid = memberid;
        this.price = price;
        this.number = number;
        this.picture = picture;
        this.goodsname = goodsname;
    }

    public GoodsCar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }
}