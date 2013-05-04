package com.neaghfoz.component.user.user.dao.impl;

import com.neaghfoz.component.user.user.dao.IUserDAO;
import com.neaghfoz.component.user.user.model.User;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl implements IUserDAO{
    @Resource
    private SessionFactory sessionFactory;
    @Override
    public void saveUser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);

    }
}
