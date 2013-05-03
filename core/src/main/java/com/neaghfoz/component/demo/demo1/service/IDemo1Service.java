package com.neaghfoz.component.demo.demo1.service;

import java.sql.SQLException;

import com.neaghfoz.component.demo.demo1.model.Demo1PO;

public interface IDemo1Service {
	public void saveDemo1(Demo1PO demo1PO) throws SQLException;
	
	public Demo1PO getDemo1po(String id);
	
}
