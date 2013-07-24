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

    private static final Map<Class, List<String>> columnsMap = new HashMap<Class, List<String>>();

    private static final Map<Class, List<Field>> fieldsMap = new HashMap<Class, List<Field>>();


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
        List<Field> fieldList = getFields(clazz);
        List<String> columnNames = getColumns(clazz, fieldList);
        Map<String, Object> map = new HashMap<String, Object>();

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

    public <T extends BaseModel> void update(T object, Boolean ignoreNullValue) {
        Class clazz = object.getClass();
        //fieldList与columnNames 是一一对应的
        List<Field> fieldList = getFields(clazz);
        List<String> columnNames = getColumns(clazz, fieldList);
        Map<String, Object> map = new HashMap<String, Object>();

        StringBuffer sql = new StringBuffer("update " + object.getTableName() + " set ");
        String primaryKeyField = null;
        for (int i = 0, length = fieldList.size(); i < length; i++) {
            Field field = fieldList.get(i);
            Object result = ReflectUtil.invokeGetterMethod(object, field.getName());
            if (null == result && ignoreNullValue) {
                continue;
            } else if (columnNames.get(i).equalsIgnoreCase(object.getPrimaryKeyName())) {
                primaryKeyField = fieldList.get(i).getName();
            } else {
                map.put(field.getName(), result);
                sql.append(columnNames.get(i) + " = :" + field.getName() + ", ");
            }
        }
        sql.append(object.getPrimaryKeyName() + " = " + object.getPrimaryKeyName());
        Object pkValue = ReflectUtil.invokeGetterMethod(object, primaryKeyField);
        sql.append(" where " + object.getPrimaryKeyName() + " = :_primaryKey_");
        map.put("_primaryKey_", pkValue);
        String sqlString = sql.toString();
        System.out.println("自动生成的SQL语句为:" + sqlString);
        jdbcTemplate.update(sqlString, map);
    }

    private List<Field> getFields(Class clazz) {
        List<Field> fieldList = fieldsMap.get(clazz);
        if (fieldList == null) {
            fieldList = ReflectUtil.getAllFields(clazz);
            fieldsMap.put(clazz, fieldList);
        }
        return fieldList;
    }

    private List<String> getColumns(Class clazz, List<Field> fieldList) {
        List<String> columnsList = columnsMap.get(clazz);
        if (columnsList == null) {
            columnsList = new ArrayList<String>(fieldList.size());
            for (int i = 0, length = fieldList.size(); i < length; i++) {
                columnsList.add(i, ConvertFiledColumn.convertFiled2Column(fieldList.get(i).getName()));
            }
            columnsMap.put(clazz, columnsList);
        }
        return columnsList;
    }
}
