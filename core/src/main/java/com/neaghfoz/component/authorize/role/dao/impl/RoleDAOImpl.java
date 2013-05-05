package com.neaghfoz.component.authorize.role.dao.impl;

import com.neaghfoz.component.authorize.role.dao.IRoleDAO;
import com.neaghfoz.component.authorize.role.model.Role;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午9:46
 * To change this template use File | Settings | File Templates.
 */
public class RoleDAOImpl implements IRoleDAO{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void deleteRole(Role role) {
        sessionFactory.getCurrentSession().delete(role);
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
