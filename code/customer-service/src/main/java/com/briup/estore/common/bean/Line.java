package com.briup.estore.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单项
 *
 * @author willon
 */
@Data
public class Line implements Serializable {

    /**
     * 订单明细 id
     */
    private Long id;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 所属订单
     */
    private Order order;

    /**
     * 书本信息
     */
    private Book book;

}
