package com.wxz.ibook.DataTransObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wxz.ibook.enums.OrderStatusEnum;
import com.wxz.ibook.enums.PayStatusEnum;
import com.wxz.ibook.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wangxingze
 * @date 2019-06-19 17:39
 */
@Data
public class OrderDTO {
    private String  orderId;
    /**
     * d订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态
     */
    private Integer orderStatus= OrderStatusEnum.NEW_ORSER.getCode();
    /**
     * 支付状态
     */
    private Integer  payStatus= PayStatusEnum.WAITING_PAY.getCode();
    /**
     * 买家id
     */
    private String buyerId;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家银行账户
     */
    private String buyerAccount;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    @JsonIgnore//在RestController中该对象会作为Json返回，为了忽略该字段加上该注释
    public OrderStatusEnum getOrderStatusEnum(){
        // return OrderStatusEnum.getByCode(payStatus);
        return EnumUtil.getEnumByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getEnumByCode(payStatus,PayStatusEnum.class);
    }
}
