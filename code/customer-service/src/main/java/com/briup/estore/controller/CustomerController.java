package com.briup.estore.controller;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.dto.ResponseDTO;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class CustomerController {

    private static final String MSG_FAILED = "FAILED";
    private static final String MSG_OK = "OK";

    @Autowired
    private CustomerService customerService;


    /**
     * 用户注册
     *
     * @param customer 用户信息
     * @return 响应信息
     */
    @PostMapping("/customer")
    public ResponseDTO register(@RequestBody Customer customer) {
        ResponseDTO response = new ResponseDTO();

        //注册之前判断用户信息是否合法
        if (customer.getName() == null
                || "".equals(customer.getName())
                || customer.getPassword() == null
                || "".equals(customer.getPassword())) {
            response.setMsg(MSG_FAILED);
            return response;
        }

        try {
            //注册之前， 再次检查用户是否存在
            Customer byName = customerService.findByName(customer.getName());
            //如果存在，直接返回失败
            if (byName != null) {
                response.setMsg(MSG_FAILED);
                return response;
            }

            //正常注册流程
            customerService.register(customer);
            response.setMsg(MSG_OK);
        } catch (CustomerException e) {
            response.setMsg(MSG_FAILED);
        }
        return response;
    }


    /**
     * 用户登录
     *
     * @param customer 用户信息
     * @return 登录处理信息
     */
    @PostMapping("/customer/login")
    public ResponseDTO login(@RequestBody Customer customer) {
        ResponseDTO response = new ResponseDTO();
        Customer loginUser;
        try {
            loginUser = customerService.login(customer.getName(), customer.getPassword());
            if (loginUser == null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
            response.setMsg(MSG_OK);
            response.setData(loginUser);
        } catch (CustomerException e) {
            response.setMsg(MSG_FAILED);
        }
        return response;
    }

    /**
     * 通过用户id查询用户信息
     *
     * @param id 用户id
     * @return 响应信息
     */

    @GetMapping("/customer/{id}")
    public ResponseDTO findById(@PathVariable("id") long id) {
        ResponseDTO response = new ResponseDTO();
        Customer byId;
        try {
            byId = customerService.findById(id);
            if (byId == null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
            response.setMsg(MSG_OK);
            response.setData(byId);
        } catch (CustomerException e) {
            response.setMsg(MSG_FAILED);
        }

        return response;
    }


    /**
     * 更新用户信息
     *
     * @param customer 新的用户信息
     * @return 处理消息
     */
    @PutMapping("/customer")
    public ResponseDTO updateCustomer(@RequestBody Customer customer) {
        ResponseDTO response = new ResponseDTO();
        try {
            customerService.updateCustomer(customer);
            response.setMsg(MSG_OK);
        } catch (CustomerException e) {
            response.setMsg(MSG_FAILED);
        }
        return response;

    }


    /**
     * 检查用户名是否可用
     *
     * @param name 用户名
     * @return 处理信息
     */
    @GetMapping("/customer/isValid/{name}")
    public ResponseDTO isRegNameValid(@PathVariable("name") String name) {
        ResponseDTO response = new ResponseDTO();

        Customer byname;
        try {
            byname = customerService.findByName(name);
            //如果没有该用户名， 说明可以注册
            if (byname == null) {
                response.setMsg(MSG_OK);
                return response;
            }
            response.setMsg(MSG_FAILED);
        } catch (CustomerException e) {
            response.setMsg(MSG_FAILED);
        }

        return response;

    }

}
