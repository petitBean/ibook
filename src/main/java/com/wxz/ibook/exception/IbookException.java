package com.wxz.ibook.exception;

import com.wxz.ibook.enums.ExceptionEnum;

/**
 * 异常
 * @author Wangxingze
 * @date 2019-06-18 11:21
 */
public class IbookException extends RuntimeException {

    private Integer code;

    public IbookException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code=exceptionEnum.getCode();
    }

    public Integer getCode(){
        return code;
    }

}