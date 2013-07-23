package com.neaghfoz.component.authorize.service.impl;


import java.util.Date;

import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.enm.SexEnum;
import com.neaghfoz.component.authorize.enm.UserStatusEnum;
import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.component.authorize.service.IUserService;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
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
    public void testSaveObj(){
/*    	User user = new User();
    	user.setUserName("admin");
    	user.setNickName("管理员");
    	user.setSex(SexEnum.Man.getValue());
    	user.setStatus(UserStatusEnum.Normal.getValue());
    	user.setCreateTime(new Date());
    	user.setPassword("123");
    	userService.saveObj(user);*/
    }

    @Test
    public void testFindWithHql() {
       /* String hql = "FROM User u";
        Object o = userService.findWithHql(hql);
        Assert.assertNotNull(o);*/
    }

    @Test
    public void testFindWithSql() {
      /*  String sql = "SELECT * FROM tb_user";  //表名大小写敏感
        Object o = userService.findWithSql(sql);
        
        Assert.assertNotNull(o);*/
    }
}
