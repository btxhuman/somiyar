package com.neaghfoz.component.authorize.user.service;

import com.neaghfoz.component.authorize.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: neaghfoz
 * Date: 13-5-5
 * Time: 下午11:34
 * To change this template use File | Settings | File Templates.
 */
public class UserService {
    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    /**
     * 通过Hql查询
     *
     * @param sql 待处理sql串
     * @return 返回查询结果
     */
    public Object findWithSql(String sql) {
        return userDao.findWithSql(sql);
    }

    /**
     * 通过Hql查询
     *
     * @param hql 待处理hql串
     * @return 返回查询结果
     */
    public Object findWithHql(String hql) {
        return userDao.findWitHql(hql);
    }


}
