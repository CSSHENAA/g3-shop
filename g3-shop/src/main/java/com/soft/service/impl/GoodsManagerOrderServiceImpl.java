package com.soft.service.impl;

import com.soft.dao.GoodsManagerOrderDao;
import com.soft.dao.impl.GoodsManagerOrderDaoImpl;
import com.soft.entity.Goods_orderdetail;
import com.soft.entity.Order;
import com.soft.entity.OrderDetail;
import com.soft.service.GoodsManagerOrderService;

import java.util.List;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/25 14:23
 */
public class GoodsManagerOrderServiceImpl implements GoodsManagerOrderService
{
    GoodsManagerOrderDao gmd = new GoodsManagerOrderDaoImpl();
    @Override
    public List< Order > list ( int memberid,int start , int end) throws Exception
    {
        return gmd.list ( memberid,start,end );
    }


    @Override
    public List< Order > listback ( int start , int end ) throws Exception
    {
        return gmd.listback (start,end );
    }

    @Override
    public int count (int memberid ) throws Exception
    {
        return gmd.count ( memberid);
    }

    @Override
    public int backcount() throws Exception {
        return gmd.backcount();
    }

    @Override
    public Order find(String ordercode, String username) throws Exception {
        return gmd.find(ordercode,username);
    }

    @Override
    public Order findOrder(int id) throws Exception {
        return gmd.findOrder(id);
    }

    @Override
    public Order orderInfo (String ordercode ) throws Exception
    {
        return gmd.orderInfo ( ordercode);
    }

    @Override
    public Order orderInfo2 ( String ordercode ) throws Exception
    {
        return gmd.orderInfo2 ( ordercode );
    }

    @Override
    public OrderDetail orderDetail ( int orderid ) throws Exception
    {
        return gmd.orderDetail ( orderid );
    }

    @Override
    public List< Goods_orderdetail > goods ( int id ) throws Exception
    {
        return gmd.goods ( id );
    }

    @Override
    public List< Goods_orderdetail > goodsimg ( int id ) throws Exception
    {
        return gmd.goodsimg ( id );
    }

    @Override
    public int del ( int id ) throws Exception
    {
        return gmd.del ( id );
    }


}
