package com.wxz.ibook.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Wangxingze
 * @date 2019-06-07 18:50
 * 买家
 */
@Data
@Entity
public class Buyer implements Serializable {


    private static final long serialVersionUID = -4178001309655755205L;
    /**
     * id
     */
    @Id
    private String buyerId;
    /**
     * 密码
     */
    private  String password;
    /**
     * 姓名
     */
    private String buyerName;
    /**
     * 电话
     */
    private String buyerPhone;
    /*8
    账号
     */
    private String buyerAccount;
    /**
     * 地址
     */
    private String buyerAddress;
    /**
     * 头像连接
     */
    private String buyerIcon;

}
