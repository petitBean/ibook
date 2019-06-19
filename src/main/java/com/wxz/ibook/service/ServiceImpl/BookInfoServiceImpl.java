package com.wxz.ibook.service.ServiceImpl;

import com.wxz.ibook.domain.BookInfo;
import com.wxz.ibook.repository.BookInfoRepository;
import com.wxz.ibook.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wangxingze
 * @date 2019-06-07 23:55
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoRepository bookInfoRepository;

    @Override
    public BookInfo save(BookInfo bookInfo){
        return bookInfoRepository.save(bookInfo);
    }

    //存储list
    @Override
    public  List<BookInfo>  saveList(List<BookInfo> bookInfoList){
        return bookInfoRepository.saveAll(bookInfoList);
    }
    @Override
    public BookInfo findOneById(String id){
        return bookInfoRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookInfo> findAll(){
        return bookInfoRepository.findAll();
    }

    /**
     * 查询同一个类目的所有书籍
     * @param categoryType
     * @return
     */
    @Override
    public List<BookInfo> findListByCategoryType(Integer categoryType){
        return bookInfoRepository.findAllByCategoryType(categoryType);
    }

    /**
     * 查询属于几个类目的书籍
     * @param categoryList
     * @return
     */
    @Override
    public List<BookInfo> findListByCategoryList(List<Integer> categoryList){
        return bookInfoRepository.findBookInfoByCategoryTypeIn(categoryList);
    }

    /**
     * 查找书名头部与regx匹配的书籍
     * @param regx
     * @return
     */
    @Override
    public List<BookInfo> findAllByBookNameLike(String regx){
        return bookInfoRepository.findBookInfoByBookNameLike(regx);
    }

    /**
     *
     * @return
     */
    @Override
    public List<BookInfo> findAllByName(String name){
        return bookInfoRepository.findBookInfoByBookName(name);
    }

    @Override
    public  List<BookInfo> findListByBookIdList(List<String> bookIdList){
        return bookInfoRepository.findBookInfoByBookIdIn(bookIdList);
    }
}
