package com.briup.estore.service.impl;

import com.briup.estore.common.bean.Cart;
import com.briup.estore.dao.CartDAO;
import com.briup.estore.service.CartService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车服务具体实现
 *
 * @author willon
 */
@Slf4j
@Service
public class CartServiceImpl implements CartService {


    @Autowired
    private CartDAO cartDAO;

    @Override
    public void deleteCartById(long id) throws Exception {

        cartDAO.deleteCartById(id);
    }

    @Override
    public void deleteAllCartsByCustomerId(long id) throws Exception {

        cartDAO.deleteAllCartsByCustomerId(id);
    }

    @Override
    public void saveCart(Cart cart) throws Exception {
        //先查询有没有这条购物车信息
        Cart existCart = cartDAO.getCartByCustomerIdAndBookId(cart);
        //不存在，新增
        if (existCart == null) {
            cartDAO.saveCart(cart);
        } else {
            //存在 更新信息
            existCart.setCustomer(cart.getCustomer());
            existCart.setBook(cart.getBook());
            int newCount = existCart.getNum() + 1;
            existCart.setNum(newCount);
            cartDAO.updateCart(existCart);
        }
    }

    @Override
    public void updateCart(Cart cart) throws Exception {
        cartDAO.updateCart(cart);
    }

    @Override
    public Cart getCartById(long id) throws Exception {

        return cartDAO.getCartById(id);
    }

    @Override
    public PageInfo<Cart> listCartsByCustomerId(long id, int page) throws Exception {
        PageHelper.startPage(page, 5);
        List<Cart> carts = cartDAO.listAllCartsByCustomerId(id);
        return new PageInfo<>(carts);
    }

    @Override
    public List<Cart> listAllCartsByCustomerId(long id) throws Exception {
        return cartDAO.listAllCartsByCustomerId(id);
    }


}
