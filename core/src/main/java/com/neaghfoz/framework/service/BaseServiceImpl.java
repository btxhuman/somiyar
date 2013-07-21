package com.neaghfoz.framework.service;

import com.neaghfoz.framework.jdbc.IBaseDAO;


public abstract class BaseServiceImpl implements IBaseService{
	
	@SuppressWarnings("rawtypes")
	public abstract IBaseDAO getBaseDAO();
	
	public Object saveObj(Object entity){
		/*getBaseDAO().save(entity);
		return entity;*/
        return null;
	}
	
	public void updateObj(Object entity){
		//getBaseDAO().update(entity);
	}
	
	public void deleteObj(Object entity){
		//getBaseDAO().delete(entity);
	}
	
}
