package org.deacasa.repository;

import org.deacasa.dto.ProductDto;
import org.deacasa.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT new org.deacasa.dto.ProductDto(p.productId, p.productName, p.productQuantity, p.productPrice, p.productAvailable, p.category) FROM Product p")
    Page<ProductDto> getListOfProduct(Pageable pageable);
    @Query("SELECT new org.deacasa.dto.ProductDto(p.productId, p.productName, p.productQuantity, p.productPrice, p.productAvailable, p.category) FROM Product p")
    Optional<Product> findProductById(Long id);
}
