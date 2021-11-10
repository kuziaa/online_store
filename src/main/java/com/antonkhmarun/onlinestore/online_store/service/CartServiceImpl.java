package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.dao.CartProductRepository;
import com.antonkhmarun.onlinestore.online_store.dao.CartRepository;
import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Override
    public Cart getCartByUsername() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return cartRepository.findCartByUsername(username);
    }

    @Override
    public void deleteCartByUsername() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        cartRepository.deleteCartByUsername(username);
    }

    @Override
    public void addProduct(Product product) {
    }
}
