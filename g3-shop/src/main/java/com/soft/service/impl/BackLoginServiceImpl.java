package com.soft.service.impl;

import com.soft.dao.BackLoginDao;
import com.soft.dao.impl.BackLoginDaoImpl;
import com.soft.entity.Manager;
import com.soft.service.BackLoginService;

public class BackLoginServiceImpl implements BackLoginService
{
    BackLoginDao backLoginDao=new BackLoginDaoImpl();
    @Override
    public Manager login(String user, String pass) throws Exception
    {
        Manager manager = backLoginDao.login(user, pass);
        return manager;
    }




}