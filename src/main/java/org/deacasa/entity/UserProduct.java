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
@Builder
@EqualsAndHashCode
@Table(name = "users_products")
public class UserProduct implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_product_id")
    private @Id long userProductId;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "product_id")
    private long productId;
}
