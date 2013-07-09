package com.neaghfoz.component.authorize.action;

import com.neaghfoz.component.authorize.service.IUserService;
import com.neaghfoz.framework.base.PermissionAnnotation;
import com.neaghfoz.framework.struts.BaseAction;

import javax.annotation.Resource;

/**
 * 后台用户管理
 * *
 */
public class SysUserAction extends BaseAction {

    public String toLogin() {
        return "toLogin";
    }

    @PermissionAnnotation(value = "{aa}", matchAll = false)
    public String index() {
        return "index";
    }
}
