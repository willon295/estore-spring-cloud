package com.briup.estore.service;

import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.github.pagehelper.PageInfo;

import java.io.File;

/**
 * 订单服务接口
 *
 * @author willon
 */

public interface OrderService {


    /**
     * 添加订单
     *
     * @param order 用户id
     * @throws Exception 异常
     */
    void saveOrder(Order order) throws Exception;


    /**
     * 根据id 删除某个订单
     *
     * @param id 订单id
     * @throws Exception 异常
     */
    void deleteOrderById(long id) throws Exception;


    /**
     * 通过用户id  查询分页的订单信息
     *
     * @param id   用户id
     * @param page 当前页
     * @return 当前页订单信息
     * @throws Exception 异常
     */
    PageInfo<Order> listOrdersByCustomerId(long id, int page) throws Exception;

    /**
     * 通过订单id 查询订单明细
     *
     * @param id   订单id
     * @param page 当前页
     * @return 订单详情
     * @throws Exception 异常
     */
    PageInfo<Line> getLinesByOrderId(long id, int page) throws Exception;


    // 点击取付款 ---> 预创建交易生成： 支付二维码  ---> 开启任务 每个 2 秒  查询一次支付结果，超过30 秒表示交易取消


    /**
     * 根据订单编号， 获取订单内容 ， 创建二维码
     *
     * @param orderId 订单编号
     * @return 二维码图片文件
     * @throws Exception 订单生成失败
     */
    String getTradeQrCode(long orderId) throws Exception;


    /**
     * 修改订单的支付状态， 支付方式
     *
     * @param order 包含支付方式 ， 支付状态的订单信息
     * @throws Exception 异常
     */
    void changeOrderStateAndPayway(Order order) throws Exception;

    /**
     * 获取订单支付页面
     * @param id 订单id
     * @return 页面的代码
     * @throws Exception 异常
     */
    String getTradePage(long id) throws Exception;
}
