package com.example.restorandemo.service;

import com.example.restorandemo.dto.OrderDTO;
import com.example.restorandemo.dto.UserDTO;
import com.example.restorandemo.entity.OrderEntity;
import com.example.restorandemo.entity.UserEntity;
import com.example.restorandemo.mapper.OrderMapper;
import com.example.restorandemo.mapper.UserMapper;
import com.example.restorandemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;

    public OrderEntity creteOrder(OrderDTO orderDTO){
        OrderEntity orderEntity = OrderMapper.convertToEntity(orderDTO);
        UserDTO userByPhone = userService.createUser(orderDTO.getUser());
        UserEntity user = UserMapper.converDtoToEntity(userByPhone);
        orderEntity.setUserEntity(user);
        return orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    public OrderEntity getOrderById(Long id){
        Optional<OrderEntity> orderEntity = orderRepository.findById(id);
        return orderEntity.orElse(null);
    }

}