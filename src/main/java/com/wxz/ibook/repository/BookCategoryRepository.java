package com.wxz.ibook.repository;

import com.wxz.ibook.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 书籍类目
 */
public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {

}
