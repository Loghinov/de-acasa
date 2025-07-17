package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.deacasa.dto.ProductDto;
import org.deacasa.entity.Product;
import org.deacasa.repository.ProductRepo;
import org.deacasa.service.Impl.ProductServiceImpl;
import org.deacasa.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name="Product", description = "Управление Продуктом")
public class ProductController {

    private final ProductService productService;
    private final ProductRepo productRepo;

    // Получение всех продуктов
    @GetMapping("/get-all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    // Получение продукта по ID
    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }


    // Обновление продукта
    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
    }

    // Удаление продукта
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return HttpStatus.OK;
    }


    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.OK);
    }

    @GetMapping("/get-product-list")
    PagedModel<ProductDto> getProductList(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto> productDto = productRepo.getListOfProduct(pageable);
       return new PagedModel<>(productDto);
    }
}
