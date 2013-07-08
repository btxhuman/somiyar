package com.neaghfoz.framework.springsecurity;

import com.neaghfoz.common.Config;
import com.neaghfoz.component.authorize.dao.IPermissionDAO;
import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.model.Permission;
import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.hibernate.Order;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

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
    public static final String ADMIN_ID = "admin";

    @Resource
    private IUserDAO userDAO;

    @Resource
    private IPermissionDAO permissionDAO;

    @Resource(name = "messageSource")
    private MessageSource messageSource;


    /**
     * @param  username 登录用户的用户名
     *  将登录用户的信息缓存起来
     ***/
    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @Cacheable(value = "loginCache", key = "#username + 'loadUserByUsername'")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.findUserByUserName(username);
        List<Permission> permissionList = null;
        SimpleUserDetails userDetails = null;
        String[] defaultAdmin = Config.SUPER_ADMIN;
        if (null == user) {
            throw new UsernameNotFoundException(messageSource.getMessage("JdbcDaoImpl.notFound", new String[]{username}, LocaleContextHolder.getLocale()));
        }
        if(!ObjectUtils.isEmpty(defaultAdmin) && (ArrayUtils.contains(defaultAdmin,username))){
            permissionList = permissionDAO.findAll((Order) null, null);
        }else if (ADMIN_ID.equals(username)) {
            permissionList = permissionDAO.findAll((Order) null, null);
        } else {
            permissionList = permissionDAO.getPermissionsByUserId(user.getUserId());
        }
        if (null != permissionList) {
            List<SimpleGrantedAuthority> authorityList = new ArrayList<SimpleGrantedAuthority>(permissionList.size());
            for (int i = 0, length = permissionList.size(); i < length; i++) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permissionList.get(i).getPermissionCode());
                authorityList.add(authority);
            }
            userDetails = new SimpleUserDetails(user.getUserName(), user.getPassword(), authorityList);
            userDetails.setUser(user);
            userDetails.setPermissionList(permissionList);
        } else {
            throw new RuntimeException("该用户没有权限登录");
        }
        return userDetails;
    }
}
