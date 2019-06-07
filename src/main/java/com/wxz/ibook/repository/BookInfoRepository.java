package com.wxz.ibook.repository;

import com.wxz.ibook.domain.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Wangxingze
 * @date 2019-06-07 22:12
 */
public interface BookInfoRepository extends JpaRepository<BookInfo,String> {

    /**
     * 查询同一个类目的所有书籍
     * @param categoryType
     * @return
     */
    //List<BookInfo> findByCategory_type(Integer category_type);
    List<BookInfo> findAllByCategoryType(Integer categoryType);

}
