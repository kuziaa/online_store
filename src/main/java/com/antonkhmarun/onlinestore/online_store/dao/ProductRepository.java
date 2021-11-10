package com.antonkhmarun.onlinestore.online_store.dao;

import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findProductByName(String name);

}
