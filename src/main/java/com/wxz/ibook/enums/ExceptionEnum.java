package com.wxz.ibook.enums;

public enum ExceptionEnum {

    IMG_SOURCE_UPLOAD_FAILED(5,"图片上传失败！"),
    BUYER_AUTHORIZE_COOKIE_NULL(6,"查询不到用户cookie！"),
    ;
    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}