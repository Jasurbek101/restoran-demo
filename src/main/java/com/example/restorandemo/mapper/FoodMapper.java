package com.example.restorandemo.mapper;

import com.example.restorandemo.dto.FoodDTO;
import com.example.restorandemo.dto.FoodResponseDTO;
import com.example.restorandemo.entity.FoodEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FoodMapper {
    public FoodEntity converToEntity(FoodDTO foodDTO) {
        return FoodEntity.builder()
                .name(foodDTO.getName())
                .batch(BatchMapper.convertToEntity(foodDTO.getBatch()))
                .cost(foodDTO.getCost())
                .build();
    }

    public FoodResponseDTO converToResponseDto(FoodEntity foodEntity) {
        return FoodResponseDTO.builder()
                .id(foodEntity.getId())
                .name(foodEntity.getName())
                .batch(BatchMapper.convertToDto(foodEntity.getBatch()))
                .cost(foodEntity.getCost())
                .build();
    }

}
