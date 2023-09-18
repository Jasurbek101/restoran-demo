package com.example.restorandemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private Long id;
    private String name;
    private BatchDTO batch;
    private double cost;

}