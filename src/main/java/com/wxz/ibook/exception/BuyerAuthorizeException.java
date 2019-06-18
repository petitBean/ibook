package com.wxz.ibook.exception;

import com.wxz.ibook.enums.ExceptionEnum;

/**
 * @author Wangxingze
 * @date 2019-06-18 15:15
 */
public class BuyerAuthorizeException extends  RuntimeException{
    private  Integer code;

    public BuyerAuthorizeException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code=exceptionEnum.getCode();
    }
}
