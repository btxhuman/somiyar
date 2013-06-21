package com.neaghfoz.component.demo.service;


import com.neaghfoz.framework.service.IBaseService;
import com.neaghfoz.component.demo.model.Demo1PO;


public interface IDemo1Service extends IBaseService{
	public Demo1PO getDemo1po(String id);
	
}
