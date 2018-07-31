package com.briup.estore.controller;

import com.briup.estore.common.bean.Customer;
import com.briup.estore.common.dto.ResponseDTO;
import com.briup.estore.common.exception.CustomerException;
import com.briup.estore.common.util.Md5Base64Encoder;
import com.briup.estore.service.interfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 客户服务控制器
 *
 * @author willon
 * @version 1.0
 * @since 18-7-30
 * 联系方式： willon295@163.com
 */
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
        //判断注册信息是否合法，不合法返回失败
        if (customer.getName() == null
                || "".equals(customer.getName())
                || customer.getPassword() == null
                || "".equals(customer.getPassword())) {
            response.setMsg(MSG_FAILED);
            return response;
        }

        try {
            //  再次检查用户是否存在
            Customer byName = customerService.findByName(customer.getName());
            //如果存在，直接返回失败
            if (byName != null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
            //正常注册流程
            String encodePassword = Md5Base64Encoder.encode(customer.getPassword());
            customer.setPassword(encodePassword);
            customerService.register(customer);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
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
            String name = customer.getName();
            //将密码进行加密
            String password = Md5Base64Encoder.encode(customer.getPassword());
            loginUser = customerService.login(name, password);
            //未查询到此用户，直接返回失败
            if (loginUser == null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
            response.setMsg(MSG_OK);
            response.setData(loginUser);
        } catch (Exception e) {
            response.setMsg(MSG_FAILED);
            return response;
        }
        return response;
    }

    /**
     * 对其他服务 提供的接口，通过用户id查询用户信息
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
            //不存在此用户，直接返回失败
            if (byId == null) {
                response.setMsg(MSG_FAILED);
                return response;
            }
            response.setMsg(MSG_OK);
            response.setData(byId);
        } catch (CustomerException e) {
            response.setMsg(MSG_FAILED);
            return response;
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
            //将密码进行加密
            String password = Md5Base64Encoder.encode(customer.getPassword());
            customer.setPassword(password);
            //更新成功
            customerService.updateCustomer(customer);
            response.setMsg(MSG_OK);
        } catch (Exception e) {
            //异常返回失败
            response.setMsg(MSG_FAILED);
            return response;
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
            return response;
        }
        return response;

    }

}
