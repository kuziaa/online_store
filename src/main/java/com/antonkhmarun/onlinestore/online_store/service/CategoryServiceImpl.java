package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.dao.CategoryRepository;
import com.antonkhmarun.onlinestore.online_store.entity.Category;
import com.antonkhmarun.onlinestore.online_store.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(int id) {

        Category category = null;
        Optional<Category> cat = categoryRepository.findById(id);
        if (cat.isPresent()) {
            category = cat.get();
        }
        return category;
    }

    @Override
    public Category findCategoryByName(String name) {

        Category category = categoryRepository.findCategoryByName(name);
        return category;
    }

    @Override
    public void saveCategory(Category category) {

        String name = category.getName();
        Category categoryInDB = findCategoryByName(name);
        if (categoryInDB != null) {
            category.setId(categoryInDB.getId());
        } else {
            categoryRepository.save(category);
        }
    }

    @Override
    public void deleteCategory(int id) {

        categoryRepository.deleteById(id);
    }
}
