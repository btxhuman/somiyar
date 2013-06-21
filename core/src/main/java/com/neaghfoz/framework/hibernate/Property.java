package com.neaghfoz.framework.hibernate;

import java.util.Collection;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Property管理
 */
public class Property {

	Criterion criterion = null;
	
	private Property(){
	}
	
	private Property(Criterion criterion) {
		this.criterion = criterion;
	}

	/**
	 * Apply an "equal" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property eq(String propertyName, Object value) {
		return new Property(Restrictions.eq(propertyName, value));
	}
	/**
	 * Apply a "not equal" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property ne(String propertyName, Object value) {
		return new Property(Restrictions.ne(propertyName, value));
	}
	/**
	 * Apply a "like" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property like(String propertyName, Object value) {
		return new Property(Restrictions.like(propertyName, value));
	}
	
	/**
	 * Apply an "in" constraint to the named property
	 * @param propertyName
	 * @param values
	 * @return Property
	 */
	@SuppressWarnings("unchecked")
	public static Property in(String propertyName, Collection values) {
		return new Property(Restrictions.in(propertyName, values.toArray()));
	}
	/**
	 * Apply an "is null" constraint to the named property
	 * @return Property
	 */
	public static Property isNull(String propertyName) {
		return new Property(Restrictions.isNull(propertyName));
	}
	
	/**
	 * Apply an "is not null" constraint to the named property
	 * @return Property
	 */
	public static Property isNotNull(String propertyName) {
		return new Property(Restrictions.isNotNull(propertyName));
	}
	
	/**
	 * Apply an "is Empty" constraint to the named property
	 * @return Property
	 */
	public static Property isEmpty(String propertyName) {
		return new Property(Restrictions.isEmpty(propertyName));
	}
	
	/**
	 * Apply an "is not empty" constraint to the named property
	 * @return Property
	 */
	public static Property isNotEmpty(String propertyName) {
		return new Property(Restrictions.isNotEmpty(propertyName));
	}
	
	/**
	 * Apply a "greater than" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property gt(String propertyName, Object value) {
		return new Property(Restrictions.gt(propertyName, value));
	}
	/**
	 * Apply a "less than" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property lt(String propertyName, Object value) {
		return new Property(Restrictions.lt(propertyName, value));
	}
	/**
	 * Apply a "less than or equal" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property le(String propertyName, Object value) {
		return new Property(Restrictions.le(propertyName, value));
	}
	/**
	 * Apply a "greater than or equal" constraint to the named property
	 * @param propertyName
	 * @param value
	 * @return Property
	 */
	public static Property ge(String propertyName, Object value) {
		return new Property(Restrictions.ge(propertyName, value));
	}
	/**
	 * Apply a "between" constraint to the named property
	 * @param propertyName
	 * @param lo value
	 * @param hi value
	 * @return Property
	 */
	public static Property between(String propertyName, Object lo, Object hi) {
		return new Property(Restrictions.between(propertyName, lo, hi));
	}
	
	public Criterion getCriterion(){
		return this.criterion;
	}
}

