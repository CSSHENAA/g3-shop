package com.soft.service;

import com.soft.entity.GoodsCar;

import java.util.Date;
import java.util.List;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/25 14:13
 */
public interface GoodsCarService {
    List<GoodsCar> list(int startindex,int psize,int memberId) throws Exception;

    public int count(int memberId) throws Exception;

    public int delete(int id) throws Exception;

    public int deleteAll(String[] ids) throws Exception;

    int add(int goodsId,int memberId,double price)throws  Exception;

    public int update(int number,int goodsId, int memberId, int id) throws Exception;

    List<GoodsCar> listAll(int memberId) throws Exception;

    public int updateNum(int number, int memberId, int id) throws Exception;


    List<GoodsCar> findGoodsCar(String ids) throws Exception;

    //添加订单
    int addOrder(int memberid, String ordercode, int bnumber, String username, String address, int postcode, String tel, String pay, String carry, Date orderdate, String enforce, String bz,double allprice) throws Exception;

    //根据订单号查询订单id
    int findOrderCode(String ordercode) throws Exception;

    //添加商品明细
    int addOrderDetail(int orderid,String ids) throws Exception;
    public int deleteGoodsCar(int memberId,String ids) throws Exception;
}