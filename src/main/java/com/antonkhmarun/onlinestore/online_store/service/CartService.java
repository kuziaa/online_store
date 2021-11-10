package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Product;

public interface CartService {

    Cart getCartByUsername();

    void deleteCartByUsername();

    void addProduct(Product product);
}
