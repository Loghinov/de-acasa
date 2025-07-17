package org.deacasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private @Id long roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_description")
    private String roleDescription;

}
