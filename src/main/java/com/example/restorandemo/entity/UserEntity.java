package com.example.restorandemo.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String phone;

    private Integer totalSum;
}