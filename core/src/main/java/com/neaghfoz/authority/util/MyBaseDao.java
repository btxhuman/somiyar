package com.neaghfoz.authority.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.neaghfoz.util.Order;
import com.neaghfoz.util.Pager;
import com.neaghfoz.util.Property;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 * 基础DAO类
 *
 * @param <T> 泛型，对象类型
 */
public abstract class MyBaseDao<T extends Serializable> {

    /**
     * 由子类根据需要注入相应SessionFactory
     *
     * @return
     */
    public abstract Session getSession();

    private Class<T> className;
    protected Logger log;

    @SuppressWarnings("unchecked")
    public MyBaseDao() {
        className = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        log = Logger.getLogger("sqlLog");
    }

    public T save(T entity) {
        getSession().save(entity);
        return entity;
    }

    public void update(Object entity) {
        getSession().update(entity);
    }

    public void saveOrUpdate(Object entity) {
        getSession().saveOrUpdate(entity);
    }

    public Object merge(Object entity) {
        getSession().merge(entity);
        return entity;
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        T entity = (T) getSession().get(className, id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public T load(Serializable id) {
        T entity = (T) getSession().load(className, id);
        return entity;
    }

    public List<T> findAll(Order order, Property... propertys) {
        return findByPager(null, new Order[]{order}, propertys);
    }

    public List<T> findAll(Order[] orders, Property... propertys) {
        return findByPager(null, orders, propertys);
    }

    public List<T> findByPager(Pager pager, Order order, Property... propertys) {
        return findByPager(pager, new Order[]{order}, propertys);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByPager(Pager pager, Order[] orders,
                               Property... propertys) {
        Criteria criteria = getSession().createCriteria(className);
        // 查询条件
        for (Property property : propertys) {
            if (property != null)
                criteria.add(property.getCriterion());
        }
        // 分页
        if (pager != null) {
            criteria.setProjection(Projections.rowCount());
            Long count = (Long) criteria.uniqueResult();

            if (count == null)
                return new ArrayList();
            pager.setTotalSize(count);
            criteria.setFirstResult((pager.getCurrentPage() - 1)
                    * pager.getPageSize());
            criteria.setMaxResults(pager.getPageSize());
            criteria.setProjection(null);
        }
        // 排序
        if (orders != null && orders.length > 0) {
            for (Order order : orders) {
                if (order != null)
                    criteria.addOrder(order.getHibernateOrder());
            }
        }
        return criteria.list();
    }

    public Integer countByProperty(String propertyName, Property... propertys) {
        Criteria criteria = getSession().createCriteria(className);
        // 查询条件
        for (Property property : propertys) {
            if (property != null)
                criteria.add(property.getCriterion());
        }
        criteria.setProjection(Projections.count(propertyName));
        return (Integer) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    protected List executeQuery(String hql, Object... values) {
        return executeQuery(null, hql, values);
    }

    @SuppressWarnings("unchecked")
    protected List executeQuery(Pager pager, String hql, Object... values) {
        Query query = getSession().createQuery(hql);
        for (int i = 0; values != null && i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        if (pager != null) {
            query.setFirstResult((pager.getCurrentPage() - 1)
                    * pager.getPageSize());
            query.setMaxResults(pager.getPageSize());
        }
        return query.list();
    }

    protected Long executeCount(String hql, Object... values) {
        Query query = getSession().createQuery("select count(1) " + hql);
        for (int i = 0; values != null && i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return (Long) query.list().get(0);
    }

    protected void writeLog(String message) {
        String className = getClass().getName();
        log.debug("在" + className + "中...\r\n" + message);
    }

    @SuppressWarnings("unchecked")
    protected List executeSqlQuery(Pager pager, String sql, Class clazz, Object... values) {
        Query query = getSession().createSQLQuery(sql);

        if (clazz != null)
            ((SQLQuery) query).addEntity(clazz);

        if (values != null && values.length > 0) {
            int len = values.length;
            for (int i = 0; i < len; i++) {
                query.setParameter(i, values[i]);
            }
        }

        if (pager != null) {
            query.setFirstResult((pager.getCurrentPage() - 1)
                    * pager.getPageSize());
            query.setMaxResults(pager.getPageSize());
        }
        return query.list();
    }

    /**
     * 根据原生Sql查询(分页)
     *
     * @param pager  分页公共类
     * @param sql    查询Sql串
     * @param values 查询参数
     * @param clazz  实体的class对象
     * @return 返回查询结果
     */
    public Object findWithSql(Pager pager, String sql, Class clazz, Object... values) {
        return executeSqlQuery(pager, sql, clazz, values);
    }

    /**
     * 根据原生Sql查询(不分页)
     *
     * @param sql    查询Sql串
     * @param values 查询参数
     * @param clazz  实体的class对象
     * @return 返回查询结果
     */
    public Object findWithSql(String sql, Class clazz, Object... values) {
        return executeSqlQuery(null, sql, clazz, values);
    }

    /**
     * 根据原生Sql查询(不分页,不带查询参数)
     *
     * @param sql 查询Sql串
     * @return 查询集合对象
     */
    public Object findWithSql(String sql) {
        return executeSqlQuery(null, sql, null);
    }

    /**
     * 根据原生Sql查询(不分页,不带查询参数)
     *
     * @param sql   查询Sql串
     * @param clazz 实体的Class对象
     * @return 查询集合对象
     */
    public Object findWithSql(String sql, Class clazz) {
        return executeSqlQuery(null, sql, clazz, null);
    }

    /**
     * 根据Hql查询(分页)
     *
     * @param pager  分页公共类
     * @param hql    查询hql串
     * @param values 查询参数
     * @return 返回查询结果
     */
    public Object findWithHql(Pager pager, String hql, Object... values) {
        return executeQuery(pager, hql, values);
    }

    /**
     * 根据Hql查询(不分页)
     *
     * @param hql    查询hql串
     * @param values 查询参数
     * @return 返回查询结果
     */
    public Object findWitHql(String hql, Object... values) {
        return executeQuery(null, hql, values);
    }

    /**
     * 根据Hql查询(不分页,不带查询参数)
     *
     * @param hql 查询hql串
     * @return 查询集合对象
     */
    public Object findWitHql(String hql) {
        return executeQuery(null, hql, null);
    }

    /**
     * 通过Sql执行更新/删除操作
     *
     * @param sql 待处理语句串
     * @return 影响行数
     */
    public int updOrDelWithSql(String sql) {
        return getSession().createSQLQuery(sql).executeUpdate();
    }

    /**
     * 通过hql执行更新/删除操作
     *
     * @param hql 待处理语句串
     * @return 影响行数
     */
    public int updOrDelWithHql(String hql) {
        return getSession().createQuery(hql).executeUpdate();
    }

}