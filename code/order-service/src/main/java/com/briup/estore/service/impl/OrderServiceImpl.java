package com.briup.estore.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.briup.estore.common.bean.BizContent;
import com.briup.estore.common.bean.Line;
import com.briup.estore.common.bean.Order;
import com.briup.estore.dao.LineDAO;
import com.briup.estore.dao.OrderDAO;
import com.briup.estore.service.CartService;
import com.briup.estore.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 订单服务具体实现类
 *
 * @author willon
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    private static final String STORE_ID = "2018000007201200";
    private static final String TIME_OUT = "120m";

    @Value("${alipay.notify-url}")
    private String notifyUrl;


    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private LineDAO lineDAO;

    @Autowired
    private CartService cartService;


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void saveOrder(Order order) throws Exception {

        order.setOrderDate(new Date());
        //添加订单
        orderDAO.saveOrderAndReturnOrderWithNewId(order);
        order.setState("NO");
        List<Line> lines = order.getLines();
        for (Line line : lines) {
            line.setOrder(order);
            lineDAO.saveLine(line);
        }
        //清空用户 购物车
        Long customerId = order.getCustomer().getId();
        cartService.deleteAllCartsByCustomerId(customerId);

    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void deleteOrderById(long id) throws Exception {
        orderDAO.deleteOrderById(id);
    }


    @Override
    public PageInfo<Order> listOrdersByCustomerId(long id, int page) throws Exception {

        //默认展示5 条数据
        PageHelper.startPage(page, 5);
        List<Order> orders = orderDAO.listOrdersByCustomerId(id);
        return new PageInfo<>(orders);
    }

    @Override
    public PageInfo<Line> getLinesByOrderId(long id, int page) throws Exception {
        //默认展示5 条数据
        PageHelper.startPage(page, 5);
        List<Line> lines = lineDAO.listLinesByOrderId(id);
        return new PageInfo<>(lines);

    }


    /**
     * 改变订单状态
     *
     * @param order 包含支付方式 ， 支付状态的订单信息
     * @throws Exception 异常
     */

    @Override
    public void changeOrderStateAndPayway(Order order) throws Exception {
        orderDAO.changeOrderStateAndPayway(order);
    }

    /**
     * 通过订单id 生成付款页面
     *
     * @param id 订单id
     * @return 订单付款页面
     * @throws Exception 异常
     */
    @Override
    public String getTradePage(long id) throws Exception {

        Order orderById = orderDAO.getOrderById(id);

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        request.setBizContent("{\"out_trade_no\":\"" + id + "\","
                + "\"total_amount\":\"" + orderById.getCost() + "\","
                + "\"subject\":\"用户" + id + "购书订单\","
                + "\"body\":\"" + id + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //此处因为没有 外网通知地址，
        //通过调用返回地址，实现支付后改变订单状态
        request.setReturnUrl(notifyUrl + "/" + id + "?callback=alipay");
        return alipayClient.pageExecute(request).getBody();


    }


    /**
     * 此方法 适用于  手动绘制二维码，手动处理 支付宝异步通知
     *
     * @param id 订单id
     * @return 二维码
     * @throws Exception 异常
     */
    @Deprecated
    @Override
    public String getTradeQrCode(long id) throws Exception {

        Order orderById = orderDAO.getOrderById(id);
        AlipayTradePrecreateModel precreateModel = new AlipayTradePrecreateModel();
        precreateModel.setOutTradeNo(String.valueOf(id));
        precreateModel.setSubject("用户" + id + "购书订单");
        precreateModel.setTimeoutExpress(TIME_OUT);
        precreateModel.setTotalAmount(String.valueOf(orderById.getCost()));
        precreateModel.setStoreId(STORE_ID);

        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();

        log.warn(request.toString());
        log.info("请求的数据： " + precreateModel.toString());
        request.setBizModel(precreateModel);

        request.setNotifyUrl("http://willon.cn:9999/alipay/notify");
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        log.info("返回信息： " + response.getBody());
        log.info("预创建订单成功 , 正在生成二维码....");
        String qrCode = response.getQrCode();
        log.info("获取到的二维码： " + qrCode);

        return qrCode;

    }


}
