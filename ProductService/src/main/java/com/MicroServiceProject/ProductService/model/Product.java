package com.MicroServiceProject.ProductService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
}
