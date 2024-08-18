package com.soft.service;

import com.soft.entity.Member;

import java.util.List;

public interface UserService
{
    public int queryByName(String username) throws Exception;

    public int queryByTrname(String truename) throws Exception;

    public int regist(String username,String truename,String password,String city,String address,String email,Integer postcode,String cardno,String tel,String freeze) throws Exception;

    public Member queryById(Integer id) throws Exception;

    public int update(Integer id,String username,String truename,String password,String city,String address,String email,Integer postcode,String cardno,String tel) throws Exception;

    public List<Member> list(int start, int end) throws Exception;

    public int count() throws Exception;

    public Member queryMemberById(Integer id) throws Exception;

    public int updateById(Integer id,String freeze) throws  Exception;

}
