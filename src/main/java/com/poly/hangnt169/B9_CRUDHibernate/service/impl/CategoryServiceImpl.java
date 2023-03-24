package com.poly.hangnt169.B9_CRUDHibernate.service.impl;

import com.poly.hangnt169.B9_CRUDHibernate.entity.Category;
import com.poly.hangnt169.B9_CRUDHibernate.repository.CategoryRepository;
import com.poly.hangnt169.B9_CRUDHibernate.service.CategoryService;

import java.util.List;

/**
 * @author hangnt169
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
}
