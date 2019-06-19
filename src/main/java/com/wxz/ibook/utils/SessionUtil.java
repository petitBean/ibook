package com.wxz.ibook.utils;

import com.wxz.ibook.constrant.SessionConstrant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

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

    //获取MAp的key
    public static List<String> getBookIdList(HttpServletRequest request){
        Map<String,Object> bookMap=getBookMap(request);
        if(bookMap==null){
            return null;
        }
        List<String>  bookIdList=new ArrayList<>();
        Iterator iterator=(bookMap.keySet()).iterator();
        while (iterator.hasNext()){
            bookIdList.add((String)iterator.next());
        }
        return bookIdList;
    }

    //获取map
    public static Map<String ,Object> getBookMap(HttpServletRequest request){
        HttpSession session=request.getSession();
        if (session==null){
            return null;
        }
        Map<String,Object> bookMap=( Map<String,Object>)session.getAttribute(SessionConstrant.BOOK_MAP);
        return bookMap;
    }

    //清空某个对象
    public static void clear(HttpServletRequest request,String attributeName){
        HttpSession session=request.getSession();
        if (session==null){
            return ;
        }
       session.setAttribute(attributeName,null);
    }



}
