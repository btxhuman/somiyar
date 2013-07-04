package com.neaghfoz.common;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-4
 * Time: 下午5:56
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    /**
     * 超级管理员的帐号
     */
    public static String[] SUPER_ADMIN = null;

    static {
        Properties properties = null;
        try {
            properties = new Properties();
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        init(properties);
    }

    private static void init(Properties properties) {
        if (null == properties) return;
        SUPER_ADMIN = properties.getProperty("super_admin").split(",");
    }


}
