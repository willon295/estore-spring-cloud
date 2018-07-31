package com.briup.estore.controller;

import com.briup.estore.common.bean.Cart;
import com.briup.estore.common.dto.ResponseDTO;
import com.briup.estore.service.interfaces.CartService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 购物车控制器
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Slf4j
@RestController

public class CartController {

    private static final String MSG_FAILED = "FAILED";
    private static final String MSG_OK = "OK";

    @Autowired
    private CartService cartService;

    /**
     * 添加新的购物车项
     *
     * @param cart 购物车项
     * @return 处理结果
     */
    @PostMapping("/cart")
    public ResponseDTO saveCart(@RequestBody Cart cart) {

        ResponseDTO response = new ResponseDTO();
        try {
            cartService.saveCart(cart);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        return response;
    }

    /**
     * 通过 购物车id 删除购物车信息
     *
     * @param id 购物车id
     * @return 处理结果
     */
    @DeleteMapping("/cart/{id}")
    public ResponseDTO deleteCartById(@PathVariable("id") long id) {

        ResponseDTO response = new ResponseDTO();
        try {
            cartService.deleteCartById(id);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        return response;
    }


    /**
     * 更新购物车信息
     *
     * @param cart 新的购物车信息
     * @return 处理结果
     */
    @PutMapping("/cart")
    public ResponseDTO updateCart(@RequestBody Cart cart) {

        ResponseDTO response = new ResponseDTO();
        try {
            cartService.updateCart(cart);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        return response;
    }


    /**
     * 通过 用户 id  清空购物车
     *
     * @param id 用户id
     * @return 处理结果
     */
    @DeleteMapping("/cart/customer/{id}")
    public ResponseDTO cleanCartByCustomerId(@PathVariable("id") long id) {

        ResponseDTO response = new ResponseDTO();
        try {
            cartService.deleteAllCartsByCustomerId(id);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        return response;
    }

    /**
     * 通过 用户id 查询所有购物车信息
     *
     * @param id   用户id
     * @param page 分页的查询结果
     * @return 处理结果
     */
    @GetMapping(value = "/cart/customer/{id}", params = "pageSize=5")
    public ResponseDTO listCartsByCustomerId(@PathVariable("id") long id, int page) {

        ResponseDTO response = new ResponseDTO();

        try {
            PageInfo<Cart> cartPageInfo = cartService.listCartsByCustomerId(id, page);
            response.setData(cartPageInfo);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
        }
        return response;
    }

    /**
     * 通过用户 id，  查询 非分页 的所有购物车信息，
     *
     * @param id 客户id
     * @return 所有购物车信息
     */
    @GetMapping(value = "/cart/customer/{id}", params = "page=0")
    public ResponseDTO listCartsByCustomerId(@PathVariable("id") long id) {

        ResponseDTO response = new ResponseDTO();
        try {
            List<Cart> carts = cartService.listAllCartsByCustomerId(id);
            response.setData(carts);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        return response;
    }

}
