package com.neaghfoz.framework.springsecurity;

import com.neaghfoz.component.authorize.model.Permission;
import com.neaghfoz.component.authorize.model.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-6-25
 * Time: 上午8:36
 * 简单的UserDetails 实现类
 */
public class SimpleUserDetails extends org.springframework.security.core.userdetails.User {

    private User user;

    private List<Permission> permissionList;


    public SimpleUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public SimpleUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }
}
