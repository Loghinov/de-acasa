package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.deacasa.dto.CategoryDto;
import org.deacasa.entity.Category;
import org.deacasa.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@Tag(name= "Category Api", description = "Управление категориями товаров")
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
    public Category saveCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
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
