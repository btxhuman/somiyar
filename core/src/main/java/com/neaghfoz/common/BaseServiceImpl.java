package com.neaghfoz.common;

import com.neaghfoz.framework.hibernate.IBaseDAO;


public abstract class BaseServiceImpl implements IBaseService{
	
	@SuppressWarnings("rawtypes")
	public abstract IBaseDAO getBaseDAO();
	
	public Object saveObj(Object entity){
		getBaseDAO().save(entity);
		return entity;
	}
	
	public void updateObj(Object entity){
		getBaseDAO().update(entity);
	}
	
	public void deleteObj(Object entity){
		getBaseDAO().delete(entity);
	}
	
}
