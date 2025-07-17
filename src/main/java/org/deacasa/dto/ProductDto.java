package org.deacasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.deacasa.entity.Category;

@Data
@AllArgsConstructor
public class ProductDto {
    private  Long productId;
    private String productName;
    private Long productQuantity;
    private Long productPrice;
    private boolean available;
    private Category category;
}
