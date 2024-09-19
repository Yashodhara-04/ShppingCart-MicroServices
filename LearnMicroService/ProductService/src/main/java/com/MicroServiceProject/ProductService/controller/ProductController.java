package com.MicroServiceProject.ProductService.controller;

import com.MicroServiceProject.ProductService.dto.ProductRequest;
import com.MicroServiceProject.ProductService.dto.ProductResponse;
import com.MicroServiceProject.ProductService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.HttpResource;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("create")
    public ResponseEntity<ProductRequest> createProduct(@RequestBody ProductRequest productRequest)
    {
        try
        {
            if(productRequest != null)
            {
                productService.createProduct(productRequest);
                return new ResponseEntity<>(productRequest, HttpStatus.OK);
            }
            else {
                return  new ResponseEntity<>(productRequest, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        catch (Exception ex)
        {
            return  new ResponseEntity<>(productRequest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("get")
    public ResponseEntity<List<ProductResponse>> getProduct()
    {
        try
        {
            List<ProductResponse> productResponses = productService.getAllProduct();
            return new ResponseEntity<>(productResponses, HttpStatus.OK);

        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
