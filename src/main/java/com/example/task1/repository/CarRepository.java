package com.example.task1.repository;

import com.example.task1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Client,Long> {
}

