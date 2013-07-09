package com.neaghfoz.framework.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-9
 * Time: 上午8:52
 * 权限注解,其实现过程 可以详见PermissionInterceptor.java
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionAnnotation {
    public abstract String[] value();

    public boolean matchAll() default true;
}
