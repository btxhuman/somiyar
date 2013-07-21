package com.neaghfoz.framework.jdbc;

import com.neaghfoz.component.demo.model.Demo1PO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: Mr-Zhong
 * Date: 13-7-20
 * Time: 下午4:47
 * To change this template use File | Settings | File Templates.
 */
public class TestBaseDAOImpl {
    private static ApplicationContext appContext;
    private static BaseDAOImpl baseDAO;

    static {
        appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        baseDAO = new BaseDAOImpl();
        DataSource dataSource = appContext.getBean("dataSource",DataSource.class);
        NamedParameterJdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate",NamedParameterJdbcTemplate.class);
        baseDAO.setDataSource(dataSource);
        baseDAO.setJdbcTemplate(jdbcTemplate);
    }
    @Test
    public void testInsertInto() throws Exception {
        Demo1PO demo1PO = new Demo1PO();
        demo1PO.setDemo1Id(UUID.randomUUID().toString());
        demo1PO.setName(null);
        baseDAO.insertInto(demo1PO);

    }
}
