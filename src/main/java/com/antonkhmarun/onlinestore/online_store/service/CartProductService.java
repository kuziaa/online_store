package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Product;

import java.util.List;

public interface CartProductService {

    List<Product> findProductsByCartId();

    void addProduct(Product product);

    void deleteProducts();
}
