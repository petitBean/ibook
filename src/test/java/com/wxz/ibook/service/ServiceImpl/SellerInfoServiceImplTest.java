package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.SellerInfo;
import com.wxz.ibook.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoServiceImpl sellerInfoService;

    @Test
    public void save() {
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setSellerAddress("湖北省武汉市洪山区新华书店");
        sellerInfo.setSellerName("新华书店");
        sellerInfo.setSellerPhone("13755635987");
        sellerInfo.setSellerIcon("#");
        SellerInfo re=sellerInfoService.save(sellerInfo);
        Assert.assertNotNull(re);
    }

    @Test
    public void findOneById() {
        SellerInfo re=sellerInfoService.findOneById("1559924464438959779");
        Assert.assertNotNull(re);
    }
}