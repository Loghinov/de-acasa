package org.deacasa.service;


import org.deacasa.dto.ProductDto;
import org.deacasa.entity.Product;
import org.springframework.data.domain.PageRequest;

import java.util.List;



public interface ProductService {
    List<Product> getAllProducts();

    Product createProduct(ProductDto productDto);

    Product getProductById(Long id);

    Product updateProduct(Product product);

    void deleteProduct(Long id);

}
