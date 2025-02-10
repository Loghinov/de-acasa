package org.deacasa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Table(name="notifications")
public class Notification implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="notification_id")
    private @Id long notificationId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name="notification_date_time")
    private LocalDateTime notificationDateTime;
    @Column(name="user_id")
    private long userId;
    @Column(name="message")
    private String message;
    @Column(name="read_status")
    private ReadStatus readStatus;
}
