package com.fastTrans.fastTransapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastTrans.fastTransapi.model.Quartier;

@Repository
public interface QuartierRepository extends JpaRepository<Quartier, Integer>{
    Optional<Quartier> findByNom(String nom);
    
}


