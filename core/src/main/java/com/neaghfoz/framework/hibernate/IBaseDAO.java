package com.neaghfoz.framework.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

public interface IBaseDAO<T extends Serializable> {

	/**
	 * 由子类根据需要注入相应SessionFactory
	 *
	 * @return
	 */
	public abstract Session getSession();

	public abstract Object save(Object entity);

	public abstract void update(Object entity);

	public abstract void saveOrUpdate(Object entity);

	public abstract Object merge(Object entity);

	public abstract void delete(Object entity);

	@SuppressWarnings("unchecked")
	public abstract T get(Serializable id);

	@SuppressWarnings("unchecked")
	public abstract T load(Serializable id);

	public abstract List<T> findAll(Order order, Property... propertys);

	public abstract List<T> findAll(Order[] orders, Property... propertys);

	public abstract List<T> findByPager(Pager pager, Order order,
			Property... propertys);

	@SuppressWarnings("unchecked")
	public abstract List<T> findByPager(Pager pager, Order[] orders,
			Property... propertys);

	public abstract Integer countByProperty(String propertyName,
			Property... propertys);

	/**
	 * 根据原生Sql查询(分页)
	 *
	 * @param pager  分页公共类
	 * @param sql    查询Sql串
	 * @param values 查询参数
	 * @param clazz  实体的class对象
	 * @return 返回查询结果
	 */
	public abstract Object findWithSql(Pager pager, String sql, Class clazz,
			Object... values);

	/**
	 * 根据原生Sql查询(不分页)
	 *
	 * @param sql    查询Sql串
	 * @param values 查询参数
	 * @param clazz  实体的class对象
	 * @return 返回查询结果
	 */
	public abstract Object findWithSql(String sql, Class clazz,
			Object... values);

	/**
	 * 根据原生Sql查询(不分页,不带查询参数)
	 *
	 * @param sql 查询Sql串
	 * @return 查询集合对象
	 */
	public abstract Object findWithSql(String sql);

	/**
	 * 根据原生Sql查询(不分页,不带查询参数)
	 *
	 * @param sql   查询Sql串
	 * @param clazz 实体的Class对象
	 * @return 查询集合对象
	 */
	public abstract Object findWithSql(String sql, Class clazz);

	/**
	 * 根据Hql查询(分页)
	 *
	 * @param pager  分页公共类
	 * @param hql    查询hql串
	 * @param values 查询参数
	 * @return 返回查询结果
	 */
	public abstract Object findWithHql(Pager pager, String hql,
			Object... values);

	/**
	 * 根据Hql查询(不分页)
	 *
	 * @param hql    查询hql串
	 * @param values 查询参数
	 * @return 返回查询结果
	 */
	public abstract Object findWitHql(String hql, Object... values);

	/**
	 * 根据Hql查询(不分页,不带查询参数)
	 *
	 * @param hql 查询hql串
	 * @return 查询集合对象
	 */
	public abstract Object findWitHql(String hql);

	/**
	 * 通过Sql执行更新/删除操作
	 *
	 * @param sql 待处理语句串
	 * @return 影响行数
	 */
	public abstract int updOrDelWithSql(String sql);

	/**
	 * 通过hql执行更新/删除操作
	 *
	 * @param hql 待处理语句串
	 * @return 影响行数
	 */
	public abstract int updOrDelWithHql(String hql);

}