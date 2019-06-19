package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookInfo;

import java.util.List;

public interface BookInfoService {

    //通过id查询一个记录
     BookInfo findOneById(String bookId);

    //存储
     BookInfo save(BookInfo bookInfo);

    //存储list
    List<BookInfo> saveList(List<BookInfo> bookInfoList);

     List<BookInfo> findAll();

     //查找以书名redx开头的所有书籍
    List<BookInfo> findAllByName(String regx);

    //书名模糊查询
   List<BookInfo> findAllByBookNameLike(String regx);

    //查询某个类目的书籍
    List<BookInfo> findListByCategoryType(Integer integer);

    //查询多个类目书籍
    List<BookInfo> findListByCategoryList(List<Integer> categoryList);

    //查询多个id书籍
    List<BookInfo> findListByBookIdList(List<String> bookIdList);
}
