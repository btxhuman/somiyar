package com.neaghfoz.framework.jdbc;

import com.neaghfoz.component.demo.model.Demo1PO;
import com.neaghfoz.framework.base.BaseException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
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
        demo1PO.setName(System.currentTimeMillis() + "");
        baseDAO.insertInto(demo1PO);
    }

    @Test
    public void testUpdate() throws BaseException {
        Demo1PO demo1PO = new Demo1PO();
        String pk = UUID.randomUUID().toString();
        demo1PO.setDemo1Id(pk);
        demo1PO.setName("XXXXZX");
        demo1PO.setSex("0");
        baseDAO.insertInto(demo1PO);
        demo1PO.setSex("9");
        demo1PO.setName("FXXK");
        baseDAO.update(demo1PO, true);
    }

    @Test
    public void testDeleteByPK() throws BaseException {
        Demo1PO demo1PO = new Demo1PO();
        String pk = UUID.randomUUID().toString();
        demo1PO.setDemo1Id(pk);
        demo1PO.setName("XXXXZX");
        demo1PO.setSex("0");
        baseDAO.insertInto(demo1PO);
        baseDAO.deleteByPK(demo1PO);
    }

    @Test
    public void testGetList() throws BaseException {
        String sql = "select * from tb_demo1";
        for (int i = 0; i < 10; i++) {
            Demo1PO demo1PO = new Demo1PO();
            String pk = UUID.randomUUID().toString();
            demo1PO.setDemo1Id(pk);
            demo1PO.setName("XXXXZX");
            demo1PO.setSex("0");
            baseDAO.insertInto(demo1PO);
        }
        List<Demo1PO> list = baseDAO.getList(sql, null, Demo1PO.class);
        for (Demo1PO demo1PO : list) {
            System.out.println(demo1PO.getName());
        }
    }
}
