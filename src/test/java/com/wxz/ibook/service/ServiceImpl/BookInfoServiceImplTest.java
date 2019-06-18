package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Arrays;
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
        bookInfo.setBookAuthor("李庆扬");
        bookInfo.setBookDescribe("高校计算机教材");
        bookInfo.setBookEdition("第5版");
        bookInfo.setBookIcon("#");
        bookInfo.setBookId(KeyUtil.getUniqueKey());
        bookInfo.setBookName("计算机数值分析");
        bookInfo.setBookPress("清华大学出版社");
        bookInfo.setCategoryType(1);
        bookInfo.setBookStock(20);
        bookInfo.setPublicTime("2014年6月");
        bookInfo.setBookPrice(new BigDecimal(40.0));
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

    @Test
    public void findListByCategoryList(){
        List<Integer> categoryList= Arrays.asList(1,2);
        List<BookInfo> list=bookInfoService.findListByCategoryList(categoryList);
        Assert.assertEquals(3,list.size());
    }


    @Test
    public void findAllByNameLike(){
        List<BookInfo> re=bookInfoService.findAllByBookNameLike("计算机");
        Assert.assertEquals(2,re.size());
    }

    @Test
    public void findAllByName(){
        List<BookInfo> re=bookInfoService.findAllByName("计算机网络");
        Assert.assertEquals(1,re.size());
    }

   @Test
    public void findListByIdList(){
        List<String> id=Arrays.asList("1559978586482980252","1559927203212928574");
        List<BookInfo> bookInfoList=bookInfoService.findListByBookIdList(id);
        Assert.assertEquals(2,bookInfoList.size());
    }

}