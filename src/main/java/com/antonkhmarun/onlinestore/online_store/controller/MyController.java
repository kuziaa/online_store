package com.antonkhmarun.onlinestore.online_store.controller;

import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Category;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import com.antonkhmarun.onlinestore.online_store.service.CartService;
import com.antonkhmarun.onlinestore.online_store.service.CartServiceImpl;
import com.antonkhmarun.onlinestore.online_store.service.CategoryService;
import com.antonkhmarun.onlinestore.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/onlineStore")
@RestController
public class MyController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CartService cartService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!!!";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("/products/id/{id}")
    public Product getProducts(@PathVariable int id) {
        Product product = productService.getProduct(id);
        return product;
    }

    @GetMapping("/products/name/{name}")
    public Product getProductByName(@PathVariable String name) {
        Product product = productService.findProductByName(name);
        return product;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Object role = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println(role.toString());
        System.out.println("username: " + username);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        System.out.println();

        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories;
    }

    @PostMapping("/categories")
    public Category category(@RequestBody Category category) {
        categoryService.saveCategory(category);
        return category;
    }

    @GetMapping("/cart")
    public Cart getCartByUsername() {
        Cart cart = cartService.getCartByUsername();
        return cart;
    }

    @PostMapping("/cart")
    public void addProductInCartByUsername(@RequestBody Product product) {
        System.out.println("Cart post");
        System.out.println("Product: " + product);
        cartService.addProduct(product);
    }

//    @DeleteMapping("/cart")
//    public void deleteCartByUsername() {
//
//        cartService.deleteCartByUsername();
//    }
}
