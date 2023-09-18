package com.example.restorandemo.mapper;

import com.example.restorandemo.dto.UserDTO;
import com.example.restorandemo.entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public UserEntity converDtoToEntity(UserDTO userDTO) {
        return UserEntity.builder()
                .name(userDTO.getName())
                .phone(userDTO.getPhone())
                .totalSum(userDTO.getTotalSum())
                .build();
    }

    public UserDTO converEntityToDto(UserEntity user) {
        return UserDTO.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .totalSum(user.getTotalSum())
                .build();
    }

}
