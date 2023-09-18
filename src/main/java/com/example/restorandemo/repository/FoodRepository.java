package com.example.restorandemo.repository;

import com.example.restorandemo.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity,Long> {
    Optional<FoodEntity> findByName(String name);
}
