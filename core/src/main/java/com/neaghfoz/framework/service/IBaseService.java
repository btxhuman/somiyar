package com.neaghfoz.framework.service;

import com.neaghfoz.framework.hibernate.IBaseDAO;

public interface IBaseService {
	
	@SuppressWarnings("rawtypes")
	public abstract IBaseDAO getBaseDAO();
	
	public Object saveObj(Object entity);
	
	public void updateObj(Object entity);
	
	public void deleteObj(Object entity);
	
}
