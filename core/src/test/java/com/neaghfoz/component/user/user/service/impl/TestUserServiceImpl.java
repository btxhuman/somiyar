package com.neaghfoz.component.user.user.service.impl;

import com.neaghfoz.component.demo.demo1.service.IDemo1Service;
import com.neaghfoz.component.user.role.model.Role;
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
public class TestUserServiceImpl {
    private static ApplicationContext appContext;

    private static IUserService userService;

    static {
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = appContext.getBean("userService", IUserService.class);
    }

    @Test
    public void testSaveUser() {
        Set<Role> roleSet = new HashSet<Role>();
        roleSet.add(new Role("1"));
        roleSet.add(new Role("2"));
        User user = new User();
        user.setUserName("hahah");
        user.setCreateTime(new Date());
        user.setStatus(UserStatusEnum.Normal.getValue());
        user.setSex(SexEnum.Man.getValue());
        user.setRoleSet(roleSet);
        userService.saveUser(user);
    }

    @Test
    public void testDeleteUser(){
        User user = new User();
        user.setUserId("");
        userService.deleteUser(user);
    }
}
