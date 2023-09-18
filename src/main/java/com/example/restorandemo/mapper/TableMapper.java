package com.example.restorandemo.mapper;

import com.example.restorandemo.dto.BusyTimeDTO;
import com.example.restorandemo.dto.TableDTO;
import com.example.restorandemo.entity.BusyTimeEntity;
import com.example.restorandemo.entity.TableEntity;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.List;

@UtilityClass
public class TableMapper {

    public TableEntity convertToEntity(TableDTO tableDTO){
        List<BusyTimeEntity> busyTimeEntities = tableDTO.getOrderTimes().stream().map(BusyTimeMapper::convertToEntity).toList();
        return TableEntity.builder()
                .name(tableDTO.getName())
                .state(tableDTO.isState())
                .busyTimeEntityList(busyTimeEntities)
                .build();
    }

    public TableDTO convertToDto(TableEntity tableEntity){
        List<BusyTimeDTO> busyTimeDTOS = tableEntity.getBusyTimeEntityList().stream().map(BusyTimeMapper::convertToDto).toList();
        return TableDTO.builder()
                .name(tableEntity.getName())
                .state(tableEntity.isState())
                .orderTimes(busyTimeDTOS)
                .build();
    }

}
