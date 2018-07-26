package com.briup.estore.service;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.CustomerException;

public interface CustomerService {

    void register(Customer customer) throws CustomerException;

    Customer login(String name, String password) throws CustomerException;

    void updateCustomer(Customer customer) throws CustomerException;

    Customer findByName(String name) throws CustomerException;

    Customer findById(Long id) throws CustomerException;
}
