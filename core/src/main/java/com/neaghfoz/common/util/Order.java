package com.neaghfoz.common.util;

import java.io.Serializable;

/**
 * 排序
 */
@SuppressWarnings("serial")
public class Order implements Serializable {
	
	private String propertyName;
	private OrderType orderType;
	
	private static enum OrderType{
		ASC,DESC
	}
	
	private Order(String propertyName, OrderType orderType){
		this.propertyName = propertyName;
		this.orderType = orderType;
	}

	public static Order asc(String propertyName) {
		return new Order(propertyName, OrderType.ASC);
	}
	
	public static Order desc(String propertyName) {
		return new Order(propertyName, OrderType.DESC);
	}

	public org.hibernate.criterion.Order getHibernateOrder(){
		org.hibernate.criterion.Order order = null;
		if(orderType == OrderType.ASC)
			order =  org.hibernate.criterion.Order.asc(propertyName);
		else if(orderType == OrderType.DESC)
			order =  org.hibernate.criterion.Order.desc(propertyName);
		return order;
	}

}