package com.neaghfoz.component.user.role.service.impl;

import com.neaghfoz.component.user.role.dao.IRoleDAO;
import com.neaghfoz.component.user.role.model.Role;
import com.neaghfoz.component.user.role.service.IRoleService;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午9:48
 * To change this template use File | Settings | File Templates.
 */
public class RoleServiceImpl implements IRoleService{
    @Resource
    private IRoleDAO roleDAO;

    @Override
    public void deleteRole(Role role) {
        roleDAO.deleteRole(role);
    }
}
