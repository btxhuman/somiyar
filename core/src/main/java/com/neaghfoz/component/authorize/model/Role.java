package com.neaghfoz.component.authorize.model;


import com.neaghfoz.framework.jdbc.BaseModel;

import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 上午9:30
 * To change this template use File | Settings | File Templates.
 */
public class Role implements Serializable,BaseModel{
    private String roleId;
    private String roleName;
/*    private Set<User> userSet;
    private Set<Permission> permissionSet;*/

    public Role(){
        super();
    }

    public Role(String roleId){
        this.roleId = roleId;
    }

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

   /* public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }

    public void setPermissionSet(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }*/

    @Override
    public String getTableName() {
        return "tb_role";
    }

    @Override
    public void setPrimaryKeyValue(Object primaryKeyValue) {
        if(primaryKeyValue instanceof String){
            setRoleId(primaryKeyValue.toString());
        }
    }

    @Override
    public String getPrimaryKeyName() {
        return "role_id";
    }
}
