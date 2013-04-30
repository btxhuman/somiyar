package com.neaghfoz.component.demo.demo1.dao.impl;

import com.neaghfoz.component.demo.demo1.dao.IDemo1DAO;
import com.neaghfoz.component.demo.demo1.model.Demo1PO;
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
    public void showDemo1(Demo1PO demo1PO) {
        //To change body of implemented methods use File | Settings | File Templates.
        sessionFactory.getCurrentSession().save(demo1PO);
    }
}
