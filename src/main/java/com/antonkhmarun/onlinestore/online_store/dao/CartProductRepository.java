package com.antonkhmarun.onlinestore.online_store.dao;

import com.antonkhmarun.onlinestore.online_store.entity.CartProduct;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

    public List<CartProduct> findProductsByCartId(int id);
}
