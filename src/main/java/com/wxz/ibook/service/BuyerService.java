package com.wxz.ibook.service;

import com.wxz.ibook.domain.Buyer;

import java.util.List;

public interface BuyerService {

    //通过主键查找一个买家
    public Buyer findOne(String buyerId)throws Exception;

    //存储一个buyer
    public Buyer save(Buyer buyer)throws Exception;

    /**
     *
     * @param buyerPhone
     * @return
     */
    List<Buyer> findListByBuyerPhone (String buyerPhone)throws Exception;

    /**
     * 通过电话查询一个
     * @param buyerPhone
     * @return
     */
    Buyer findOneByBuyerPhone(String buyerPhone)throws Exception;
}
