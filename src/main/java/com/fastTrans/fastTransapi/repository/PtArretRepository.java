package com.fastTrans.fastTransapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastTrans.fastTransapi.model.PtArret;

@Repository
public interface PtArretRepository extends JpaRepository<PtArret, Integer> { 
    Optional<PtArret> findByNom(String nom);
    
}
