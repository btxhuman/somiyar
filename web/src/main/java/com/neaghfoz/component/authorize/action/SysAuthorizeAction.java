package com.neaghfoz.component.authorize.action;

import com.neaghfoz.framework.base.PermissionAnnotation;
import com.neaghfoz.framework.struts.BaseAction;

/**
 * 后台登录（具体实现是由spring-security来实现）
 * @author btxhuman
 * *
 */
public class SysAuthorizeAction extends BaseAction {

    public String toLogin() {
        return "toLogin";
    }

    public String logout(){
        return "logout";
    }

    public String index(){
        return "index";
    }

    @PermissionAnnotation(value = {"ROLE_USER", "test2"}, matchAll = false)
    public String test() {
        return "test";
    }
}
