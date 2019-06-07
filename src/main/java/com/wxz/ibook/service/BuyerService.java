package com.wxz.ibook.service;

import com.wxz.ibook.domain.Buyer;

public interface BuyerService {

    //通过主键查找一个买家
    public Buyer findOne(String buyerId);

    //存储一个buyer
    public Buyer save(Buyer buyer);
}
