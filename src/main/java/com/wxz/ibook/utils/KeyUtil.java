package com.wxz.ibook.utils;

import java.util.Random;

/**
 * @author Wangxingze
 * @date 2019-06-07 22:38
 */

public class KeyUtil {

    public static synchronized String getUniqueKey(){
        Random random=new Random();
        Integer integer=random.nextInt(100000)+900000;//900000-99999
        return System.currentTimeMillis()+String.valueOf(integer);
    }
}
