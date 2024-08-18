package com.soft.dao;

import com.soft.entity.GoodsCar;

import java.util.Date;
import java.util.List;

/**购物车
 * @author : css
 * @version : 1.0
 * @date : 2024/7/25 11:32
 */
public interface GoodsCarDao {
    /**
     * 购物车分页查询
     * @return
     * @throws Exception
     */
    List<GoodsCar> list(int startindex,int psize,int memberId) throws Exception;

    /**
     * 查询该用户购物车中数据条数
     * @param memberId
     * @return
     * @throws Exception
     */
    int count(int memberId) throws Exception;

    /**
     * 删除商品
     * @param id
     * @return
     * @throws Exception
     */
    int delete(int id) throws  Exception;

    /**
     * 添加商品
     * @param goodsId
     * @param memberId
     * @param price
     * @return
     * @throws Exception
     */
    int add(int goodsId,int memberId,double price)throws  Exception;

    /**
     * 添加商品时 只做数量的更新
     * @param goodsId
     * @param memberId
     * @param id
     * @return
     * @throws Exception
     */
    int update(int number,int goodsId, int memberId,int id) throws  Exception;

    /**
     * 查询购物车中所有信息 做商品唯一添加
     * @return
     * @throws Exception
     */
    List<GoodsCar> listAll(int memberId) throws Exception;

    /**
     * 购物车中该商品数量的修改
     * @param number
     * @param memberId
     * @param id
     * @return
     * @throws Exception
     */
    int updateNum(int number,int memberId,int id) throws Exception;

    /**
     *查询购物车id的该商品信息
     * @param id
     * @return
     * @throws Exception
     */
    GoodsCar findGoodsCar(int id) throws Exception;

    /**
     * 添加订单
     * @param memberid
     * @param ordercode
     * @param bnumber
     * @param username
     * @param address
     * @param postcode
     * @param tel
     * @param pay
     * @param carry
     * @param orderdate
     * @param enforce
     * @param bz
     * @return
     * @throws Exception
     */
    int addOrder(int memberid, String ordercode, int bnumber, String username, String address, int postcode, String tel, String pay, String carry, Date orderdate,String enforce,String bz,double allprice) throws Exception;

    /**
     * 根据订单号查询订单id
     * @param ordercode
     * @return
     * @throws Exception
     */
    int findOrderCode(String ordercode) throws Exception;

    /**
     * 添加商品明细
     * @param orderid
     * @param goodsid
     * @param price
     * @param numbers
     * @return
     * @throws Exception
     */
    int addOrderDetail(int orderid,int goodsid,double price,int numbers) throws Exception;

    /**
     * 下单后删除该用户购物车中所选商品信息
     * @param memberId
     * @param id
     * @return
     * @throws Exception
     */
    int deleteGoodsCar(int memberId,int id) throws Exception;

}