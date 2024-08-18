package com.soft.dao.impl;

import com.soft.dao.UserDao;
import com.soft.entity.Member;
import com.soft.utils.DBUtils;

import java.util.List;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/25 10:46
 */
public class UserDaoImpl implements UserDao
{
    @Override
    public int queryByName(String username) throws Exception
    {
        int i = DBUtils.queryForInt("select count(1) from tb_member where username=?", username);
        return i;
    }

    @Override
    public int queryByTrname(String truename) throws Exception
    {
        int n = DBUtils.queryForInt("select count(1) from tb_member where truename=?", truename);
        return n;
    }

    @Override
    public int regist(String username, String truename, String password, String city, String address, String email, Integer postcode, String cardno, String tel,String freeze) throws Exception
    {
        int cnt = DBUtils.update("insert into tb_member(username,truename,password,city,address,email,postcode,cardno,tel,freeze) VALUES(?,?,?,?,?,?,?,?,?,?)", username, truename, password, city, address, email, postcode, cardno, tel,freeze);
        return cnt;
    }

    @Override
    public Member queryById(Integer id) throws Exception
    {
        Member member = DBUtils.queryByObject("select * from tb_member where id=?", Member.class, id);
        return member;
    }

    @Override
    public int update(Integer id, String username, String truename, String password, String city, String address, String email, Integer postcode, String cardno, String tel) throws Exception
    {
        int update = DBUtils.update("update tb_member set username=?,truename=?,password=?,city=?,address=?,email=?,postcode=?,cardno=?,tel=? where id=?", username, truename, password, city, address, email, postcode, cardno, tel, id);
        return update;
    }

    @Override
    public List<Member> list(int start, int end) throws Exception
    {
        List<Member> members = DBUtils.queryForList("select id,username,truename,city,tel,email,freeze from tb_member limit ?,?", Member.class, start, end);
        return members;
    }

    @Override
    public int count() throws Exception
    {
        int cnt = DBUtils.queryForInt("select count(*) from tb_member");
        return cnt;
    }

    @Override
    public Member queryMemberById(Integer id) throws Exception
    {
        Member member = DBUtils.queryByObject("select * from tb_member where id=?", Member.class, id);
        return member;
    }

    public int updateById(Integer id, String freeze) throws Exception
    {
        int update = DBUtils.update("update tb_member set freeze=? where id=?", freeze, id);
        return update;
    }
}