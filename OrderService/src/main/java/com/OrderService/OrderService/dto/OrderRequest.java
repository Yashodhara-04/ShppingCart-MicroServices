package com.OrderService.OrderService.dto;


import com.OrderService.OrderService.model.OrderItems;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderItemsDTO> orderItemsDTOList;
}
