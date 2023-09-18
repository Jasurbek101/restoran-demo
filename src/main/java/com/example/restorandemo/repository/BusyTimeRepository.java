package com.example.restorandemo.repository;

import com.example.restorandemo.entity.BusyTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusyTimeRepository extends JpaRepository<BusyTimeEntity,Long> {
}
