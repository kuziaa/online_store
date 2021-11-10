package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.dao.CartProductRepository;
import com.antonkhmarun.onlinestore.online_store.dao.CartRepository;
import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.CartProduct;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartProductServiceImpl implements CartProductService {

    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Product> findProductsByCartId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Cart cart = cartRepository.findCartByUsername(username);

        List<CartProduct> cartProducts = cartProductRepository.findProductsByCartId(cart.getId());
        List<Product> products = cartProducts.stream().map(CartProduct::getProduct).collect(Collectors.toList());
        return products;
    }

    @Override
    public void addProduct(Product product) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Cart cart = cartRepository.findCartByUsername(username);


        CartProduct cartProduct = new CartProduct();
        cartProduct.setCart(cart);
        cartProduct.setProduct(product);

        cartProductRepository.save(cartProduct);
    }

    @Override
    @Transactional
    public void deleteProducts() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Cart cart = cartRepository.findCartByUsername(username);

        cartProductRepository.deleteAllByCartId(cart.getId());
    }
}
