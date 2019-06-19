package com.wxz.ibook.enums;

/**
 * 订单状态 0-新订单 1-完结 2-已经取消
 */
public enum OrderStatusEnum implements EnumCode{
    NEW_ORSER(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;
    private String msg;
    OrderStatusEnum(int code,String msg){
        this.code=Integer.valueOf(code);
        this.msg=msg;
    }

    public Integer getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
}
