package com.neaghfoz.component.demo.service;


import com.neaghfoz.common.IBaseService;
import com.neaghfoz.component.demo.model.Demo1PO;


public interface IDemo1Service extends IBaseService{
	public Demo1PO getDemo1po(String id);
	
}
