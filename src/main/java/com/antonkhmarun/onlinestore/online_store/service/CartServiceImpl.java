package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.dao.CartRepository;
import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(int id) {
        cartRepository.deleteById(id);
    }
}
