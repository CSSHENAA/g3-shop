package com.soft.dao.impl;

import com.soft.dao.GoodsCarDao;
import com.soft.entity.GoodsCar;
import com.soft.utils.DBUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/25 11:51
 */
public class GoodsCarDaoImpl implements GoodsCarDao {
    /**
     *         //SELECT goodsid,memberid,tb_goods.price,number,tb_goods.picture FROM tb_goodscar LEFT JOIN tb_goods ON tb_goodscar.goodsid=tb_goods.id WHERE memberid=?;
     * @return
     * @throws Exception
     */
    @Override
    public List<GoodsCar> list(int startindex,int psize, int memberId) throws Exception {
        return DBUtils.queryForList("SELECT goodsid,memberid,tb_goods.price,number,tb_goods.picture,tb_goods.goodsname,tb_goodscar.id FROM tb_goodscar LEFT JOIN tb_goods ON tb_goodscar.goodsid=tb_goods.id WHERE memberid=? limit ?,?", GoodsCar.class,memberId,startindex,psize);
    }

    @Override
    public int count(int memberId) throws Exception {
        return DBUtils.queryForInt("SELECT COUNT(*) FROM tb_goodscar WHERE memberid=?",memberId);
    }

    @Override
    public int delete(int id) throws Exception {
        return DBUtils.update("DELETE FROM tb_goodscar  WHERE id=?",id);
    }

    @Override
    public int add(int goodsId, int memberId,double price) throws Exception {
        return DBUtils.update("INSERT INTO tb_goodscar(goodsid,memberid,price,number) VALUES(?,?,?,1)",goodsId,memberId,price);
    }

    @Override
    public int update(int number,int goodsId, int memberId, int id) throws Exception {
        //UPDATE tb_goodscar SET number=10 WHERE goodsid=8 AND memberid=1 AND id=36;
        return DBUtils.update("UPDATE tb_goodscar SET number=? WHERE goodsid=? AND memberid=? AND id=?",number,goodsId,memberId,id);
    }

    @Override
    public List<GoodsCar> listAll(int memberId) throws Exception {
        return DBUtils.queryForList("select * from tb_goodscar where memberid=?", GoodsCar.class,memberId);
    }

    @Override
    public int updateNum(int number, int memberId, int id) throws Exception {
        return DBUtils.update("UPDATE tb_goodscar SET number=? WHERE memberid=? AND id=?",number,memberId,id);
    }

    @Override
    public GoodsCar findGoodsCar(int id) throws Exception {
        return DBUtils.queryByObject("select * from tb_goodscar where id=?",GoodsCar.class,id);
    }



    //添加订单
    @Override
    public int addOrder(int memberid, String ordercode, int bnumber, String username, String address, int postcode, String tel, String pay, String carry, Date orderdate, String enforce, String bz,double allprice) throws Exception {
        String sql = "insert into tb_order(memberid, ordercode, bnumber, username, address, postcode, tel, pay, carry, orderdate, enforce, bz,allprice) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        String sql = "insert into tb_order(memberid, ordercode, bnumber, username, address, postcode, tel, pay, carry, orderdate, bz) values(?,?,?,?,?,?,?,?,?,?,?)";
        int cnt = DBUtils.update(sql, memberid, ordercode, bnumber, username, address, postcode, tel, pay, carry, orderdate,enforce, bz,allprice);
        return cnt;
    }

    //根据订单号查询订单id
    @Override
    public int findOrderCode(String ordercode) throws Exception {
        return DBUtils.queryForInt("select id from tb_order where ordercode = ?",ordercode);
    }

    //添加订单明细
    @Override
    public int addOrderDetail(int orderid, int goodsid, double price, int numbers) throws Exception {
        return DBUtils.update("insert into tb_order_detail(orderid,goodsid,price,numbers) value(?,?,?,?)",orderid,goodsid,price,numbers);
    }

    @Override
    public int deleteGoodsCar(int memberId,int id) throws Exception {
        return DBUtils.update("DELETE FROM tb_goodscar  WHERE memberid=? AND id=?",memberId,id);
    }
}