package com.neaghfoz.component.authorize.user.service.impl;

import com.neaghfoz.component.authorize.user.service.UserService;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-4
 * Time: 下午8:21
 * To change this template use File | Settings | File Templates.
 */
public class TestUserService {
    private static ApplicationContext appContext;

    private static UserService userService;

    static {
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = appContext.getBean("userService", UserService.class);
    }

    @Test
    public void testFindWithHql() {
        String hql = "FROM User u";
        Object o = userService.findWithHql(hql);
        Assert.assertNotNull(o);
    }

    @Test
    public void testFindWithSql() {
        String sql = "SELECT * FROM tb_user";  //表名大小写敏感
        Object o = userService.findWithSql(sql);
        Assert.assertNotNull(o);
    }
}
