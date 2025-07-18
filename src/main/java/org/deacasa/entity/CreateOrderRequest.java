package org.deacasa.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class CreateOrderRequest {
    @NotNull
    private Long productId;
    @NotNull
    @Min(1)
    private Integer amount;
}
