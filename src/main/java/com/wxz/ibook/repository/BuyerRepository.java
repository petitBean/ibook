package com.wxz.ibook.repository;

import com.wxz.ibook.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 买家
 */
public interface BuyerRepository extends JpaRepository<Buyer,String> {

}
