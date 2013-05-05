package com.neaghfoz.component.user.user.dao;

import com.neaghfoz.component.user.role.model.Role;
import com.neaghfoz.component.user.user.model.User;

import java.util.Set;

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