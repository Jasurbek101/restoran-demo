package com.example.restorandemo.entity;

import com.example.restorandemo.enums.BatchEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "batchs")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    private BatchEnum type;

    private double value;
}