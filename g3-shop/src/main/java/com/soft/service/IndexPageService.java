package com.soft.service;

import com.soft.entity.Goods;

import java.util.List;

public interface IndexPageService {

    //获取同一商品类别的数据
    public List<Goods> findClassName(String className) throws Exception;

    //获取全部商品
    public List<Goods> findGoodsAll() throws Exception;
}
