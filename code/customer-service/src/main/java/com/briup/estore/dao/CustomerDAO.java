package com.briup.estore.dao;


import com.briup.estore.common.bean.Customer;

public interface CustomerDAO {

    Customer findByName(String name);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer findById(long id);
}
