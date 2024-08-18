package com.soft.dao.impl;

import com.soft.dao.IndexPageDao;
import com.soft.entity.Goods;
import com.soft.utils.DBUtils;

import java.util.List;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/29 11:44
 */
public class IndexDaoPageImpl implements IndexPageDao {
    @Override
    public List<Goods> findClassName(String classname) throws Exception {
       List<Goods> goodsList = DBUtils.queryForList("select * from tb_goods where classname=?", Goods.class, classname);
        return goodsList;
    }

    @Override
    public List<Goods> findGoodsAll() throws Exception {
        return DBUtils.queryForList("select * from tb_goods",Goods.class);
    }
}
