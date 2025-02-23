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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private @Id long userId;
    @Column(name = "user_first_name")
    private String userFirstName;
    @Column(name="user_last_name")
    private String userLastName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "user_password", nullable = false)
    private  String userPassword;
    @Column(name = "user_phone_number")
    private String userPhoneNumber;
    @Column(name = "user_status")
    private String userStatus;
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;
    @OneToOne(fetch = FetchType.EAGER)  // Связь с одной ролью
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "user_name")
    private String userName;
}
