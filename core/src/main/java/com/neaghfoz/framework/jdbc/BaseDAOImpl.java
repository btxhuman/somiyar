package com.neaghfoz.framework.jdbc;

import com.neaghfoz.common.ReflectUtil;
import com.neaghfoz.component.demo.model.Demo1PO;
import com.neaghfoz.framework.base.BaseException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-19
 * Time: 下午9:24
 * To change this template use File | Settings | File Templates.
 */
public class BaseDAOImpl implements IBaseDAO {

    protected DataSource dataSource;

    protected NamedParameterJdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public <T extends BaseModel> void insertInto(T object) throws BaseException {
        BaseModel baseModel = object;
        //fieldList与columnNames 是一一对应的
        List<Field> fieldList = ReflectUtil.getAllFields(object);
        List<String> columnNames = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0, length = fieldList.size(); i < length; i++) {
            columnNames.add(i, ConvertFiledColumn.convertFiled2Column(fieldList.get(i).getName()));
        }
        StringBuffer sql = new StringBuffer("insert into " + baseModel.getTableName() + " (");
        for (int i = 0, length = columnNames.size(); i < length; i++) {
            if (i < length - 1) {
                sql.append(columnNames.get(i) + ",");
            } else {
                sql.append(columnNames.get(i) + ")");
            }

        }
        sql.append(" values (");
        for (int i = 0, length = fieldList.size(); i < length; i++) {
            Field field = fieldList.get(i);
            map.put(field.getName(), ReflectUtil.invokeGetterMethod(object, field.getName()));
            if (i < length - 1) {
                sql.append(":" + field.getName() + ",");
            } else {
                sql.append(":" + field.getName() + ")");
            }
        }
        String sqlString = sql.toString();
        System.out.println("自动生成的SQL语句为:" + sqlString);
        jdbcTemplate.update(sqlString, map);
    }
}
