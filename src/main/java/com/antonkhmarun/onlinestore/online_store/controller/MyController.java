package com.antonkhmarun.onlinestore.online_store.controller;

import com.antonkhmarun.onlinestore.online_store.entity.Cart;
import com.antonkhmarun.onlinestore.online_store.entity.Category;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import com.antonkhmarun.onlinestore.online_store.service.CartService;
import com.antonkhmarun.onlinestore.online_store.service.CartServiceImpl;
import com.antonkhmarun.onlinestore.online_store.service.CategoryService;
import com.antonkhmarun.onlinestore.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onlineStore")
public class MyController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CartService cartService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
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
    public List<Cart> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return carts;
    }
}
