package com.antonkhmarun.onlinestore.online_store.dao;

import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findCartByUsername(String username);

    void deleteCartByUsername(String username);

//    @Modifying
//    @Query(value = "insert into cart_product (cart_id, product_id) values (:cart_id, :product_id)", nativeQuery = true)
//    void addProduct(@Param("cart_id") int cart_id, @Param("product_id") int product_id);
}
