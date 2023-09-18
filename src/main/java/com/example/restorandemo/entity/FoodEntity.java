package com.example.restorandemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity(name = "foods")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private BatchEntity batch;
    private double cost;

}