package com.neaghfoz.component.authorize.dao.impl;

import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.jdbc.BaseDAOImpl;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl extends BaseDAOImpl implements IUserDAO {

    @Override
    public User findUserByUserName(String userName) {
        return null;

    }
}
