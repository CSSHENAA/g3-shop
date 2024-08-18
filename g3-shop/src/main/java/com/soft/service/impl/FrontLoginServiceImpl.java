package com.soft.service.impl;

import com.soft.dao.FrontLoginDao;
import com.soft.dao.impl.FrontLoginDaoImpl;
import com.soft.entity.Member;
import com.soft.service.FrontLoginService;

/**
 * @author : css
 * @version : 1.0
 * @date : 2024/7/29 22:40
 */
public class FrontLoginServiceImpl implements FrontLoginService {
    FrontLoginDao frontLoginDao =  new FrontLoginDaoImpl();
    @Override
    public Member findNamePass(String username, String passWord) throws Exception {
        return frontLoginDao.findNamePass(username,passWord) ;
    }

    @Override
    public int updateFreeze(String username, String freeze) throws Exception {
        return frontLoginDao.updateFreeze(username,freeze);
    }

    @Override
    public int findFreeze(String username) throws Exception {
        return frontLoginDao.findFreeze(username);
    }
}