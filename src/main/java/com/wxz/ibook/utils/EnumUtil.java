package com.wxz.ibook.utils;

import com.wxz.ibook.enums.EnumCode;

/**
 * @author Wangxingze
 * @date 2019-06-19 17:37
 */
public class EnumUtil {

    public static <T extends EnumCode>T getEnumByCode(Integer code, Class<T> enumClass){
        for(T enm:enumClass.getEnumConstants()){
            if(enm.getCode().equals(code)){
                return enm;
            }
        }
        return null;
    }
}
