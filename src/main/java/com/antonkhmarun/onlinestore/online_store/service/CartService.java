package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Product;

public interface CartService {

    public Cart getCartByUsername();

    public void deleteCartByUsername();

    public void addProduct(Product product);
}
