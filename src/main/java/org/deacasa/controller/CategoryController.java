package org.deacasa.controller;

import lombok.RequiredArgsConstructor;
import org.deacasa.entity.Category;
import org.deacasa.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // Получение всех категорий
    @GetMapping("/get-all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Получение категории по ID
    @GetMapping("/get/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Создание новой категории
    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // Обновление данных категории
    @PutMapping("/update/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // Удаление категории
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
