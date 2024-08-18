package com.soft.dao;

import com.soft.entity.Goods;

import java.util.List;

public interface IndexPageDao {
    //获取同一商品类别的数据
    public List<Goods> findClassName(String classname) throws Exception;

    //获取全部商品
    public List<Goods> findGoodsAll() throws Exception;

}
