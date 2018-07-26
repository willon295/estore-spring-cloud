package com.briup.estore.common.bean;

import com.briup.estore.common.enums.PaywayEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 *
 * @author willon
 */
@Data
public class Order implements Serializable {

    /**
     * 订单id
     */
    private Long id;

    /**
     * 总花费
     */
    private Double cost;

    /**
     * 交易日期
     */
    private Date orderDate;

    /**
     * 订单详情
     */
    private List<Line> lines = new ArrayList<>();

    /**
     * 所属客户
     */
    private Customer customer;

    /**
     * 订单状态，默认是 payed
     */
    private String state = "pending";

    /**
     * 支付方式
     */
    private PaywayEnum payway;
}
