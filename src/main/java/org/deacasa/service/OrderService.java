package org.deacasa.service;

import org.deacasa.dto.OrderResponseDto;
import org.deacasa.entity.CreateOrderRequest;

import java.util.List;


public interface OrderService {
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto createOrder(CreateOrderRequest request);
    OrderResponseDto updateOrder(Long id, CreateOrderRequest request);
    OrderResponseDto getOrderById(Long id);
    void deleteOrder(Long id);
    OrderResponseDto markPaid(Long id, String username);
}
