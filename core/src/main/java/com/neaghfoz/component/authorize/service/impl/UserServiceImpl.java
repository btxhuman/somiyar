package com.neaghfoz.component.authorize.service.impl;

import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.service.BaseServiceImpl;
import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.service.IUserService;
import com.neaghfoz.framework.hibernate.IBaseDAO;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl extends BaseServiceImpl implements IUserService {
	
    @Resource
    private IUserDAO userDAO;
    
	@Override
	public IBaseDAO getBaseDAO() {
		return userDAO;
	}

	@Override
    public Object findWithSql(String sql) {
        return userDAO.findWithSql(sql);
    }

   
	@Override
    public Object findWithHql(String hql) {
        return userDAO.findWitHql(hql);
    }

    @Override
    public User findUserByUserName(String userName) {
        if(StringUtils.isBlank(userName)){
           return null;
        }
        User user = userDAO.findUserByUserName(userName);
        return user;
    }


}
