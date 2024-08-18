package com.soft.dao.impl;

import com.soft.dao.GoodsManagerOrderDao;
import com.soft.entity.Goods_orderdetail;
import com.soft.entity.Order;
import com.soft.entity.OrderDetail;
import com.soft.utils.DBUtils;

import java.util.List;

/**
 * @author : wyq
 * @version : 1.0
 * @date : 2024/7/25 14:13
 */
public class GoodsManagerOrderDaoImpl implements GoodsManagerOrderDao
{

    /**
     * 订单列表
     * @param start
     * @param end
     * @return
     * @throws Exception
     */
    @Override
    public List< Order > list ( int memberid,int start , int end ) throws Exception
    {
        String sql = "select * from tb_order where memberid=? limit ?,? ";
        List<Order> list = DBUtils.queryForList ( sql,Order.class,memberid,start,end );
        return list;
    }

    @Override
    public List< Order > listback ( int start , int end ) throws Exception
    {
        String sql = "select * from tb_order  limit ?,? ";
        List<Order> list = DBUtils.queryForList ( sql,Order.class,start,end );
        return list;
    }

    /**
     * 订单数量
     * @return
     * @throws Exception
     */
    @Override
    public int count ( int memberid) throws Exception
    {
        String sql = "select count(*) from tb_order where memberid=?";
        int cnt = DBUtils.queryForInt ( sql ,memberid);
        return cnt;
    }

    @Override
    public int backcount() throws Exception {
        String sql = "select count(*) from tb_order";
        int cnt = DBUtils.queryForInt ( sql);
        return cnt;
    }

    /**
     * 查询订单
     * @param ordercode
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public Order find(String ordercode, String username) throws Exception {
        String sql ="select * from tb_order where ordercode=? and username=?";
        Order find = DBUtils.queryByObject(sql, Order.class, ordercode, username);
        return find;
    }

    /**
     * 查询订单列表
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Order findOrder(int id) throws Exception {
        String sql ="select * from tb_order where id=?";
        Order order = DBUtils.queryByObject(sql, Order.class,id);
        return order;
    }

    /**
     * 订单详细
     * @param ordercode
     * @return
     * @throws Exception
     */
    @Override
    public Order orderInfo (String ordercode ) throws Exception
    {
        String sql = "select * from tb_order where id=?";
        Order orderinfo = DBUtils.queryByObject ( sql , Order.class ,ordercode);
        return orderinfo;
    }

    @Override
    public Order orderInfo2 ( String ordercode ) throws Exception
    {
        String sql = "select * from tb_order where ordercode=?";
        Order orderinfo = DBUtils.queryByObject ( sql , Order.class ,ordercode);
        return orderinfo;
    }

    /**
     * 订单详细表格展示
     * @param orderid
     * @return
     * @throws Exception
     */
    @Override
    public OrderDetail orderDetail ( int orderid ) throws Exception
    {
        String sql="select * from tb_order_detail where orderid=?";
        OrderDetail orderdetail = DBUtils.queryByObject ( sql , OrderDetail.class , orderid );
        return orderdetail;
    }

    /**
     * 商品信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List< Goods_orderdetail > goods ( int id ) throws Exception
    {

        String sql = "select g.goodsname,od.numbers,od.price,od.orderid from tb_order_detail od " +
                "LEFT JOIN tb_goods g on od.goodsid = g.id where od.orderid = ?";
        List< Goods_orderdetail > goods = DBUtils.queryForList ( sql , Goods_orderdetail.class,id );
        return goods;
    }

    @Override
    public List< Goods_orderdetail > goodsimg ( int id ) throws Exception
    {
        String sql = "select g.goodsname,od.numbers,od.price,od.orderid,g.picture from tb_order_detail od " +
                "LEFT JOIN tb_goods g on od.goodsid = g.id where od.orderid = ?";
        List< Goods_orderdetail > goodsimg = DBUtils.queryForList ( sql , Goods_orderdetail.class,id );
        return goodsimg;
    }

    @Override
    public int del ( int id ) throws Exception
    {
        String sql ="delect from tb_order where id=?";
        int update = DBUtils.update ( sql , id );
        return update;
    }


}
