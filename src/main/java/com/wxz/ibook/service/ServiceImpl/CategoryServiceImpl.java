package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookCategory;
import com.wxz.ibook.repository.BookCategoryRepository;
import com.wxz.ibook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wangxingze
 * @date 2019-06-07 23:13
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BookCategoryRepository categoryRepository;

    @Override
    public BookCategory findOneById(Integer id){
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public BookCategory save(BookCategory bookCategory){
        return categoryRepository.save(bookCategory);
    }
}
