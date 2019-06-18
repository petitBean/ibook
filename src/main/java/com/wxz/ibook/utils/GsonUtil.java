package com.wxz.ibook.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 实现json字符串与对象间的转换
 * @author Wangxingze
 * @date 2019-06-17 14:40
 */
public class GsonUtil {

    /**
     * Java对象转json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();//格式化
        Gson gson=gsonBuilder.create();
        return gson.toJson(object);
    }

    /**
     * json字符串转换为Java对象
     * @param json
     * @param typeClass
     * @return
     */
    public static Object fromJson(String json,Class typeClass){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();//格式化
        Gson gson=gsonBuilder.create();
        return gson.fromJson(json,typeClass);
    }

}
