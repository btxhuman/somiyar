package com.neaghfoz.framework.jdbc;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-19
 * Time: 下午9:24
 * To change this template use File | Settings | File Templates.
 */
public interface IBaseDAO {

    public abstract void setDataSource(DataSource dataSource);

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate);
}