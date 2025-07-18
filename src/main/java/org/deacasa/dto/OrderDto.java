package org.deacasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.deacasa.entity.OrderStatus;
import org.deacasa.entity.Product;
import org.deacasa.entity.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long orderId;
    private Long amount;
    private Long price;
    private Product product;
    private User user;
    private OrderStatus orderStatus;
    private LocalDateTime dttmstart;
    private LocalDateTime dttmend;
}
