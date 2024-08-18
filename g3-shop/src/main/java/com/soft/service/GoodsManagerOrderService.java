package com.soft.service;

import com.soft.entity.Goods_orderdetail;
import com.soft.entity.Order;
import com.soft.entity.OrderDetail;

import java.util.List;

public interface GoodsManagerOrderService
{
    public List< Order > list( int memberid,int start , int end) throws Exception;

    public List< Order > listback ( int start , int end ) throws Exception;
    public int count(int memberid)throws Exception;
    public Order find (String ordercode,String username) throws Exception;
    public Order findOrder(int id) throws Exception;
    public Order orderInfo( String ordercode)throws Exception;
    public Order orderInfo2( String ordercode)throws Exception;
    public OrderDetail orderDetail( int orderid)throws Exception;
    public List< Goods_orderdetail > goods(int id)throws Exception;
    public List< Goods_orderdetail > goodsimg(int id)throws Exception;
    public int del(int id)throws Exception;

    int backcount() throws Exception;
}
