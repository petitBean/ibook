package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookInfo;

import java.util.List;

public interface BookInfoService {

    //通过id查询一个记录
    public BookInfo findOneById(String bookId);

    //存储
    public BookInfo save(BookInfo bookInfo);

    //查询某个类目得书籍
    List<BookInfo> findListByCategoryType(Integer integer);
}
