package com.soft.dao.impl;

import com.soft.dao.GoodsManageDao;
import com.soft.entity.Goods;
import com.soft.utils.DBUtils;

import java.util.Date;
import java.util.List;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/25 10:44
 */
public class GoodsManageDaoImpl implements GoodsManageDao {

    /**
     * 分页查询
     * @param startindex
     * @param psize
     * @return
     * @throws Exception
     */
    @Override
    public List<Goods> list(int startindex,int psize) throws Exception {
        String sql ="SELECT * FROM tb_goods LIMIT ?,?";
        List<Goods> goods = DBUtils.queryForList(sql, Goods.class,startindex,psize);
        return goods;
    }

    /**
     *  添加
     * @param goodsname
     * @param price
     * @param picture
     * @param credate
     * @return
     * @throws Exception
     */
    @Override
    public int add(String goodsname, Double price, String picture, Date credate,String introduce, String classname) throws Exception {
        String sql ="INSERT INTO tb_goods(goodsname,price,picture,credate,introduce,classname) VALUES(?,?,?,?,?,?)";
        return DBUtils.update(sql,goodsname,price,picture,credate,introduce,classname);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Goods updateById(Integer id) throws Exception {
        String sql ="SELECT * FROM tb_goods where id = ?";
        return DBUtils.queryByObject(sql,Goods.class,id);
    }

    /**
     * 修改
     * @param id
     * @param goodsname
     * @param price
     * @param picture
     * @param introduce
     * @return
     * @throws Exception
     */

    @Override
    public int update(Integer id, String goodsname, Double price, String picture, String introduce) throws Exception {
        String sql = "update tb_goods set goodsname=?,price=?,picture=?,introduce=? where id=?";
        return DBUtils.update(sql,goodsname,price,picture,introduce,id);
    }


    /**
     * 根据id删除
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteById(Integer id) throws Exception {
        String sql ="DELETE from tb_goods where id = ?";

        return DBUtils.update(sql,id);
    }


    /**
     * 查询总记录数
     * @return
     * @throws Exception
     */
    @Override
    public int count() throws Exception {
        String sql = "select count(*) from tb_goods";
        return DBUtils.queryForInt(sql);
    }
}
