package com.briup.estore.common.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * 顾客类
 *
 * @author willon
 */
@Data
@NoArgsConstructor
public class Customer implements Serializable {


    /**
     * 客户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮编
     */
    private String zip;

    /**
     * 地址： 由国家、省份、城市、市县/镇区、详细住址组成
     */
    private String address;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 订单
     */
    private Set<Order> orders = new HashSet<>();
}
