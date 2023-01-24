package com.example.task1.repository;

import com.example.task1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client,Long> {

}
