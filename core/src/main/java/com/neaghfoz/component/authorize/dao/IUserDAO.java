package com.neaghfoz.component.authorize.dao;

import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.hibernate.IBaseDAO;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 上午9:18
 * To change this template use File | Settings | File Templates.
 */
public interface IUserDAO extends IBaseDAO<User>{
    /**
     * 通过用户名来获取用户的信息
     *
     * @param userName 用户名
     * @return 返回user对象，如果不存在该用户则返回 null;
     */
    public User findUserByUserName(String userName);
}
