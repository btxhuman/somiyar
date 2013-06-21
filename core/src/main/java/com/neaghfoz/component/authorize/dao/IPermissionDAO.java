package com.neaghfoz.component.authorize.dao;

import com.neaghfoz.component.authorize.model.Permission;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public interface IPermissionDAO {
    public List<Permission> getPermissionsByUserId(String id) throws Exception;
}
