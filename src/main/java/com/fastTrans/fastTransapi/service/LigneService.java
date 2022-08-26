package com.fastTrans.fastTransapi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastTrans.fastTransapi.exception.LigneBadRequestException;
import com.fastTrans.fastTransapi.exception.LigneConflictException;
import com.fastTrans.fastTransapi.exception.LigneNotFoundException;
import com.fastTrans.fastTransapi.model.Ligne;
import com.fastTrans.fastTransapi.repository.LigneRepository;

@Service
public class LigneService {
    @Autowired
    LigneRepository ligneRepository;
    public Collection<Ligne> getAllLigne(){
        return ligneRepository.findAll();   
    }

    public String addLigne(Ligne l){
        Ligne existingLigne = ligneRepository.findById(l.getId()).orElse(null);
        if (existingLigne == null){
            ligneRepository.save(l);
            return "La ligne a été ajoutée avec succès";
        }else{
            throw new LigneConflictException("La ligne existe déjà");
        }
    }

    public Ligne get(int id) {
        return ligneRepository.findById(id).orElseThrow(
            ()
                -> new LigneNotFoundException(
                    "{Une ligne avec l'id " + id+ " n'existe pas}"));
    }
    
    public String updateLigne(Ligne ligne) {
        Ligne existingLigne = ligneRepository.findById(ligne.getId()).orElse(null);
        if (existingLigne == null){
            throw new LigneNotFoundException("{Cette ligne n'existe pas}");
        }else{
            existingLigne.setNom(ligne.getNom());
            existingLigne.setDepart(ligne.getDepart());
            existingLigne.setTerminus(ligne.getTerminus());
            ligneRepository.save(existingLigne);
            return "{Votre ligne a été mise à jour}";
        }
    }
    
    public String deleteLigneUsingId(int id) {
        if (!ligneRepository.existsById(id)){
            throw new LigneBadRequestException("{L'id "+id+" n'existe pas. Revoyez votre saisie.}");
        }
        ligneRepository.deleteById(id);
        return "{La ligne "+id+" a été bien supprimée}";
    }


    public Ligne getLigneByNom(String nom){
        return ligneRepository.findByNom(nom).orElseThrow(
            ()
                -> new LigneNotFoundException(
                 "{Une ligne avec le nom " + nom+ " n'existe pas}"));
   
}
    
}
