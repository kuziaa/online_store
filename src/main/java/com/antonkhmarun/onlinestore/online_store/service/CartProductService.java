package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Product;

import java.util.List;

public interface CartProductService {

    public List<Product> findProductsByCartId();

    public void addProduct(Product product);
}
