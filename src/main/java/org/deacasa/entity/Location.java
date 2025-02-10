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
@Table(name = "locations")

public class Location implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location_id")
    private @Id long locationId;
    @Column(name = "location_city")
    private String locationCity;
    @Column(name = "location_region")
    private String locationRegion;
    @Column(name = "location_address")
    private String locationAddress;

}

