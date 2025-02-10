package org.deacasa.service.Impl;

import org.deacasa.entity.ProductDescription;
import org.deacasa.repository.ProductDescriptionRepo;
import org.deacasa.service.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {
    private final ProductDescriptionRepo productDescriptionRepo;
    @Autowired
    public ProductDescriptionServiceImpl(ProductDescriptionRepo productDescriptionRepo){this.productDescriptionRepo=productDescriptionRepo;}

    @Override
    public List<ProductDescription> getAllProductDescriptions() {
        return productDescriptionRepo.findAll();
    }

    @Override
    public ProductDescription getProductDescriptionById(Long id) {
        return productDescriptionRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("Product Description not found"));
    }

    @Override
    public ProductDescription saveProductDescription(ProductDescription productDescription) {
        return productDescriptionRepo.save(productDescription);
    }

    @Override
    public ProductDescription updateProductDescription(Long id, ProductDescription productDescription) {
        ProductDescription productDescription1=getProductDescriptionById(id);
        productDescription1.setProductName(productDescription.getProductName());
        productDescription1.setProductDescription(productDescription.getProductDescription());
        productDescription1.setLocationId(productDescription.getLocationId());
        productDescription1.setPhotoUrl(productDescription.getPhotoUrl());
        productDescription1.setCreatedDateTime(productDescription.getCreatedDateTime());
        return productDescriptionRepo.save(productDescription1);
    }

    @Override
    public void deleteProductDescription(Long id) {
        productDescriptionRepo.deleteById(id);

    }
}
