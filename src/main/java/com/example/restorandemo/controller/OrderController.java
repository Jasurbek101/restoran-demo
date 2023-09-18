package com.example.restorandemo.controller;

import com.example.restorandemo.dto.ApiResponse;
import com.example.restorandemo.dto.OrderDTO;
import com.example.restorandemo.entity.OrderEntity;
import com.example.restorandemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ApiResponse<OrderEntity> createOrder(@RequestBody OrderDTO orderDTO){
        OrderEntity orderEntity = orderService.creteOrder(orderDTO);
        if (orderEntity == null)
            return ApiResponse.<OrderEntity>builder()
                    .message( " Opder does not create ")
                    .status(500)
                    .success(false)
                    .build();
        else
            return ApiResponse.<OrderEntity>builder()
                    .message( " Opder succesfully created ")
                    .status(200)
                    .success(true)
                    .data(orderEntity)
                    .build();
    }

    @GetMapping
    public ApiResponse<List<OrderEntity>> getOrderList(){
        List<OrderEntity> orderEntityList = orderService.getAllOrders();
        if (orderEntityList == null)
            return ApiResponse.<List<OrderEntity>>builder()
                    .message( " Order list is NULL ")
                    .status(404)
                    .success(false)
                    .build();
        else
            return ApiResponse.<List<OrderEntity>>builder()
                    .message( " Order list !!! ")
                    .status(200)
                    .success(true)
                    .data(orderEntityList)
                    .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<OrderEntity> getOrderById(@PathVariable Long id){
        OrderEntity orderEntity = orderService.getOrderById(id);
        if (orderEntity == null)
            return ApiResponse.<OrderEntity>builder()
                    .message( " Order not Found ")
                    .status(500)
                    .success(false)
                    .build();
        else
            return ApiResponse.<OrderEntity>builder()
                    .message( " Order !!! ")
                    .status(200)
                    .success(true)
                    .data(orderEntity)
                    .build();
    }



}
