package com.neaghfoz.component.demo.dao;

import com.neaghfoz.component.demo.model.Demo1PO;
import com.neaghfoz.framework.hibernate.IBaseDAO;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-4-30
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public interface IDemo1DAO extends IBaseDAO<Demo1PO>{
    
    public Demo1PO getDemo1po(String id);
}
