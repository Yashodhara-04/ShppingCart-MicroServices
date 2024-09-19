package com.OrderService.OrderService.controller;

import com.OrderService.OrderService.dto.OrderRequest;
import com.OrderService.OrderService.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderRequest> placeOrder(@RequestBody OrderRequest orderRequest)
    {
        try
        {
            orderService.placeOrder(orderRequest);
            return new ResponseEntity<>(orderRequest, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
