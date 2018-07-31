package com.briup.estore.dao;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.dto.BookQueryParamDTO;

import java.util.List;

/**
 * 书本 数据库 数据访问 接口， 该接口主要提供
 * 1. 查询所有书本信息
 * 2. 通过书本id查询书本信息
 * 3. 动态条件 查询 书本 列表
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
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
     * 动态条件 查询书籍信息
     *
     * @param bookQueryParam 查询条件
     * @return 书本列表
     */
    List<Book> listBooksConditionally(BookQueryParamDTO bookQueryParam);


}
