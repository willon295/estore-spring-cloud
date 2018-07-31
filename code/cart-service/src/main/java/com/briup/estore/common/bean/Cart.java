package com.briup.estore.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 购物车 实体类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
@Data
public class Cart implements Serializable {
    /**
     * id
     */
    private long id;

    /**
     * 数量
     */
    private int num;

    /**
     * 书本信息
     */
    private Book book;
    /**
     * 客户信息
     */
    private Customer customer;
}
