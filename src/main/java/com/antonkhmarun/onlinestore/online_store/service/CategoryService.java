package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Category;
import com.antonkhmarun.onlinestore.online_store.entity.Product;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category getCategory(int id);

    public Category findCategoryByName(String name);

    public void saveCategory(Category category);

    public void deleteCategory(int id);
}
