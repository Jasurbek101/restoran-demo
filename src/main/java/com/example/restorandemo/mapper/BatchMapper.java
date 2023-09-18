package com.example.restorandemo.mapper;

import com.example.restorandemo.dto.BatchDTO;
import com.example.restorandemo.entity.BatchEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BatchMapper {
    public BatchEntity convertToEntity(BatchDTO batchDTO){
       return BatchEntity.builder()
               .value(batchDTO.getValue())
               .type(batchDTO.getType())
                .build();
    }

    public BatchDTO convertToDto(BatchEntity batch){
        return BatchDTO.builder()
                .value(batch.getValue())
                .type(batch.getType())
                .build();
    }

}
