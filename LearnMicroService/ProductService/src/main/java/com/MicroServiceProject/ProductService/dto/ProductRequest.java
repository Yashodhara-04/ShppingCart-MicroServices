package com.MicroServiceProject.ProductService.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private double price;
}
