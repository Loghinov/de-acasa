package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.deacasa.entity.ProductDescription;
import org.deacasa.service.ProductDescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-descriptions")
@RequiredArgsConstructor
@Tag(name="ProductDescription", description = "Управление Продукт Информацией")
public class ProductDescriptionController {

    private final ProductDescriptionService productDescriptionService;

    // Получение всех описаний товаров
    @GetMapping("/get-all")
    public List<ProductDescription> getAllProductDescriptions() {
        return productDescriptionService.getAllProductDescriptions();
    }

    // Получение описания товара по ID
    @GetMapping("/get/{id}")
    public ProductDescription getProductDescriptionById(@PathVariable Long id) {
        return productDescriptionService.getProductDescriptionById(id);
    }

    // Создание нового описания товара
    @PostMapping("/save")
    public ProductDescription saveProductDescription(@RequestBody ProductDescription productDescription) {
        return productDescriptionService.saveProductDescription(productDescription);
    }

    // Обновление существующего описания товара
    @PutMapping("/update/{id}")
    public ProductDescription updateProductDescription(@PathVariable Long id, @RequestBody ProductDescription productDescription) {
        return productDescriptionService.updateProductDescription(id, productDescription);
    }

    // Удаление описания товара
    @DeleteMapping("/delete/{id}")
    public void deleteProductDescription(@PathVariable Long id) {
        productDescriptionService.deleteProductDescription(id);
    }
}
