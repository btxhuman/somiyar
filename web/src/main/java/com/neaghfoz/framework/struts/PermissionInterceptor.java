package com.neaghfoz.framework.struts;

import com.neaghfoz.common.WebContext;
import com.neaghfoz.common.util.HttpUtil;
import com.neaghfoz.framework.base.PermissionAnnotation;
import com.neaghfoz.framework.springsecurity.SimpleUserDetails;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-9
 * Time: 上午8:50
 * To change this template use File | Settings | File Templates.
 */
public class PermissionInterceptor implements Interceptor {

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        SimpleUserDetails userDetails = WebContext.getUserDetails();
        PermissionAnnotation permissionAnnotation = getPermissions(invocation);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        if (null != userDetails && null != permissionAnnotation) {
            Collection<GrantedAuthority> authorities = userDetails.getAuthorities();
            boolean matchResult = false;
            //匹配所有权限
            if (permissionAnnotation.matchAll()) {
                matchResult = matchAllPermission(permissionAnnotation.value(), authorities);
            } else { //匹配某一个权限即可
                matchResult = matchAnyPermission(permissionAnnotation.value(), authorities);
            }
            if (!matchResult) {
                //判断是否ajax请求
                if (HttpUtil.isAjaxRequest(request)) {

                } else {
                    //没有权限访问Action返回403错误页面
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    return null;
                }
            }
        }
        return invocation.invoke();
    }

    /**
     * @param invocation
     * @return 返回action方法的注解PermissionAnnotation具体的对象
     */
    private PermissionAnnotation getPermissions(ActionInvocation invocation) throws Exception {
        ActionProxy actionProxy = invocation.getProxy();
        Object action = actionProxy.getAction();
        String method = actionProxy.getMethod();
        Method actionMethod = action.getClass().getMethod(method, new Class[0]);
        return (PermissionAnnotation) actionMethod.getAnnotation(PermissionAnnotation.class);
    }

    /**
     * @param permissions 注解中获得权限码
     * @param authorities 用户所用的权限码
     */
    private Boolean matchAllPermission(String[] permissions, Collection<GrantedAuthority> authorities) {
        Iterator<GrantedAuthority> iterator = authorities.iterator();
        while (iterator.hasNext()) {
            GrantedAuthority grantedAuthority = iterator.next();
            for (String string : permissions) {
                if (!string.equals(grantedAuthority.getAuthority())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param permissions 注解中获得权限码
     * @param authorities 用户所用的权限码
     */
    private Boolean matchAnyPermission(String[] permissions, Collection<GrantedAuthority> authorities) {
        Iterator<GrantedAuthority> iterator = authorities.iterator();
        while (iterator.hasNext()) {
            GrantedAuthority grantedAuthority = iterator.next();
            for (String string : permissions) {
                if (string.equals(grantedAuthority.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }
}
