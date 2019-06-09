package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookCategory;

import java.util.List;

public interface CategoryService {


    public BookCategory findOneById(Integer integer);
    //
    public BookCategory save(BookCategory bookCategory);

    List<BookCategory> findAll();
}
