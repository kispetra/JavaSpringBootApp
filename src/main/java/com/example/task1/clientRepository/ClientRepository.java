package com.example.task1.clientRepository;

import com.example.task1.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public class ClientRepository {
    public interface BookRepository extends JpaRepository<Client, Long> {}

}
