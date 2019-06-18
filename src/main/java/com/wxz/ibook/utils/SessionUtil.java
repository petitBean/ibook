package com.wxz.ibook.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wangxingze
 * @date 2019-06-17 17:10
 */
public class SessionUtil {
    private static Map<String, HttpSession> sessionMap=new HashMap<>();

    public static synchronized void add(String sessionId,HttpSession session){
        sessionMap.put(sessionId,session);
    }

    public static HttpSession get(String sessionId){
        return sessionMap.get(sessionId);
    }

    public static synchronized void delete(String sessionId){
        sessionMap.remove(sessionId);
    }

}
