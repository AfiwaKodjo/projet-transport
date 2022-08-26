package com.fastTrans.fastTransapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fastTrans.fastTransapi.model.Ligne;

@Repository
public interface LigneRepository extends JpaRepository<Ligne, Integer>{  
      Optional<Ligne> findByNom(String nom);
    
}
