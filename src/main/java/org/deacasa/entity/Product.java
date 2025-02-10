package org.deacasa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Table(name="products")
public class Product implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private @Id long productId;
    @Column(name="product_price")
    private long productPrice;
    @Column(name="product_available")
    private String productAvailable;
    @Column(name="product_quantity")
    private String productQuantity;
    @Column(name="product_rating")
    private double productRating;
}
