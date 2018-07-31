package com.briup.estore.dao;


import com.briup.estore.common.bean.Customer;

/**
 * 客户服务网数据库访问接口，规范客户数据相关操作，主要提供：
 * 1. 添加客户
 * 2. 更新客户信息
 * 3. 通过客户名获取客户信息
 * 4. 通过id查询客户信息
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
public interface CustomerDAO {

    /**
     * 通过客户名获取客户信息
     *
     * @param name 客户名
     * @return 客户信息
     */
    Customer findByName(String name);

    /**
     * 添加客户
     *
     * @param customer 新增的客户信息
     */
    void saveCustomer(Customer customer);

    /**
     * 更新客户信息
     *
     * @param customer 客户信息
     */
    void updateCustomer(Customer customer);

    /**
     * 通过客户id查询客户信息
     *
     * @param id 客户id
     * @return 客户信息
     */
    Customer findById(long id);
}
