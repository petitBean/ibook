package com.wxz.ibook.repository;

import com.wxz.ibook.domain.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卖家书店
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

}
