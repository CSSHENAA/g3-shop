package com.soft.dao.impl;

import com.soft.dao.FrontLoginDao;
import com.soft.entity.Member;
import com.soft.utils.DBUtils;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/29 22:35
 */
public class FrontLoginDaoImpl implements FrontLoginDao {

    @Override
    public Member findNamePass(String username, String passWord) throws Exception {
        return DBUtils.queryByObject("select * from tb_member where username=? and password=?",Member.class,username,passWord);

    }

    @Override
    public int updateFreeze(String username, String freeze) throws Exception {
        return DBUtils.update("UPDATE  tb_member SET freeze=? where username=?",freeze,username);
    }


    public int findFreeze(String username) throws Exception{
        return DBUtils.queryForInt("select freeze from tb_member where username=?",username);
    }

}