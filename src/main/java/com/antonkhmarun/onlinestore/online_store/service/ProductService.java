package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProduct(int id);

    Product findProductByName(String name);

    String saveProduct(Product product);

    void deleteProduct(int id);
}
