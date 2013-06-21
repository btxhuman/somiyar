package com.neaghfoz.component.authorize.model;


import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 上午9:20
 * To change this template use File | Settings | File Templates.
 */
public class Permission implements Serializable{

    private String permissionId;
    private String module; //模块
    private String childModule; //子模块
    private String permissionCode; //权限码 唯一
    private String permissionDesc; //描述
    private Set<Role> roleSet;


    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getChildModule() {
        return childModule;
    }

    public void setChildModule(String childModule) {
        this.childModule = childModule;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionDesc() {
        return permissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
