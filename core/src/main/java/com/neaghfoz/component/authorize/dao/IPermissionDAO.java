package com.neaghfoz.component.authorize.dao;

import com.neaghfoz.component.authorize.model.Permission;
import com.neaghfoz.framework.jdbc.IBaseDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public interface IPermissionDAO extends IBaseDAO{

    /**
     * @param id
     * @return List<Permission>
     * @throws Exception 根据用户的ID来获取用户的权限
     */
    public List<Permission> getPermissionsByUserId(String id);
}
