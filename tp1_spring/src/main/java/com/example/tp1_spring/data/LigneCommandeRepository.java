package com.example.tp1_spring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends CrudRepository<LigneCommande, Long> {
    List<LigneCommande> findByCommandeId(Long commandeId);
}
