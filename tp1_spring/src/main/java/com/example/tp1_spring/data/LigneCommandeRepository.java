package com.example.tp1_spring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends CrudRepository<LigneCommande, Long> {
}
