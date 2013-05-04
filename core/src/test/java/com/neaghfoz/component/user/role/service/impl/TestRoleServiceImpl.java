package com.neaghfoz.component.user.role.service.impl;

import com.neaghfoz.component.user.role.model.Role;
import com.neaghfoz.component.user.role.service.IRoleService;
import com.neaghfoz.component.user.user.enm.SexEnum;
import com.neaghfoz.component.user.user.enm.UserStatusEnum;
import com.neaghfoz.component.user.user.model.User;
import com.neaghfoz.component.user.user.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午8:21
 * To change this template use File | Settings | File Templates.
 */
public class TestRoleServiceImpl {
    private static ApplicationContext appContext;

    private static IRoleService roleService;

    static {
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        roleService = appContext.getBean("roleService", IRoleService.class);
    }

    @Test
    public void testDeleteRole() {
        Role role = new Role("1");
        roleService.deleteRole(role);
    }


}
