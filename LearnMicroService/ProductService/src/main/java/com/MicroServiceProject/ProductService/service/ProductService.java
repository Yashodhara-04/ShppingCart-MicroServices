package com.MicroServiceProject.ProductService.service;

import com.MicroServiceProject.ProductService.dto.ProductRequest;
import com.MicroServiceProject.ProductService.dto.ProductResponse;
import com.MicroServiceProject.ProductService.model.Product;
import com.MicroServiceProject.ProductService.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest)
    {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProduct()
    {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapProduct).toList();
    }

    private ProductResponse mapProduct(Product product)
    {
        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        return productResponse;
    }
}
