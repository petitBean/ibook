package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOneById() {
        BookCategory re=categoryService.findOneById(1);
        Assert.assertNotNull(re);
    }

    @Test
    public void save() {
        BookCategory bookCategory=new BookCategory();
        bookCategory.setCategoryName("文学类");
        bookCategory.setCategoryType(2);
        BookCategory re=categoryService.save(bookCategory);
        Assert.assertNotNull(re);
    }
}