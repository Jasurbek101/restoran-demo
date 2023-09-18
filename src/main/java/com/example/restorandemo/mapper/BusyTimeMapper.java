package com.example.restorandemo.mapper;

import com.example.restorandemo.dto.BusyTimeDTO;
import com.example.restorandemo.entity.BusyTimeEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BusyTimeMapper {

    public BusyTimeEntity convertToEntity(BusyTimeDTO busyTimeDTO){
       return BusyTimeEntity.builder()
               .orderTime(busyTimeDTO.getOrderTime())
               .build();
    }

    public BusyTimeDTO convertToDto(BusyTimeEntity busyTimeEntity){
        return BusyTimeDTO.builder()
                .orderTime(busyTimeEntity.getOrderTime())
                .build();
    }

}
