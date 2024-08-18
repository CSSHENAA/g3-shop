package com.soft.dao.impl;

import com.soft.dao.BackLoginDao;
import com.soft.entity.Manager;
import com.soft.utils.DBUtils;

public class BackLoginDaoImpl implements BackLoginDao
{
    @Override
    public Manager login(String user, String pass) throws Exception
    {
        String sql="select*from tb_manager where manager=? and pwd=?";
        Manager manager = DBUtils.queryByObject(sql, Manager.class, user, pass);
        return manager;
    }

}
