package org.deacasa.service.Impl;

import org.deacasa.dto.OrderResponseDto;
import org.deacasa.entity.*;
import org.deacasa.repository.OrderRepo;
import org.deacasa.repository.ProductRepo;
import org.deacasa.repository.UserRepo;
import org.deacasa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductRepo productRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
        this.productRepo = productRepo;
    }


    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        List<OrderResponseDto> responseDto = new ArrayList<>();
        for (Order order : orders) {
            responseDto.add(mapToDto(order));
        }
        return responseDto;
    }

    @Override
    public OrderResponseDto createOrder(CreateOrderRequest request) {
        Product product = productRepo.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        Order order = new Order();
        order.setProduct(product);
        order.setAmount(Long.valueOf(request.getAmount()));
        order.setPrice(product.getProductPrice());
        order.setDttmstart(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.NEW);
        orderRepo.save(order);
        return mapToDto(order);
    }

    @Override
    public OrderResponseDto updateOrder(Long id, CreateOrderRequest request) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found for update"));
        Product product = productRepo.findById(request.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        order.setAmount(Long.valueOf(request.getAmount()));
        order.setProduct(product);
        order.setPrice(product.getProductPrice());;
        orderRepo.save(order);
        return mapToDto(order);
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found by id"));
        return mapToDto(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found for delete"));
        orderRepo.delete(order);

    }

    @Override
    public OrderResponseDto markPaid(Long id, String username) {
        return null;
    }

    private OrderResponseDto mapToDto(Order order) {
        return new OrderResponseDto(
                order.getOrderId(),
                order.getProduct().getProductName(),
                Math.toIntExact(order.getAmount()
                ), null);
    }
}
