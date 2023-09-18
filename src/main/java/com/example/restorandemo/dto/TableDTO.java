package com.example.restorandemo.dto;

import com.example.restorandemo.entity.BusyTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableDTO {

    private String name;
    private boolean state;
    private List<BusyTimeDTO> orderTimes;
}