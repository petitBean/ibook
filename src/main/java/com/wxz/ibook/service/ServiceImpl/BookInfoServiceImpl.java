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
    @Override
    public BookInfo findOneById(String id){
        return bookInfoRepository.findById(id).orElse(null);
    }

    /**
     * 查询同一个类目的所有书籍
     * @param categoryType
     * @return
     */
    @Override
    public List<BookInfo> findListByCategoryType(Integer categoryType){
        return bookInfoRepository.findAllByCategoryType(categoryType);
       // return bookInfoRepository.findAllByCategory_type(categoryType);
        //return null;
    }


}
