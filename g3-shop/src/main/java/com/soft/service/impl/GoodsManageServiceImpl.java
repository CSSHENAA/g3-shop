package com.soft.service.impl;

import com.soft.dao.GoodsManageDao;
import com.soft.dao.impl.GoodsManageDaoImpl;
import com.soft.entity.Goods;
import com.soft.service.GoodsManageService;

import java.util.Date;
import java.util.List;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/25 10:45
 */
public class GoodsManageServiceImpl implements GoodsManageService {

    GoodsManageDao goodsManageDao = new GoodsManageDaoImpl();
    @Override
    public List<Goods> list(int startindex,int psize) throws Exception {

        return goodsManageDao.list(startindex,psize);
    }

    @Override
    public int deleteById(Integer id) throws Exception {

        return goodsManageDao.deleteById(id);
    }

    @Override
    public Goods updateById(Integer id) throws Exception {
        return goodsManageDao.updateById(id);
    }



    @Override
    public int update(Integer id, String goodsname, Double price, String picture, String introduce) throws Exception {
        return goodsManageDao.update(id,goodsname,price,picture,introduce);
    }

    @Override
    public int add(String goodsname, Double price, String picture, Date credate,String introduce, String classname) throws Exception {
        return goodsManageDao.add(goodsname,price,picture,credate,introduce,classname);
    }

    @Override
    public int count() throws Exception {
        return goodsManageDao.count();
    }
}
