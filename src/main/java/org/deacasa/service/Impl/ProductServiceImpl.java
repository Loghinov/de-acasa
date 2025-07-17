package org.deacasa.service.Impl;

import org.deacasa.dto.CategoryDto;
import org.deacasa.dto.ProductDto;
import org.deacasa.entity.Category;
import org.deacasa.entity.Product;
import org.deacasa.repository.CategoryRepo;
import org.deacasa.repository.ProductRepo;
import org.deacasa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Category categoryFromDto = productDto.getCategory();
        if (categoryFromDto == null || categoryFromDto.getCategoryName() == null) {
            throw new RuntimeException("Category is required");
        }
        Category category = categoryRepo.findByCategoryName(categoryFromDto.getCategoryName())
                .orElseThrow(()->new RuntimeException("Category not found with id: "+categoryFromDto.getCategoryName()));
        return productRepo.save(Product.builder()
                        .productId(productDto.getProductId())
                        .productName(productDto.getProductName())
                        .productQuantity(productDto.getProductQuantity())
                        .productPrice(productDto.getProductPrice())
                        .productAvailable(productDto.isAvailable())
                        .category(category)
                .build());
    }



    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);

    }
}
