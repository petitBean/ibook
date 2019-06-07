package com.wxz.ibook.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Wangxingze
 * @date 2019-06-07 21:17
 */
@Data
@Entity
public class SellerInfo {

    /**
     * 卖家id
     */
    @Id
    private String sellerId;
    /**
     * 店家名字
     */
    private String sellerName;
    /**
     * 店家地址
     */
    private String sellerAddress;
    /**
     * 店家电话
     */
    private String sellerPhone;
    /**
     * 店家图片
     */
    private String  sellerIcon;


}
