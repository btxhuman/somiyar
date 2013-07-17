package com.neaghfoz.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-7-9
 * Time: 上午8:46
 * To change this template use File | Settings | File Templates.
 */
public class HttpUtil {
    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxHeader = request.getHeader("X-Requested-With");
        return (ajaxHeader != null) && (ajaxHeader.contains("XMLHttpRequest"));
    }
}
