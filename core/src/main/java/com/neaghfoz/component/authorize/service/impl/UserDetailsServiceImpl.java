package com.neaghfoz.component.authorize.service.impl;

import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.hibernate.IBaseDAO;
import com.neaghfoz.framework.service.BaseServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-6-20
 * Time: 上午9:07
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailsServiceImpl extends BaseServiceImpl implements UserDetailsService {

    /**
     * 系统管理员的ID,如果登录的用户名等于ADMIN_ID 那么就要默认获取所有权限。
     */
    public static final String ADMIN_ID = "btxhuman";

    @Resource
    private IUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByUserName(username);
        if (null == user) {
            throw new UsernameNotFoundException("找不到用户名为:" + username + "的用户");
        }

        return null;
    }

    @Override
    public IBaseDAO getBaseDAO() {
        return userDAO;
    }
}
