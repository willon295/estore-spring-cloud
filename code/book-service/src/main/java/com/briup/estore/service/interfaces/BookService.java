package com.briup.estore.service.interfaces;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.dto.BookQueryParamDTO;
import com.briup.estore.common.exception.BookException;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 书本相关业务接口，制定书本服务业务处理规范，主要提供：
 *
 * 1. 查询所有书本列表
 * 2. 分页查询书本列表
 * 3. 通过书本id查询书本信息
 * 4. 动态条件查询书本列表
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
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
     *
     * @param params 查询的参数
     * @return 书本信息
     * @throws BookException 异常
     */
    List<Book> listBooksConditionally(BookQueryParamDTO params) throws BookException;
}
