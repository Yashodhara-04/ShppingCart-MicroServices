package com.MicroServiceProject.ProductService.repository;

import com.MicroServiceProject.ProductService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
