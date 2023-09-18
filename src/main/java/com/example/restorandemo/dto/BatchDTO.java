package com.example.restorandemo.dto;

import com.example.restorandemo.enums.BatchEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchDTO {
    private BatchEnum type;
    private double value;
}