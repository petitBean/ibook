package com.wxz.ibook.service;

import com.wxz.ibook.domain.BookCategory;

public interface CategoryService {


    public BookCategory findOneById(Integer integer);
    //
    public BookCategory save(BookCategory bookCategory);
}
