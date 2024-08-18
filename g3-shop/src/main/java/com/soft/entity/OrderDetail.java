package com.soft.entity;

/**订单明细表
 * @author : css
 * @version : 1.0
 * @date : 2024/7/24 20:50
 */
public class OrderDetail {
    private  Integer id;
    private Integer orderid;//订单id
    private Integer goodsid;//商品id
    private Double price;//价格
    private Integer numbers;//数量


    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", goodsid=" + goodsid +
                ", price=" + price +
                ", numbers=" + numbers +
                '}';
    }

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer orderid, Integer goodsid, Double price, Integer numbers) {
        this.id = id;
        this.orderid = orderid;
        this.goodsid = goodsid;
        this.price = price;
        this.numbers = numbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}