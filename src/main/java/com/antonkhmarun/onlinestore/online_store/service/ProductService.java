package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProduct(int id);

    public void saveProduct(Product product);

    public void deleteProduct(int id);
}
