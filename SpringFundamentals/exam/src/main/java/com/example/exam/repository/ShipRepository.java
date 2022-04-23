package com.example.exam.repository;

import com.example.exam.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {

    @Query("SELECT s.power from Ship s")
    Long getPower();

    @Query("SELECT s.health from Ship s")
    Long getHealth();

    @Query("SELECT s.name from Ship s")
    String getName();
}
