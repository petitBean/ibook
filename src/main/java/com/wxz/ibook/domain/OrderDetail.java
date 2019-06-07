package com.wxz.ibook.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Wangxingze
 * @date 2019-06-07 21:25
 */
@Entity
@Data
public class OrderDetail {

    /**
     * id
     */
    @Id
    private String orderDetailId;
    /**
     * 外键，订单id
     */
    private String orderId;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 单价
     */
    private BigDecimal bookPrice;
    /**
     * 数量
     */
    private Integer bookQuantity;
    /**
     * 图片
     */
    private String bookIcon;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;


}
