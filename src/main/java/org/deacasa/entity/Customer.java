package org.deacasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name="customers")
public class Customer implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id")
    private @Id long customerId;
    @Column(name="user_id")
    private long userId;
    @Column(name="location_id")
    private String locationId;
}
