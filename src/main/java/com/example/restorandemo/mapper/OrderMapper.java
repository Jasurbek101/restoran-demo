package com.example.restorandemo.mapper;

import com.example.restorandemo.dto.OrderDTO;
import com.example.restorandemo.entity.FoodEntity;
import com.example.restorandemo.entity.OrderEntity;
import com.example.restorandemo.entity.TableEntity;
import com.example.restorandemo.entity.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class OrderMapper {

    public OrderEntity convertToEntity(OrderDTO orderDTO) {

        List<FoodEntity> foodEntityList = new ArrayList<>();
        List<TableEntity> tableEntityList = new ArrayList<>();

        if (orderDTO.getFoodList() != null)
            foodEntityList = orderDTO.getFoodList().stream().map(FoodMapper::converToEntity).toList();
        if (orderDTO.getTableList() != null)
            tableEntityList = orderDTO.getTableList().stream().map(TableMapper::convertToEntity).toList();
        UserEntity userEntity = UserMapper.converDtoToEntity(orderDTO.getUser());
        return OrderEntity.builder()
                .foodEntityList(foodEntityList)
                .tableEntities(tableEntityList)
                .userEntity(userEntity)
                .totalSumm(orderDTO.getTotalSumm())
                .build();

    }

}
