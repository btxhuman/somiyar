package com.neaghfoz.framework.struts;

import com.neaghfoz.framework.base.PermissionAnnotation;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-7-9
 * Time: 上午8:50
 * To change this template use File | Settings | File Templates.
 */
public class PermissionInterceptor implements Interceptor{

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void init() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *@param  invocation
     *@return 返回action方法的注解PermissionAnnotation具体的对象
     **/
    private PermissionAnnotation getActionRole(ActionInvocation invocation) throws Exception {
        ActionProxy actionProxy = invocation.getProxy();
        Object action = actionProxy.getAction();
        String method = actionProxy.getMethod();
        Method actionMethod = action.getClass().getMethod(method, new Class[0]);
        return (PermissionAnnotation)actionMethod.getAnnotation(PermissionAnnotation.class);
    }
}
