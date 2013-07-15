package com.neaghfoz.framework.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

public abstract class BaseDAOImpl<T extends Serializable> implements
		IBaseDAO<T> {

	private SessionFactory sessionFactory;

	private Class<T> className;
	protected Logger log;

	@SuppressWarnings("unchecked")
	public BaseDAOImpl() {
        Class clazz = getClass();
        while (clazz != Object.class) {
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType) t).getActualTypeArguments();
                if (args[0] instanceof Class) {
                    this.className = (Class<T>) args[0];
                    break;
                }
            }
            clazz = clazz.getSuperclass();
        }
        log = Logger.getLogger("sqlLog");
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#getSession()
	 */
	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#save(java.lang.Object)
	 */
	@Override
	public Object save(Object entity) {
		getSession().save(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#update(java.lang.Object)
	 */
	@Override
	public void update(Object entity) {
		getSession().update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#merge(java.lang.Object)
	 */
	@Override
	public Object merge(Object entity) {
		getSession().merge(entity);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#get(java.io.Serializable)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		T entity = (T) getSession().get(className, id);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.neaghfoz.framework.hibernate.IBaseDAO#load(java.io.Serializable)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T load(Serializable id) {
		T entity = (T) getSession().load(className, id);
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findAll(com.neaghfoz.common
	 * .util.Order, com.neaghfoz.framework.hibernate.Property)
	 */
	@Override
	public List<T> findAll(Order order, Property... propertys) {
		return findByPager(null, new Order[] { order }, propertys);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findAll(com.neaghfoz.common
	 * .util.Order[], com.neaghfoz.framework.hibernate.Property)
	 */
	@Override
	public List<T> findAll(Order[] orders, Property... propertys) {
		return findByPager(null, orders, propertys);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findByPager(com.neaghfoz.common
	 * .util.Pager, com.neaghfoz.framework.hibernate.Order,
	 * com.neaghfoz.framework.hibernate.Property)
	 */
	@Override
	public List<T> findByPager(Pager pager, Order order, Property... propertys) {
		return findByPager(pager, new Order[] { order }, propertys);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findByPager(com.neaghfoz.common
	 * .util.Pager, com.neaghfoz.framework.hibernate.Order[],
	 * com.neaghfoz.framework.hibernate.Property)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByPager(Pager pager, Order[] orders,
			Property... propertys) {
		Criteria criteria = getSession().createCriteria(className);
		// 查询条件
        if(null != propertys){
            for (Property property : propertys) {
                if (property != null)
                    criteria.add(property.getCriterion());
            }
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#countByProperty(java.lang.String
	 * , com.neaghfoz.framework.hibernate.Property)
	 */
	@Override
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
	protected List executeSqlQuery(Pager pager, String sql, Class clazz,
			Object... values) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWithSql(com.neaghfoz.common
	 * .util.Pager, java.lang.String, java.lang.Class, java.lang.Object)
	 */
	@Override
	public Object findWithSql(Pager pager, String sql, Class clazz,
			Object... values) {
		return executeSqlQuery(pager, sql, clazz, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWithSql(java.lang.String,
	 * java.lang.Class, java.lang.Object)
	 */
	@Override
	public Object findWithSql(String sql, Class clazz, Object... values) {
		return executeSqlQuery(null, sql, clazz, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWithSql(java.lang.String)
	 */
	@Override
	public Object findWithSql(String sql) {
		return executeSqlQuery(null, sql, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWithSql(java.lang.String,
	 * java.lang.Class)
	 */
	@Override
	public Object findWithSql(String sql, Class clazz) {
		return executeSqlQuery(null, sql, clazz, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWithHql(com.neaghfoz.common
	 * .util.Pager, java.lang.String, java.lang.Object)
	 */
	@Override
	public Object findWithHql(Pager pager, String hql, Object... values) {
		return executeQuery(pager, hql, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWitHql(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public Object findWitHql(String hql, Object... values) {
		return executeQuery(null, hql, values);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#findWitHql(java.lang.String)
	 */
	@Override
	public Object findWitHql(String hql) {
		return executeQuery(null, hql, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#updOrDelWithSql(java.lang.String
	 * )
	 */
	@Override
	public int updOrDelWithSql(String sql) {
		return getSession().createSQLQuery(sql).executeUpdate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neaghfoz.framework.hibernate.IBaseDAO#updOrDelWithHql(java.lang.String
	 * )
	 */
	@Override
	public int updOrDelWithHql(String hql) {
		return getSession().createQuery(hql).executeUpdate();
	}

}
