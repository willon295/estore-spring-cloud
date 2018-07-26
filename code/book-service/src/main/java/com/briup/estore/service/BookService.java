package com.briup.estore.service;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.dto.BookQueryParamDTO;
import com.briup.estore.common.exception.BookException;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 书本服务接口
 *
 * @author willon
 */
public interface BookService {

    /**
     * 查询所有书籍的信息
     *
     * @return List 所有书本
     * @throws BookException 书本查询异常
     */
    List<Book> listBooks() throws BookException;


    /**
     * 分页查询 书本信息
     *
     * @param currentPage 当前页
     * @return 当前页所有书本信息
     * @throws BookException 异常
     */
    PageInfo<Book> listBooks(int currentPage) throws BookException;


    /**
     * 通过id 查询书本信息
     *
     * @param id 书本id
     * @return Book 书本信息
     * @throws BookException 异常
     */
    Book getBookById(Long id) throws BookException;


    /**
     * 有条件的查询书本信息
     * @param params 查询的参数
     * @return 书本信息
     * @throws BookException 异常
     */
    List<Book> listBooksConditionally(BookQueryParamDTO params) throws BookException;
}
