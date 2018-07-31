package com.briup.estore.service.impl;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.dto.BookQueryParamDTO;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.dao.BookDAO;
import com.briup.estore.service.interfaces.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书本服务 实现类， 实现  BookService 接口中所有方法,实现所有功能
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;


    @Override
    public List<Book> listBooks() throws BookException {
        return bookDAO.listBooks();
    }

    @Override
    public PageInfo<Book> listBooks(int currentPage) throws BookException {

        PageHelper.startPage(currentPage, 5);
        List<Book> books = bookDAO.listBooks();
        return new PageInfo<>(books);
    }

    @Override
    public Book getBookById(Long id) throws BookException {
        return bookDAO.getBookById(id);
    }

    @Override
    public List<Book> listBooksConditionally(BookQueryParamDTO params) throws BookException {

        return bookDAO.listBooksConditionally(params);
    }
}
