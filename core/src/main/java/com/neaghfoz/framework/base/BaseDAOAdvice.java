package com.neaghfoz.framework.base;

import org.aspectj.lang.JoinPoint;
import org.springframework.aop.ThrowsAdvice;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-6-25
 * Time: 下午2:14
 * To change this template use File | Settings | File Templates.
 */
public class BaseDAOAdvice implements ThrowsAdvice {

    public void afterThrowing(JoinPoint jp,Throwable throwable) {
        System.out.println("------切面对象target:" + jp.getTarget());
        System.out.println("hahahahahhaha:"+throwable.getMessage());
        if(throwable instanceof  Exception){
            Exception exception = (Exception) throwable;
            exception.printStackTrace();
        }
    }
}
