package com.example.restorandemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity(name = "orders")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "order_tables")
    private List<TableEntity> tableEntities;


    @ManyToMany
    @JoinTable(name = "order_foods_tables")
    private List<FoodEntity> foodEntityList;

    @ManyToOne
    private UserEntity userEntity;

    private Integer totalSumm;

}