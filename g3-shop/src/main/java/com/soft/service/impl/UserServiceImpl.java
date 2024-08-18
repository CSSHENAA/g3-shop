package com.soft.service.impl;

import com.soft.dao.UserDao;
import com.soft.dao.impl.UserDaoImpl;
import com.soft.entity.Member;
import com.soft.service.UserService;

import java.util.List;

/**
 * @author : XXX
 * @version : 1.0
 * @date : 2024/7/25 12:02
 */
public class UserServiceImpl implements UserService
{
    UserDao userDao = new UserDaoImpl();
    @Override
    public int queryByName(String username) throws Exception
    {
        int i = userDao.queryByName(username);

        return i;
    }

    @Override
    public int queryByTrname(String truename) throws Exception
    {
        int cnt = userDao.queryByTrname(truename);
        return cnt;
    }

    @Override
    public int regist(String username, String truename, String password, String city, String address, String email, Integer postcode, String cardno, String tel,String freeze) throws Exception
    {
        int regist = userDao.regist(username, truename, password, city, address, email, postcode, cardno, tel,freeze);
        return regist;
    }

    @Override
    public Member queryById(Integer id) throws Exception
    {
        Member member = userDao.queryById(id);
        return member;
    }

    @Override
    public int update(Integer id, String username, String truename, String password, String city, String address, String email, Integer postcode, String cardno, String tel) throws Exception
    {
        int update = userDao.update(id, username, truename, password, city, address, email, postcode, cardno, tel);
        return update;
    }

    @Override
    public List<Member> list(int start, int end) throws Exception
    {
        List<Member> list = userDao.list(start, end);
        return list;
    }

    @Override
    public int count() throws Exception
    {
        int cnt = userDao.count();
        return cnt;
    }

    @Override
    public Member queryMemberById(Integer id) throws Exception
    {
        Member member = userDao.queryMemberById(id);
        return member;
    }

    public int updateById(Integer id, String freeze) throws Exception
    {
        int i = userDao.updateById(id, freeze);
        return i;
    }
}