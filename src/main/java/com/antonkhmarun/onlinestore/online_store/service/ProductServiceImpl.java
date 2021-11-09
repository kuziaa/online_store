package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.dao.ProductRepository;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProduct(int id) {

        Product product = null;
        Optional<Product> pr = productRepository.findById(id);
        if(pr.isPresent()) {
            product = pr.get();
        }
        return product;

    }

    public Product findProductByName(String name) {

        Product product = productRepository.findProductByName(name);
        return product;
    }

    @Override
    public void saveProduct(Product product) {

        String name = product.getName();
        Product productInDB = findProductByName(name);
        if (productInDB != null) {
            product.setId(productInDB.getId());
        }
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {

        productRepository.deleteById(id);
    }
}
