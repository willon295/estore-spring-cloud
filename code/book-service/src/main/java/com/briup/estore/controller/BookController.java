package com.briup.estore.controller;

import com.briup.estore.common.bean.Book;
import com.briup.estore.common.dto.BookQueryParamDTO;
import com.briup.estore.common.dto.ResponseDTO;
import com.briup.estore.common.exception.BookException;
import com.briup.estore.service.interfaces.BookService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 书本相关 请求 处理类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Slf4j
@RestController
public class BookController {

    private static final String MSG_FAILED = "FAILED";
    private static final String MSG_OK = "OK";

    @Autowired
    private BookService bookService;

    /**
     * 查询当前页 所有书本信息
     *
     * @return 当前页所有 书本信息
     */
    @GetMapping(value = "/book", params = "pageSize=5")
    public ResponseDTO listBooks(@RequestParam("page") int currentPage) {

        ResponseDTO response = new ResponseDTO();
        PageInfo page;
        try {
            page = bookService.listBooks(currentPage);
            //如果查询的分页信息为空，直接返回
            if (page == null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
        } catch (BookException e) {
            //异常，返回失败信息
            response.setMsg(MSG_FAILED);
            return response;
        }
        response.setMsg(MSG_OK);
        response.setData(page);
        return response;
    }


    /**
     * 根据 书本id 查询书本信息
     *
     * @param id 书本id
     * @return 查询的书本信息
     */
    @GetMapping("/book/{id}")
    public ResponseDTO getBookById(@PathVariable("id") long id) {

        ResponseDTO response = new ResponseDTO();
        Book book;
        try {
            book = bookService.getBookById(id);
            // 如果没有书本内容，返回失败信息
            if (book == null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
        } catch (BookException e) {
            //如果异常，返回失败信息
            response.setMsg(MSG_FAILED);
            return response;
        }

        response.setMsg(MSG_OK);
        response.setData(book);
        return response;
    }


    /**
     * 有条件的查询 书本信息
     *
     * @param params 条件
     * @return 符合结果的书本信息
     */
    @GetMapping("/book/search")
    public ResponseDTO listBooksConditionally(BookQueryParamDTO params) {

        ResponseDTO response = new ResponseDTO();
        List<Book> books;
        try {
            //有条件的查询书本信息
            books = bookService.listBooksConditionally(params);
        } catch (BookException e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        response.setData(books);
        response.setMsg(MSG_OK);
        return response;
    }
}
