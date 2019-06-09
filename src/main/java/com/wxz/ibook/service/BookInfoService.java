package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookInfo;

import java.util.List;

public interface BookInfoService {

    //通过id查询一个记录
     BookInfo findOneById(String bookId);

    //存储
     BookInfo save(BookInfo bookInfo);

     List<BookInfo> findAll();

    //查询某个类目得书籍
    List<BookInfo> findListByCategoryType(Integer integer);

    //查询多个类目书籍
    List<BookInfo> findListByCategoryList(List<Integer> categoryList);
}
