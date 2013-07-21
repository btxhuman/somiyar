package com.neaghfoz.component.authorize.service.impl;

import com.neaghfoz.framework.service.BaseServiceImpl;
import com.neaghfoz.component.authorize.dao.IRoleDAO;
import com.neaghfoz.component.authorize.service.IRoleService;
import com.neaghfoz.framework.jdbc.IBaseDAO;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 下午9:48
 * To change this template use File | Settings | File Templates.
 */
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService{
    @Resource
    private IRoleDAO roleDAO;

	@Override
	public IBaseDAO getBaseDAO() {
		return roleDAO;
	}

}
