package com.OrderService.OrderService.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="orderItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String skuCode;
    private double price;
    private int quantity;

}
