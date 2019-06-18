package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.Buyer;
import com.wxz.ibook.repository.BuyerRepository;
import com.wxz.ibook.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wangxingze
 * @date 2019-06-07 22:19
 */
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public Buyer findOne(String buyerId)throws Exception{
        return buyerRepository.findById(buyerId).orElse(null);
    }

    @Override
    public Buyer save(Buyer buyer)throws Exception{
        return buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> findListByBuyerPhone(String buyerPhone)throws Exception{
        return buyerRepository.findBuyerByBuyerPhone(buyerPhone);
    }

    @Override
   public Buyer findOneByBuyerPhone(String buyerPhone) throws Exception{
        return buyerRepository.findByBuyerPhone(buyerPhone);
    }

}
