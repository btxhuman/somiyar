package com.neaghfoz.common;

import com.neaghfoz.framework.springsecurity.SimpleUserDetails;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-13
 * Time: 下午11:27
 * To change this template use File | Settings | File Templates.
 */
public class WebContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static SimpleUserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object obj = authentication == null ? null : authentication.getPrincipal();
        if (!(obj instanceof SimpleUserDetails)) {
            return null;
        }
        return (SimpleUserDetails) obj;
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }


}
