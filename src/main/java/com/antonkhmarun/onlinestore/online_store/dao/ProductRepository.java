package com.antonkhmarun.onlinestore.online_store.dao;

import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
