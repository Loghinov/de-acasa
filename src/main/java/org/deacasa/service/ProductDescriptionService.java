package org.deacasa.service;


import org.deacasa.entity.ProductDescription;
import java.util.List;



public interface ProductDescriptionService {
    List<ProductDescription> getAllProductDescriptions();

    ProductDescription getProductDescriptionById(Long id);

    ProductDescription saveProductDescription(ProductDescription productDescription);

    ProductDescription updateProductDescription(Long id, ProductDescription productDescription);

    void deleteProductDescription(Long id);

}
