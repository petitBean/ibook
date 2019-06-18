package com.wxz.ibook.repository;

import com.wxz.ibook.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 买家
 */
public interface BuyerRepository extends JpaRepository<Buyer,String> {

    /**
     * 通过电话查询
     * @param buyerPhone
     * @return
     */
    List<Buyer> findBuyerByBuyerPhone(String buyerPhone);

    /**
     * 查询一个
     * @param buyerPhone
     * @return
     */
    Buyer findByBuyerPhone(String buyerPhone );
}
