package com.soft.dao;

import com.soft.entity.Manager;

public interface BackLoginDao
{
    public  Manager login(String user, String pass) throws Exception;


}
