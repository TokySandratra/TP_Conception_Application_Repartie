package com.example.tp1_spring.data;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Long> {
    List<Commande> findByClientEmail(String clientEmail);
}
