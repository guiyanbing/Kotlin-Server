package com.module.user.service;

import com.module.user.model.Category;

import java.util.List;

public interface CategoryService {
    int addCategory(Category paramCategory);

    List<Category> getCategoryList(Integer paramInteger);
}
