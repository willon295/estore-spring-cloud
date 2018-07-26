package com.briup.estore.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 书
 *
 * @author willon
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
