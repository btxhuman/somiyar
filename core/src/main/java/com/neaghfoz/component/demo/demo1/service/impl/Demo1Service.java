package com.neaghfoz.component.demo.demo1.service.impl;

import javax.annotation.Resource;

import com.neaghfoz.component.demo.demo1.dao.IDemo1DAO;
import com.neaghfoz.component.demo.demo1.model.Demo1PO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neaghfoz.component.demo.demo1.service.IDemo1Service;

import java.sql.SQLException;

public class Demo1Service implements IDemo1Service {

	private static final Logger log  = LoggerFactory.getLogger(Demo1Service.class);
	
	@Resource
	private IDemo1DAO demo1DAO;
	
	@Override
	public void saveDemo1() throws SQLException{
		log.debug("测试日志");
        Demo1PO demo1PO = new Demo1PO();
        demo1PO.setName("hello world");
        demo1DAO.addDemo1(demo1PO);
        throw new SQLException("用来测试事务是否开启");
	}

}
	