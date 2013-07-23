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

    private static final Map<Class, Map<String, String>> fieldColumnMap = new HashMap<Class, Map<String, String>>();

    private static final Map<Class, Map<String, String>> columnFieldMap = new HashMap<Class, Map<String, String>>();


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public <T extends BaseModel> void insertInto(T object) throws BaseException {
        BaseModel baseModel = object;
        Class clazz = object.getClass();
        //fieldList与columnNames 是一一对应的
        Map<String, String> fieldColumn = getFields(clazz);
        Map<String, String> columnField = getColumns(clazz);
        Map<String, Object> map = new HashMap<String, Object>();

        StringBuffer sql = new StringBuffer("insert into " + baseModel.getTableName() + " (");
       /* for (int i = 0, length = columnNames.size(); i < length; i++) {
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
        }*/
        String sqlString = sql.toString();
        System.out.println("自动生成的SQL语句为:" + sqlString);
        jdbcTemplate.update(sqlString, map);
    }

    public <T extends BaseModel> void update(T object, Boolean ignoreNullValue) {
        Class clazz = object.getClass();
        Map<String, String> fieldColumn = getFields(clazz);
        Map<String, String> columnField = getColumns(clazz);
        Map<String, Object> map = new HashMap<String, Object>();

        StringBuffer sql = new StringBuffer("update " + object.getTableName() + " set ");
        for (Map.Entry<String, String> entry : fieldColumn.entrySet()) {
            Object result = ReflectUtil.invokeGetterMethod(object, entry.getKey());
            if (entry.getValue().equalsIgnoreCase(object.getPrimaryKeyName())
                    || (null == result && ignoreNullValue)) {
                continue;
            } else {
                map.put(entry.getKey(), result);
                sql.append(entry.getValue() + " = :" + entry.getKey() + ", ");
            }
        }
        sql.append(object.getPrimaryKeyName() + " = " + object.getPrimaryKeyName());
        Object pkValue = ReflectUtil.invokeGetterMethod(object, columnField.get(object.getPrimaryKeyName()));
        sql.append(" where " + object.getPrimaryKeyName() + " = :_primaryKey");
        map.put("_primaryKey", pkValue);
        String sqlString = sql.toString();
        System.out.println("自动生成的SQL语句为:" + sqlString);
        jdbcTemplate.update(sqlString, map);
    }

    private Map<String, String> getFields(Class clazz) {
        Map<String, String> map = fieldColumnMap.get(clazz);
        if (map == null) {
            List<Field> fieldList = ReflectUtil.getAllFields(clazz);
            map = new HashMap<String, String>(fieldList.size());
            for (Field field : fieldList) {
                map.put(field.getName(), ConvertFiledColumn.convertFiled2Column(field.getName()).toLowerCase());
            }
            fieldColumnMap.put(clazz, map);
        }
        return map;
    }

    private Map<String, String> getColumns(Class clazz) {
        Map<String, String> map = columnFieldMap.get(clazz);
        if (null != map) {
            return map;
        }
        Map<String, String> fieldMap = getFields(clazz);
        map = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        return map;
    }
}
