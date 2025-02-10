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
@Table(name = "reviews")
public class Review implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private @Id long reviewId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "rating")
    private  double rating;
    @Column(name = "product_id")
    private  long productId;
    @Column(name = "user_id")
    private  long userId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;
}
