package com.neaghfoz.component.authorize.dao.impl;

import com.neaghfoz.component.authorize.dao.IPermissionDAO;
import com.neaghfoz.component.authorize.model.Permission;
import com.neaghfoz.framework.jdbc.BaseDAOImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-6-21
 * Time: 下午5:39
 * To change this template use File | Settings | File Templates.
 */
public class PermissionDAOImpl extends BaseDAOImpl implements IPermissionDAO {

    public List<Permission> getPermissionsByUserId(String id){

        String subSql = "select distinct t.permission_id from tb_role_per_link t inner join " +
                "(select role_id from tb_user_role_link where user_id=:userId) tt on tt.role_id = t.role_id";
        String sql = "select x.* from tb_permission x inner join (" + subSql + ")  xx on x.permission_id = xx.permission_id";

       // List<Permission> list = super.getSession().createSQLQuery(sql).addEntity(Permission.class).setString("userId", id).list();
        return null;
    }
}
