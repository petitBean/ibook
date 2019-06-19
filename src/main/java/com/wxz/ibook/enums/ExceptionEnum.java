package com.wxz.ibook.enums;

public enum ExceptionEnum {

    IMG_SOURCE_UPLOAD_FAILED(5,"图片上传失败！"),
    BUYER_AUTHORIZE_COOKIE_NULL(6,"查询不到用户cookie！"),
    BUYER_INFO_NULL(7,"用户为空"),
    BOOKSTOCK_NOT_ENOUGP(8,"库存不够"),
    ORDER_AMOUNT_NOT_ACCORD(9,"订单金额不一致"),
    SAVE_ORDER_FAILED(10,"订单数据存储失败"),
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