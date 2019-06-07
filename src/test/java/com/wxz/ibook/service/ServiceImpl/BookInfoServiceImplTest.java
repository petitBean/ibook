package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookInfoServiceImplTest {
    @Autowired
    private BookInfoServiceImpl bookInfoService;

    @Test
    public void save() {
        BookInfo bookInfo=new BookInfo();
        bookInfo.setBookAuthor("谢希仁");
        bookInfo.setBookDescribe("高等学校计算机教材");
        bookInfo.setBookEdition("第七版");
        bookInfo.setBookIcon("#");
        bookInfo.setBookId(KeyUtil.getUniqueKey());
        bookInfo.setBookName("计算机网络");
        bookInfo.setBookPress("电子工业出版社");
        bookInfo.setCategoryType(1);
        bookInfo.setBookStock(200);
        bookInfo.setPublicTime("2001年10月1日");
        bookInfo.setBookPrice(new BigDecimal(45));
        bookInfo.setSellerId("1559924464438959779");
        BookInfo re=bookInfoService.save(bookInfo);
        Assert.assertNotNull(re);
    }

    @Test
    public void findOneById() {
        BookInfo bookInfo=bookInfoService.findOneById("1559926973272955180");
        Assert.assertEquals("1559926973272955180",bookInfo.getBookId());
    }

    @Test
    public void findByCategoryType() {
        List<BookInfo> list=bookInfoService.findListByCategoryType(1);
        Assert.assertEquals(2,list.size());
    }
}