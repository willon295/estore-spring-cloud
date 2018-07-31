package com.briup.estore.service.interfaces;

import com.briup.estore.common.bean.Cart;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 购物车服务接口
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
public interface CartService {

    /**
     * 通过 id 删除购物车条目信息
     *
     * @param id 条目id
     * @throws Exception 异常
     */
    void deleteCartById(long id) throws Exception;


    /**
     * 通过
     *
     * @param id 根据用户id 删除所有购物车信息
     * @throws Exception 异常
     */
    void deleteAllCartsByCustomerId(long id) throws Exception;

    /**
     * 添加新的购物车
     *
     * @param cart 购物车数据
     * @throws Exception 异常
     */
    void saveCart(Cart cart) throws Exception;

    /**
     * 更新购物车信息
     *
     * @param cart 购物车
     * @throws Exception 异常
     */
    void updateCart(Cart cart) throws Exception;

    /**
     * 通过购物车id 获取其信息
     *
     * @param id 购物车id
     * @return Cart 购物车
     * @throws Exception 异常
     */
    Cart getCartById(long id) throws Exception;

    /**
     * 通过 用户id  分页查询 所有的 购物车信息， 默认每页展示 5 条数据
     *
     * @param id   用户id
     * @param page 当前页数
     * @return 所有购物车信息
     * @throws Exception 异常
     */
    PageInfo<Cart> listCartsByCustomerId(long id, int page) throws Exception;

    /**
     * 根据用户 id 查询出所有购物车信息
     *
     * @param id 用户id
     * @return 购物车信息
     * @throws Exception 异常
     */
    List<Cart> listAllCartsByCustomerId(long id) throws Exception;
}
