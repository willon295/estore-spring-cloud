package com.briup.estore.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单项 实体类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
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
