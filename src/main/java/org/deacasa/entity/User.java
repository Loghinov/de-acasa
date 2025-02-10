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
@Table(name = "users")
public class User  implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private @Id long userId;
    @Column(name = "user_first_name")
    private String userFirstName;
    @Column(name="user_last_name")
    private String userLastName;
    @Column(name = "user_email")
    private String userEmail;
    @ToString.Exclude
    @Column(name = "user_password")
    private transient String userPassword;
    @Column(name = "user_phone_number")
    private String userPhoneNumber;
    @Column(name = "user_status")
    private String userStatus;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "order_id")
    private long orderId;
}
