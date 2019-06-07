package com.wxz.ibook.enums;

import lombok.Getter;

/**
 * 支付状态 0-未支付 1-已支付
 */
@Getter
public enum PayStatusEnum {
    WAITING_PAY(0,"未支付"),
    PAIED(1,"已支付"),
    ;
    private Integer code;
    private String msg;
    PayStatusEnum(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

}
