package com.neaghfoz.component.demo.dao.impl;

import com.neaghfoz.component.demo.dao.IDemo1DAO;
import com.neaghfoz.component.demo.model.Demo1PO;
import com.neaghfoz.framework.hibernate.BaseDAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-4-30
 * Time: 下午2:43
 * To change this template use File | Settings | File Templates.
 */
public class Demo1DAOImpl extends BaseDAOImpl<Demo1PO> implements IDemo1DAO{
    
    @Override
    public Demo1PO getDemo1po(String id) {
    	return (Demo1PO) getSession().get(Demo1PO.class, id);
    }
}
