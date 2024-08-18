package com.soft.entity;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/29 11:10
 */
public class Goods_orderdetail
{
    private String picture;
    private String goodsname;
    private double price;
    private int numbers;


    public String getpicture ( )
    {
        return picture;
    }

    public void setpicture ( String picture )
    {
        picture = picture;
    }

    public String getGoodsname ( )
    {
        return goodsname;
    }

    public void setGoodsname ( String goodsname )
    {
        this.goodsname = goodsname;
    }

    public double getprice ( )
    {
        return price;
    }

    public void setprice ( double price )
    {
        this.price = price;
    }

    public int getNumbers ( )
    {
        return numbers;
    }

    public void setNumbers ( int numbers )
    {
        this.numbers = numbers;
    }



    @Override
    public String toString ( )
    {
        return "Goods_orderdetail{" +
                "picture='" + picture + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", price=" + price +
                ", numbers=" + numbers +
                '}';
    }
}
