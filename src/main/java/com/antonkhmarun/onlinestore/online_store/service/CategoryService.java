package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategory(int id);

    Category findCategoryByName(String name);

    String saveCategory(Category category);

    void deleteCategory(int id);
}
