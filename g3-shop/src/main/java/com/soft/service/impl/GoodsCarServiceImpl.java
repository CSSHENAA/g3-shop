package com.soft.service.impl;

import com.soft.dao.GoodsCarDao;
import com.soft.dao.impl.GoodsCarDaoImpl;
import com.soft.entity.GoodsCar;
import com.soft.service.GoodsCarService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/25 14:14
 */
public class GoodsCarServiceImpl implements GoodsCarService {
    GoodsCarDao goodsCarDao=new GoodsCarDaoImpl();

    @Override
    public List<GoodsCar> list(int startindex,int psize,int memberId) throws Exception {
        return goodsCarDao.list( startindex, psize, memberId);
    }

    @Override
    public int count(int memberId) throws Exception {
        return goodsCarDao.count(memberId);
    }

    @Override
    public int delete(int id) throws Exception {
        return goodsCarDao.delete(id);
    }

    @Override
    public int deleteAll(String[] ids) throws Exception {
        int cnt = 0;
        for (int i = 0; i < ids.length; i++) {
//            System.out.println("------"+ids[i]);
            goodsCarDao.delete(Integer.parseInt(ids[i]));
            cnt++;
        }
        return cnt;
    }

    public int add(int goodsId, int memberId,double price) throws Exception {
        GoodsCarDao goodsCarDao = new GoodsCarDaoImpl();
        List<GoodsCar> goodsCars = goodsCarDao.listAll(memberId);

        boolean found = false;
        int cnt = 0;

        for (int i = 0; i < goodsCars.size(); i++) {
            // 判断商品id是否等于购物车中的商品id
            if (goodsCars.get(i).getGoodsid().equals(goodsId)) {
                Integer number = goodsCars.get(i).getNumber();
                number++;
                Integer id = goodsCars.get(i).getId();
                cnt = goodsCarDao.update(number, goodsId, memberId, id);
                found = true;
                break;
            }
        }

        // 如果未找到，添加新的商品
        if (!found) {
            cnt = goodsCarDao.add(goodsId, memberId,price);
        }

        return cnt;
    }

    @Override
    public int update(int number, int goodsId, int memberId, int id) throws Exception {
        return 0;
    }

    @Override
    public List<GoodsCar> listAll(int memberId) throws Exception {
        return null;
    }

    @Override
    public int updateNum(int number, int memberId, int id) throws Exception {
        return goodsCarDao.updateNum(number,memberId,id);
    }

    @Override
    public List<GoodsCar> findGoodsCar(String ids) throws Exception {
        List<GoodsCar> goodsCars = new ArrayList<>();
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            GoodsCar goodsCar = goodsCarDao.findGoodsCar(Integer.parseInt(split[i]));
            goodsCars.add(goodsCar);

        }
        return goodsCars;
    }

    //添加订单明细
    @Override
    public int addOrderDetail(int orderid, String ids) throws Exception {
        List<GoodsCar> goodsCar = findGoodsCar(ids);
        int cnt = 0;
        for (int i = 0; i < goodsCar.size(); i++) {
            GoodsCar goodsCar1 = goodsCar.get(i);
            System.out.println(goodsCar1.getPrice());
            goodsCarDao.addOrderDetail(orderid,goodsCar1.getGoodsid(),goodsCar1.getPrice(),goodsCar1.getNumber());
                cnt++;
        }

        return cnt;
    }

    @Override
    public int findOrderCode(String ordercode) throws Exception {
        return goodsCarDao.findOrderCode(ordercode);
    }

    //添加订单

    @Override
    public int addOrder(int memberid, String ordercode, int bnumber, String username, String address, int postcode, String tel, String pay, String carry, Date orderdate, String enforce, String bz,double allprice) throws Exception {
        return goodsCarDao.addOrder(memberid, ordercode, bnumber, username, address, postcode, tel, pay, carry, orderdate, enforce, bz,allprice);
    }

    @Override
    public int deleteGoodsCar(int memberId ,String ids) throws Exception {

        List<GoodsCar> goodsCar = findGoodsCar(ids);
        int cnt = 0;
        for (int i = 0; i < goodsCar.size(); i++) {
            GoodsCar goodsCar1 = goodsCar.get(i);
            goodsCarDao.deleteGoodsCar(memberId,goodsCar1.getId());
            cnt++;
        }

        return cnt;
    }
}