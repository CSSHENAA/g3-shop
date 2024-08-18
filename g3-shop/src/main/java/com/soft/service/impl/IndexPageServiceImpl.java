package com.soft.service.impl;

import com.soft.dao.IndexPageDao;
import com.soft.dao.impl.IndexDaoPageImpl;
import com.soft.entity.Goods;
import com.soft.service.IndexPageService;

import java.util.List;

/**
 * @author : qwj
 * @version : 1.0
 * @date : 2024/7/29 11:48
 */
public class IndexPageServiceImpl implements IndexPageService {
    IndexPageDao indexPageDao = new IndexDaoPageImpl();
    @Override
    public List<Goods> findClassName(String classname) throws Exception {
        return indexPageDao.findClassName(classname);
    }

    @Override
    public List<Goods> findGoodsAll() throws Exception {
        return indexPageDao.findGoodsAll();
    }
}
