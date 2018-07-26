package com.briup.estore.controller;

import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.common.dto.ResponseDTO;
import com.briup.estore.common.enums.PaywayEnum;
import com.briup.estore.service.OrderService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 订单服务Controller
 *
 * @author willon
 */
@Slf4j
@RestController
public class OrderController {

    private static final String MSG_OK = "OK";
    private static final String MSG_FAILED = "FAILED";


    @Value(value = "${alipay.return-url}")
    public String returnUrl;

    @Autowired
    private OrderService orderService;


    /**
     * 提交订单
     *
     * @param order 新的订单
     * @return 处理结果
     */

    @PostMapping("/order")
    public ResponseDTO saveOrder(@RequestBody Order order) {

        ResponseDTO response = new ResponseDTO();

        try {
            orderService.saveOrder(order);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
        }
        return response;
    }


    /**
     * 通过 订单id 删除订单
     *
     * @param id 订单id
     * @return 处理结果
     */

    @DeleteMapping("/order/{id}")
    public ResponseDTO deleteOrderById(@PathVariable("id") long id) {

        ResponseDTO response = new ResponseDTO();
        try {
            orderService.deleteOrderById(id);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
        }

        return response;

    }


    /**
     * 通过 订单id 获取订单详情
     *
     * @param id 订单id
     * @return 处理结果
     */

    @GetMapping(value = "/order/{id}", params = "pageSize=5")
    public ResponseDTO getOrderById(@PathVariable("id") long id, int page) {

        ResponseDTO response = new ResponseDTO();
        try {
            PageInfo<Line> orderWithLines = orderService.getLinesByOrderId(id, page);
            response.setData(orderWithLines);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
        }

        return response;

    }


    /**
     * 通过 用户id 查询所有订单
     *
     * @param id   用户id
     * @param page 当前页
     * @return 处理结果
     */

    @GetMapping(value = "/order/customer/{id}", params = "pageSize=5")
    public ResponseDTO listOrdersByCustomerId(@PathVariable("id") long id, int page) {
        ResponseDTO response = new ResponseDTO();
        try {
            PageInfo<Order> orderPageInfo = orderService.listOrdersByCustomerId(id, page);
            response.setData(orderPageInfo);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
        }
        return response;
    }


    /**
     * 获取支付页面
     *
     * @param id       订单id
     * @param response 支付页面
     */
    @GetMapping("/order/{id}/payPage")
    public void getPayPage(@PathVariable("id") long id, HttpServletResponse response) {

        String tradeForm;
        try {
            tradeForm = orderService.getTradePage(id);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(tradeForm);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            try {
                response.sendRedirect(returnUrl);
            } catch (IOException e1) {
                log.error("跳转失败");
            }
        }
    }


    /**
     * 更改订单的状态以及 支付方式，支付宝支付完成之后,回调使用
     *
     * @param id 订单id
     */
    @GetMapping(value = "/order/{id}", params = "callback=alipay")
    public void changeOrderStateAndPayway(@PathVariable("id") long id, HttpServletResponse httpServletResponse) {
        Order order = new Order();
        order.setId(id);
        order.setState("payed");
        order.setPayway(PaywayEnum.ALIPAY);
        try {
            orderService.changeOrderStateAndPayway(order);
            httpServletResponse.sendRedirect(returnUrl);
        } catch (Exception e) {
            log.error("回调失败： " + returnUrl + "_" + e.getMessage());
        }


    }
}
