package com.example.task1.repository;


import com.example.task1.model.CarService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarServiceRepository extends JpaRepository<CarService,Long> {
}
