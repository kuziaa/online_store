package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.dao.CartProductRepository;
import com.antonkhmarun.onlinestore.online_store.dao.CartRepository;
import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Override
    public Cart getCartByUsername() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return cartRepository.findCartByUsername(username);
    }

    @Override
    public void deleteCartByUsername() {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        cartRepository.deleteCartByUsername(username);
    }

    @Override
    public void addProduct(Product product) {
<<<<<<< HEAD

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Cart cart = cartRepository.findCartByUsername(username);
//        int cart_id = cart.getId();
//        int product_id = product.getId();
//        cartRepository.addProduct(cart_id, product_id);
        cart.getProducts().add(product);
        cartRepository.save(cart);
//        cartRepository.addProduct(product);
//        cart.addProduct(product);
//        List<Product> products = cart.getProducts();
//        System.out.println(products);
//        products.add(product);
//        System.out.println(products);
=======
>>>>>>> e7ebb95a6a023f41e6b424324e72d99a9705b628
    }
}
