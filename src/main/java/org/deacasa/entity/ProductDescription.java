package org.deacasa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Table(name="products_Descroptions")
public class ProductDescription implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_description_id")
    private @Id long productDescriptionId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_description")
    private String  productDescription;
    @Column(name = "location_id")
    private  String locationId;
    @Column(name = "photo_url")
    private String photoUrl;
    @Column(name = "created_date_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime createdDateTime;
}
