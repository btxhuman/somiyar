package com.neaghfoz.component.authorize.user.dao;

import com.neaghfoz.component.authorize.user.model.User;
import com.neaghfoz.framework.hibernate.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: neaghfoz
 * Date: 13-5-5
 * Time: 下午11:31
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends BaseDao<User> {
    @Autowired
    private SessionFactory securitySessionFactory;

    @Override
    public Session getSession() {
        return securitySessionFactory.getCurrentSession();
    }

}
