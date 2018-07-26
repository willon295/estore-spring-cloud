package com.briup.estore.service.impl;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.CustomerException;

import com.briup.estore.dao.CustomerDAO;
import com.briup.estore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDao;

    @Override
    public void register(Customer customer) throws CustomerException {
        customerDao.saveCustomer(customer);
    }

    @Override
    public Customer login(String name, String password) throws CustomerException {
        Customer byName = customerDao.findByName(name);
        if (byName != null && password.equals(byName.getPassword())) {
            return byName;
        } else {
            return null;
        }
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException {
        customerDao.updateCustomer(customer);
    }

    @Override
    public Customer findByName(String name) throws CustomerException {
        return customerDao.findByName(name);
    }

    @Override
    public Customer findById(Long id) throws CustomerException {
        return customerDao.findById(id);

    }
}
