package com.soft.service;

import com.soft.entity.Goods;

import java.util.Date;
import java.util.List;

public interface GoodsManageService {

    //    商品列表
    public List<Goods> list(int startindex,int psize)throws Exception;



    //    删除商品信息
    public int deleteById(Integer id) throws Exception;




    //    修改商品信息
    public Goods updateById(Integer id) throws  Exception;


    public int update(Integer id, String goodsname, Double price, String picture, String introduce) throws Exception;


    //    添加商品信息

    public  int add(String goodsname,Double price, String picture,Date credate,String introduce, String classname) throws  Exception;

    public int count() throws Exception;

}
