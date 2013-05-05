package com.neaghfoz.component.authorize.user.service;

import com.neaghfoz.component.authorize.user.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {

    public void saveUser(User user);

    public void deleteUser(User user);
}
