package com.soft.dao;

import com.soft.entity.Member;

public interface FrontLoginDao {

    public Member findNamePass(String username,String passWord) throws Exception;

    /**
     * 修改状态码
     * @param username
     * @return
     * @throws Exception
     */
    int updateFreeze(String username,String freeze) throws Exception;

    int findFreeze(String username) throws Exception;
}
