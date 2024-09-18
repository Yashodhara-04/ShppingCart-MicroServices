package com.OrderService.OrderService.service;

import com.OrderService.OrderService.dto.OrderItemsDTO;
import com.OrderService.OrderService.dto.OrderRequest;
import com.OrderService.OrderService.model.Order;
import com.OrderService.OrderService.model.OrderItems;
import com.OrderService.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest)
    {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderItems> orderItemsList =  orderRequest.getOrderItemsDTOList()
                .stream()
                .map(this::maptoOrderItem)
                .toList();

        order.setOrderItemsList(orderItemsList);
        orderRepository.save(order);
    }

    public OrderItems maptoOrderItem(OrderItemsDTO orderItemsDTO)
    {
        return OrderItems.builder()
                .price(orderItemsDTO.getPrice())
                .skuCode(orderItemsDTO.getSkuCode())
                .quantity(orderItemsDTO.getQuantity())
                .build();
    }
}
