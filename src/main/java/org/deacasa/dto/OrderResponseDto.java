package org.deacasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private String productName;
    private Integer amount;
    private String userName;
}
