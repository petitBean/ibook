package com.wxz.ibook.utils;

import java.math.BigDecimal;

/**
 * @author Wangxingze
 * @date 2019-06-19 16:15
 */
public class BigDecimalUtil {

    public static Integer compare(BigDecimal ob1,BigDecimal ob2){
        Double result=(ob1.subtract(ob2)).doubleValue();
        if(result<=0.01){
            return 0;
        }
        else if (result>0.01){
            return 1;
        }
        else {
            return -1;
        }
    }
}
