package com.neaghfoz.component.demo.demo1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zhong
 * Date: 13-5-2
 * Time: 下午10:24
 * To change this template use File | Settings | File Templates.
 */
public class AdviceDemo {


    public void beforeTx(JoinPoint jp){
        System.out.println("------切面处理：before start");
        System.out.println("------切面对象target:" + jp.getTarget());
        System.out.println("------切面对象method:" + jp.getSignature().getName());
        System.out.println("------切面对象的方法参数:" + Arrays.toString(jp.getArgs()));
        System.out.println("------切面处理：before end");
    }

//    public Object ArroundTx(ProceedingJoinPoint jp){
//        return null;
//    }

    public void afterTx(JoinPoint jp){
        System.out.println("******切面处理：after start");
        System.out.println("******切面处理：after end");
    }

}
