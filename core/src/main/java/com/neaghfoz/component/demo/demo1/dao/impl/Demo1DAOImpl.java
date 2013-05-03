package com.neaghfoz.component.demo.demo1.dao.impl;

import com.neaghfoz.component.demo.demo1.dao.IDemo1DAO;
import com.neaghfoz.component.demo.demo1.model.Demo1PO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-4-30
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
public class Demo1DAOImpl implements IDemo1DAO{

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public void addDemo1(Demo1PO demo1PO) {
        //To change body of implemented methods use File | Settings | File Templates.
    	Session session = sessionFactory.getCurrentSession();
        session.save(demo1PO);
    }
    
    @Override
    public void updateDemo1(Demo1PO demo1po) {
    	Session session = sessionFactory.getCurrentSession();
    	session.update(demo1po);
    }
    
    @Override
    public Demo1PO getDemo1po(String id) {
    	return (Demo1PO) sessionFactory.getCurrentSession().get(Demo1PO.class, id);
    }
}
