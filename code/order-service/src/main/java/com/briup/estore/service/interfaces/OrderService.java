package com.briup.estore.service.interfaces;

import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.github.pagehelper.PageInfo;

/**
 * 订单服务接口
 * 该接口规范了所有与订单相关业务的处理规范，主要提供：
 * 1. 添加订单，同时增加订单项
 * 2. 通过id删除订单
 * 3. 通过客户id查询客户订单信息
 * 4. 获取订单的支付地址
 * 5. 支付订单后改变订单状态
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
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

    /**
     * 根据订单编号， 获取订单内容 ， 创建二维码
     *
     * @param orderId 订单编号
     * @return 二维码图片文件
     * @throws Exception 二维码生成失败
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
     *
     * @param id 订单id
     * @return 页面的代码
     * @throws Exception 异常
     */
    String getTradePage(long id) throws Exception;
}
