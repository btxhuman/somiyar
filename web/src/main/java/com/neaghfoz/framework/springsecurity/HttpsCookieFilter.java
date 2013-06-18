package com.neaghfoz.framework.springsecurity;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ZhiMing Zhong
 * Date: 13-6-18
 * Time: 下午3:41
 * To change this template use File | Settings | File Templates.
 */
public class HttpsCookieFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }
}
