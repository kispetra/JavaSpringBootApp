package com.example.task1.repository;

import com.example.task1.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("SELECT c FROM Client c WHERE (c.firstName LIKE concat('%', :firstName, '%') OR c.firstName is null) AND " +
            " (c.lastName LIKE concat('%', :lastName, '%') OR c.lastName is null)  ORDER BY c.lastName ASC")
    Page<Client> findingByNameOrLastNameASC(String firstName, String lastName, Pageable pageable);

}
