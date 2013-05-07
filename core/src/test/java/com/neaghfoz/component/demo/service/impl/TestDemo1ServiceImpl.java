package com.neaghfoz.component.demo.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neaghfoz.component.demo.model.Demo1PO;
import com.neaghfoz.component.demo.service.IDemo1Service;


import java.sql.SQLException;

public class TestDemo1ServiceImpl {

	private static ApplicationContext appContext;

    private static IDemo1Service demo1Service;

    static {
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        demo1Service = appContext.getBean("demo1Service", IDemo1Service.class);
    }

    @Test
    public void testSaveDemo1() throws SQLException{
    	Demo1PO demo1po = new Demo1PO();
    	demo1po.setName("yeah");
        demo1Service.saveObj(demo1po);
    }

    @Test
    public void testGetDemo1po(){
    	Demo1PO demo1po = demo1Service.getDemo1po("2c948fef3e68495d013e684964080000");

    }


    
}
