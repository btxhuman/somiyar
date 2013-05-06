package com.neaghfoz.component.demo.demo1.service.impl;

import javax.annotation.Resource;

import com.neaghfoz.common.BaseServiceImpl;
import com.neaghfoz.component.demo.demo1.dao.IDemo1DAO;
import com.neaghfoz.component.demo.demo1.model.Demo1PO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neaghfoz.component.demo.demo1.service.IDemo1Service;
import com.neaghfoz.framework.hibernate.IBaseDAO;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public class Demo1Service extends BaseServiceImpl implements IDemo1Service {

    private static final Logger log = LoggerFactory.getLogger(Demo1Service.class);

    @Resource
    private IDemo1DAO demo1DAO;

    @SuppressWarnings("rawtypes")
	@Override
	public IBaseDAO getBaseDAO() {
		// TODO Auto-generated method stub
		return demo1DAO;
	}
    
    /*
     * 使用@Transactional 这个注解的话，就可以不用在
     * applicationontext.xml配置文件里面配置aop:config 这个配置项,即使配置了也会被这个注解覆盖掉
    */
//  @Transactional(readOnly=true,propagation=Propagation.REQUIRED, rollbackFor = {SQLException.class})
    @Override
    public Demo1PO getDemo1po(String id) {
    	Demo1PO demo1po = demo1DAO.getDemo1po(id);
    	return demo1po;
    }


	

}
