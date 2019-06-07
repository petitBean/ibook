package com.wxz.ibook.domain;

import com.wxz.ibook.enums.OrderStatusEnum;
import com.wxz.ibook.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wangxingze
 * @date 2019-06-07 18:58
 */
@Data
@Entity
public class OrderMaster {
    /**
     * id
     */
    @Id
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
}
