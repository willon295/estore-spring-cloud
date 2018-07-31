package com.briup.estore.service.impl;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.exception.CustomerException;

import com.briup.estore.dao.CustomerDAO;
import com.briup.estore.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 客户服务业务层实现类
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
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

        //判断登陆用户名，密码是否匹配，是则返回完整用户信息，否则返回null
        if (byName != null && password.equals(byName.getPassword())) {
            return byName;
        }
        return null;

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
