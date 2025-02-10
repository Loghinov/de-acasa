package org.deacasa.service.Impl;

import org.deacasa.entity.Category;
import org.deacasa.repository.CategoryRepo;
import org.deacasa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo){this.categoryRepo=categoryRepo;}

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Category not found"));
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category category1=getCategoryById(id);
        category1.setCategoryName(category.getCategoryName());
        category1.setProductId(category.getProductId());
        return categoryRepo.save(category1);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepo.deleteById(id);

    }
}
