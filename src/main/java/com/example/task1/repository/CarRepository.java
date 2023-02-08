package com.example.task1.repository;

import com.example.task1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car,Long> {
}

