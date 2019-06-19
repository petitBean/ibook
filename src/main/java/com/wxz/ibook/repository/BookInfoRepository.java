package com.wxz.ibook.repository;

import com.wxz.ibook.domain.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * 查询所有属于列表中类目的书籍
     * @param categoryList
     * @return
     */
    List<BookInfo> findBookInfoByCategoryTypeIn(List<Integer> categoryList);

    /**
     * 查询所有属于列表中id的书籍
     * @param bookIdList
     * @return
     */
    List<BookInfo> findBookInfoByBookIdIn(List<String> bookIdList);

    /**
     *
     */
    List<BookInfo> findBookInfoByBookName(String regx);

    /**
     * 模糊查询
     *注：字段名book_name与表中相同，没有nativeQuery = true时报creating bean failed的错误
     */
    @Query(value = "select * from book_info where book_name like %?1%",nativeQuery = true)
    List<BookInfo> findBookInfoByBookNameLike(String regx);


}