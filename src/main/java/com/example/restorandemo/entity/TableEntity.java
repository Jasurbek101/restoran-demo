package com.example.restorandemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity(name = "tables")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean state;

    @ManyToMany
    @JoinTable(name = "table_busy_times")
    private List<BusyTimeEntity> busyTimeEntityList;
}