package com.neaghfoz.component.authorize.action;

import com.neaghfoz.component.authorize.service.IUserService;
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
}
