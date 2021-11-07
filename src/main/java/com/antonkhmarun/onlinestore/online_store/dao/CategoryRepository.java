package com.antonkhmarun.onlinestore.online_store.dao;

import com.antonkhmarun.onlinestore.online_store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
