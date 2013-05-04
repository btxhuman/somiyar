package com.neaghfoz.component.user.user.service.impl;

import com.neaghfoz.component.user.role.model.Role;
import com.neaghfoz.component.user.user.dao.IUserDAO;
import com.neaghfoz.component.user.user.model.User;
import com.neaghfoz.component.user.user.service.IUserService;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDAO userDAO;

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user); //To change body of implemented methods use File | Settings | File Templates.
    }
}
