package com.wxz.ibook.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作cookie
 * @author Wangxingze
 * @date 2019-06-16 20:41
 */
public class CookieUtil {


    /**
     * 获取指点名称的cookie
     * @param request
     * @param cookieName
     * @return
     */
    public static Cookie get(HttpServletRequest request,String cookieName){
        Map<String,Cookie> cookieMap=readCookie(request);
        if(cookieMap!=null&&cookieMap.containsKey(cookieName)){
            return cookieMap.get(cookieName);
        }
        else {
            return null;
        }
    }

    /**
     * 清除cookie
     * @param response
     * @param cookieName
     */
    public static void delete(HttpServletResponse response,String cookieName){
        set(response,cookieName,null,0);
    }
   /**
     * 添加cookie
     * @param response HttPServletresponse
     * @param name   cookie's name
     * @param value   cookie's value
     * @param maxAge  cookie's maxAge
     */
    public static void set(HttpServletResponse response,String name, String value,Integer maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);

    }

    /**
     * @param response
     * @param name
     * @param value
     */
    public static void set(HttpServletResponse response,String name, String value){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(7200);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * @param response
     * @param name
     * @param value
     * @param maxAge
     * @param path
     */
    public static void set(HttpServletResponse response,String name, String value,Integer maxAge,String path){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        response.addCookie(cookie);
    }


    /**
     * 将cookie读到Map中
     * @param request
     * @return
     */
    private static Map<String,Cookie> readCookie(HttpServletRequest request){
        Map<String,Cookie> cookieMap=new HashMap<>();
        Cookie[] cookies=request.getCookies();
        //这里会有空指针异常
        if (cookies==null){
            return null;
        }
        for(Cookie cookie:cookies){
            if(cookie!=null){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }




}  //calss
