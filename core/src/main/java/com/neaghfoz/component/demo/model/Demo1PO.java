package com.neaghfoz.component.demo.model;

import com.neaghfoz.framework.jdbc.BaseModel;

import java.io.Serializable;

public class Demo1PO implements Serializable, BaseModel {
    private String demo1Id;

    private String name;

    private String sex;

    public String getDemo1Id() {
        return demo1Id;
    }

    public void setDemo1Id(String demo1Id) {
        this.demo1Id = demo1Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getTableName() {
        return "tb_demo1";
    }

    @Override
    public void setPrimaryKeyValue(Object primaryKeyValue) {
        if (primaryKeyValue instanceof String) {
            setDemo1Id(primaryKeyValue.toString());
        }
    }

    @Override
    public String getPrimaryKeyName() {
        return "demo1_id";
    }
}
