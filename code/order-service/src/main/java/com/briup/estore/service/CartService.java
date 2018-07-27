package com.briup.estore.service;

import com.briup.estore.common.dto.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用 购物车Service
 *
 * @author willon
 */

@Service
@FeignClient(value = "CART-SERVICE")
public interface CartService {

    /**
     * 根据用户id 删除所有购物车信息
     *
     * @param id 用户id
     * @throws Exception 异常
     */
    @DeleteMapping("/cart/customer/{id}")
    void deleteAllCartsByCustomerId(@PathVariable("id") long id) throws Exception;


    /**
     * 通过 用户id 查询所有用户购物车信息
     * @param id 用户id
     * @param page 参数
     * @return 购物车列表
     */
    @GetMapping(value = "/cart/customer/{id}")
    ResponseDTO listCartsByCustomerId(@PathVariable("id") long id, @RequestParam("page") int  page);
}
