package com.neaghfoz.component.authorize.service.impl;

import com.neaghfoz.component.authorize.dao.IPermissionDAO;
import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.model.Permission;
import com.neaghfoz.component.authorize.model.SimpleUserDetails;
import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.hibernate.IBaseDAO;
import com.neaghfoz.framework.service.BaseServiceImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-6-20
 * Time: 上午9:07
 * To change this template use File | Settings | File Templates.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 系统管理员的ID,如果登录的用户名等于ADMIN_ID 那么就要默认获取所有权限。
     */
    public static final String ADMIN_ID = "btxhuman";

    @Resource
    private IUserDAO userDAO;

    @Resource
    private IPermissionDAO permissionDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByUserName(username);
        List<Permission> permissionList = null;
        SimpleUserDetails userDetails = null;
        if (null == user) {
            throw new UsernameNotFoundException("找不到用户名为:" + username + "的用户");
        }
        permissionList = permissionDAO.getPermissionsByUserId(user.getUserId());
        if (null != permissionList) {
            List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>(permissionList.size());
            for (int i = 0, length = permissionList.size(); i < length; i++) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permissionList.get(i).getPermissionCode());
                authorityList.add(authority);
            }
            userDetails = new SimpleUserDetails(user.getUserName(), user.getPassword(), authorityList);
        } else {
            throw new RuntimeException("该用户没有权限登录");
        }
        return userDetails;
    }

}
