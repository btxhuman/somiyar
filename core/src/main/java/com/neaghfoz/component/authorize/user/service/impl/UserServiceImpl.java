package com.neaghfoz.component.authorize.user.service.impl;

import com.neaghfoz.common.BaseServiceImpl;
import com.neaghfoz.component.authorize.user.dao.IUserDAO;
import com.neaghfoz.component.authorize.user.model.User;
import com.neaghfoz.component.authorize.user.service.IUserService;
import com.neaghfoz.framework.hibernate.BaseDAOImpl;
import com.neaghfoz.framework.hibernate.IBaseDAO;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl extends BaseServiceImpl implements IUserService {
	
    @Resource
    private IUserDAO userDAO;
    

	@Override
    public Object findWithSql(String sql) {
        return userDAO.findWithSql(sql);
    }

   
	@Override
    public Object findWithHql(String hql) {
        return userDAO.findWitHql(hql);
    }

	@Override
	public Object saveObj(Object entity) {
		// TODO Auto-generated method stub
		return userDAO.save(entity);
	}


	@Override
	public IBaseDAO getBaseDAO() {
		// TODO Auto-generated method stub
		return userDAO;
	}


}
