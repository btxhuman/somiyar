package com.neaghfoz.component.authorize.user.dao;

import com.neaghfoz.component.authorize.user.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 上午9:18
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDAO {
    public void saveUser(User user);

    public void deleteUser(User user);

}
