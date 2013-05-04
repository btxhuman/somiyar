package com.neaghfoz.component.user.role.model;

import com.neaghfoz.component.user.user.model.User;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */
public class Role {
    private String roleId;
    private String roleName;
    private Set<User> users;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
