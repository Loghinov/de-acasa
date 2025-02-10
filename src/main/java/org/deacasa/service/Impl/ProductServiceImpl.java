package org.deacasa.service.Impl;

import org.deacasa.entity.Product;
import org.deacasa.repository.ProductRepo;
import org.deacasa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Product not found"));
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product product1=getProductById(id);
        product1.setProductPrice(product.getProductPrice());
        product1.setProductAvailable(product.getProductAvailable());
        product1.setProductQuantity(product.getProductQuantity());
        product1.setProductRating(product.getProductRating());
        return productRepo.save(product1);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);

    }
}
