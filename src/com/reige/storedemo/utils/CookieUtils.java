package com.reige.storedemo.utils;

import javax.servlet.http.Cookie;

/**
 * Created by REIGE on 2017/7/6.
 */
public class CookieUtils {
    public static Cookie findCookieByName(Cookie[] cookies, String name) {
        if (cookies==null||cookies.length==0){
            return null;
        }
        for (Cookie cookie :cookies){
            if (cookie.getName().equals(name)){
                return cookie;
            }
        }
        return null;
    }
}
