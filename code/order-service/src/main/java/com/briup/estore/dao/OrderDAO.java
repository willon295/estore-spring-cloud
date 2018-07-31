package com.briup.estore.dao;

import com.briup.estore.common.bean.Order;

import java.util.List;

/**
 * 订单 DAO
 *
 * @author willon
 */
public interface OrderDAO {

    /**
     * 保存订单
     *
     * @param order 订单
     */
    void saveOrder(Order order) throws Exception;

    /**
     * 通过 id 获取订单信息
     *
     * @param id 订单id
     * @return 订单信息
     */
    Order getOrderById(Long id) throws Exception;

    /**
     * 删除订单
     *
     * @param id 订单
     * @throws Exception 异常
     */
    void deleteOrderById(long id) throws Exception;

    /**
     * 添加订单， 返回带有新 id 的订单
     *
     * @param order 新订单的信息
     * @throws Exception 异常
     */
    void saveOrderAndReturnOrderWithNewId(Order order) throws Exception;

    /**
     * 通过 用户id 获取所有订单
     *
     * @param customerid 用户id
     * @return 用户所有订单
     * @throws Exception 异常
     */
    List<Order> listOrdersByCustomerId(long customerid) throws Exception;


    /**
     * 支付订单
     *
     * @param order 支付后的订单信息
     * @throws Exception 异常
     */
    void changeOrderStateAndPayway(Order order) throws Exception;
}
