package com.tyc.boot.frame.web.util;

import cn.hutool.core.util.StrUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-14 14:13:37
 */
public class RequestUtil {
    private static final int MAX_COOKIE_AGE = 2 * 365 * 24 * 3600;

    public static void setCookie(String name, String value) {
        if(StrUtil.isBlank(value)){
            return;
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(MAX_COOKIE_AGE);
        getResponse().addCookie(cookie);
    }

    public static String getValueFromHeader(String key){
        HttpServletRequest request = getRequest();
        return request.getHeader(key);
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static String getSessionId(){
        return getSession().getId();
    }


    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
