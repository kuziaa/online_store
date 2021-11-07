package com.antonkhmarun.onlinestore.online_store.service;

import com.antonkhmarun.onlinestore.online_store.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllCategories();

    public Category getCategory(int id);

    public void saveCategory(Category category);

    public void deleteCategory(int id);
}
