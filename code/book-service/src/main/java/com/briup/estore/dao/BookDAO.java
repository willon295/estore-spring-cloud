package com.briup.estore.dao;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.dto.BookQueryParamDTO;

import java.util.List;

public interface BookDAO {
    /**
     * 查出所有的书本信息
     *
     * @return 书本列表
     */
    List<Book> listBooks();

    /**
     * 通过书本id查出书本信息
     *
     * @param id 书本id
     * @return 书本
     */
    Book getBookById(Long id);


    /**
     * 有条件的查询书籍信息
     *
     * @param bookQueryParam 查询条件包装类
     * @return 书本列表
     */
    List<Book> listBooksConditionally(BookQueryParamDTO bookQueryParam);


}
