package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.SellerInfo;
import com.wxz.ibook.repository.SellerInfoRepository;
import com.wxz.ibook.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wangxingze
 * @date 2019-06-08 00:10
 */
@Service
public class SellerInfoServiceImpl implements SellerInfoService {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo save(SellerInfo sellerInfo) {
        return sellerInfoRepository.save(sellerInfo);
    }

    @Override
    public SellerInfo findOneById(String id) {
        return sellerInfoRepository.findById(id).orElse(null);
    }
}
