package org.deacasa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_price")
    private long productPrice;
    @Column(name="product_available")
    private Boolean productAvailable;
    @Column(name="product_quantity")
    private Long productQuantity;
    @Column(name="product_rating")
    private double productRating;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
