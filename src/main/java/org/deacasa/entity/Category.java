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
@Table(name="categories")
public class Category implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="category_id")
    private @Id long categoryId;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="product_id")
    private long productId;
}
