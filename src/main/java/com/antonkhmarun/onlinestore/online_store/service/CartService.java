package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Category;

import java.util.List;

public interface CartService {

    public List<Cart> getAllCarts();

    public void saveCart(Cart cart);

    public void deleteCart(int id);
}
