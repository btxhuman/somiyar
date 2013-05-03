package com.neaghfoz.component.demo.demo1.service.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neaghfoz.component.demo.demo1.model.Demo1PO;
import com.neaghfoz.component.demo.demo1.service.IDemo1Service;

import java.sql.SQLException;

public class TestDemo1Service {

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
        demo1Service.saveDemo1(demo1po);
    }

    @Test
    public void testGetDemo1po(){
    	Demo1PO demo1po = demo1Service.getDemo1po("2c948fef3e68495d013e684964080000");

    }


    
}
