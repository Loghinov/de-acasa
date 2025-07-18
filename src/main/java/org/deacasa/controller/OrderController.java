package org.deacasa.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.deacasa.dto.OrderDto;
import org.deacasa.dto.OrderResponseDto;
import org.deacasa.entity.CreateOrderRequest;
import org.deacasa.entity.Order;
import org.deacasa.repository.OrderRepo;
import org.deacasa.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@Tag(name = "Order", description = "Управление заказами")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get-all")
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(){
        List<OrderResponseDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable  Long id) {
        OrderResponseDto orderResponseDto = orderService.getOrderById(id);
        return ResponseEntity.ok(orderResponseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable Long id, @RequestBody @Valid CreateOrderRequest request){
        OrderResponseDto update = orderService.updateOrder(id, request);
        return  ResponseEntity.ok(update);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody @Valid CreateOrderRequest request){
        OrderResponseDto responseDto = orderService.createOrder(request);
        return  ResponseEntity.ok(responseDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity <Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
