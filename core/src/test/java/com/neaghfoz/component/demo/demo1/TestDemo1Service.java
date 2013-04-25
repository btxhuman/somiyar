package com.neaghfoz.component.demo.demo1;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neaghfoz.component.demo.demo1.service.IDemo1Service;

public class TestDemo1Service {
	
	private static ApplicationContext appContext;
	
	private static IDemo1Service demo1Service;
	
	static {
		appContext = new ClassPathXmlApplicationContext( "applicationContext.xml");
		demo1Service = appContext.getBean("demo1Service", IDemo1Service.class);
	}

	@Test
	public void testShowDemo1() {
		demo1Service.showDemo1();
	}

}
