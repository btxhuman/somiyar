package com.neaghfoz.framework.jdbc;

import com.neaghfoz.component.demo.model.Demo1PO;
import com.neaghfoz.framework.base.BaseException;
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
        DataSource dataSource = appContext.getBean("dataSource", DataSource.class);
        NamedParameterJdbcTemplate jdbcTemplate = appContext.getBean("jdbcTemplate", NamedParameterJdbcTemplate.class);
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

    @Test
    public void testUpdate() throws BaseException {
        Demo1PO demo1PO = new Demo1PO();
        String pk = "7c5c9acd-41d8-4cdc-acd0-2eedd1540071";
        demo1PO.setDemo1Id(pk);
        demo1PO.setName("XXXXZX");
        demo1PO.setSex("0");
        baseDAO.insertInto(demo1PO);
        demo1PO.setSex("9");
        demo1PO.setName("FXXK");
        baseDAO.update(demo1PO, true);
    }
}
