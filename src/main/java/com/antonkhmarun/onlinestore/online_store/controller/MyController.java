package com.antonkhmarun.onlinestore.online_store.controller;

import com.antonkhmarun.onlinestore.online_store.entity.Category;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import com.antonkhmarun.onlinestore.online_store.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CartProductService cartProductService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!!!";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product) {

        return productService.saveProduct(product);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories;
    }

    @PostMapping("/categories")
    public String addCategory(@RequestBody Category category) {

        return categoryService.saveCategory(category);
    }

    @GetMapping("/categories/{categoryName}")
    public Category getCategoryByName(@PathVariable String categoryName) {
        return categoryService.findCategoryByName(categoryName);
    }

    @GetMapping("/cart")
    public List<Product> getProductsFromCart() {
        return cartProductService.findProductsByCartId();
    }

    @PostMapping("/cart")
    public void addProductInCartByUsername(@RequestBody Product product) {
        cartProductService.addProduct(product);
    }

    @DeleteMapping("/cart")
    public void deleteAllProductsFromCartByUserName() {
        cartProductService.deleteProducts();
    }
}
