package com.soft.service;

import com.soft.entity.Member;

public interface FrontLoginService {

    public Member findNamePass(String username, String passWord) throws Exception;

    public int updateFreeze(String username, String freeze) throws Exception;

    public int findFreeze(String username) throws Exception;
    }
