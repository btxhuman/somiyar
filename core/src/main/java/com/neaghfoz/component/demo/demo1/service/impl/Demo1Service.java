package com.neaghfoz.component.demo.demo1.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.neaghfoz.component.demo.demo1.service.IDemo1Service;

public class Demo1Service implements IDemo1Service {

	private static final Logger log  = LoggerFactory.getLogger(Demo1Service.class);
	
	public void showDemo1() {
		log.info("≤‚ ‘»’÷æ");
		System.out.println("just show Demo1");
	}

}
