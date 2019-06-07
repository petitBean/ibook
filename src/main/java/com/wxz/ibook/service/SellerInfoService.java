package com.wxz.ibook.service;

import com.wxz.ibook.domain.SellerInfo;

/**
 * @author Wangxingze
 * @date 2019-06-08 00:08
 */
public interface SellerInfoService {

    public SellerInfo save(SellerInfo sellerInfo);

    public SellerInfo findOneById(String id);

}
