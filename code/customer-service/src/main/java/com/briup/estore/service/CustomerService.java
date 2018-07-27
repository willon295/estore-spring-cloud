package com.briup.estore.service;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.CustomerException;

public interface CustomerService {

    /**
     * 客户注册
     *
     * @param customer 客户信息
     * @throws CustomerException 异常
     */
    void register(Customer customer) throws CustomerException;

    /**
     * 客户登陆
     *
     * @param name     姓名
     * @param password 密码
     * @return 用户的完整信息
     * @throws CustomerException 异常
     */
    Customer login(String name, String password) throws CustomerException;

    /**
     * 更新客户信息
     *
     * @param customer 新的客户信息
     * @throws CustomerException 异常
     */
    void updateCustomer(Customer customer) throws CustomerException;

    /**
     * 通过名字查询用户信息
     *
     * @param name 用户姓名
     * @return 完整的用户信息
     * @throws CustomerException 异常
     */
    Customer findByName(String name) throws CustomerException;

    /**
     * 通过id 查询到用户信息
     *
     * @param id id
     * @return 完整用户信息
     * @throws CustomerException 异常
     */
    Customer findById(Long id) throws CustomerException;
}
