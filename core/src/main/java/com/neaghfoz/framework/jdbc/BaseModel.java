package com.neaghfoz.framework.jdbc;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-19
 * Time: 下午9:24
 * To change this template use File | Settings | File Templates.
 */
public interface BaseModel {

    public String getTableName();

    public void setPrimaryKeyValue(Object primaryKeyValue);

    public Object getPrimaryKeyValue();

    public String getPrimaryKeyName();

}
