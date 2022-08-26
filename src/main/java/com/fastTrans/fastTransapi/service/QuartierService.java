package com.fastTrans.fastTransapi.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastTrans.fastTransapi.exception.QuartierBadRequestException;
import com.fastTrans.fastTransapi.exception.QuartierConflictException;
import com.fastTrans.fastTransapi.exception.QuartierNotFoundException;
import com.fastTrans.fastTransapi.model.Quartier;
import com.fastTrans.fastTransapi.repository.QuartierRepository;

@Service
public class QuartierService {
@Autowired
QuartierRepository quartierRepository;
public Collection<Quartier> getAllQuartier(){
    return quartierRepository.findAll();
}

public String addQuartier(Quartier q){
     Quartier existingQuartier = quartierRepository.findById(q.getId()).orElse(null);
     if (existingQuartier == null){
        quartierRepository.save(q);
        return "Le quartier a été ajouté avec succès";
     }else
     {
        throw new QuartierConflictException("Le quartier existe déjà");
     }
}


public Quartier get(int id) {
     return quartierRepository.findById(id).orElseThrow(
            ()
                -> new QuartierNotFoundException(
                    "{Un quartier avec l'id " + id+ " n'existe pas}"));
}

public String updateQuartier(Quartier quartier) {
    Quartier existingQuartier = quartierRepository.findById(quartier.getId()).orElse(null);
    if (existingQuartier == null){
        throw new QuartierNotFoundException("{Ce quartier n'existe pas}");
    }
    else{
        existingQuartier.setNom(quartier.getNom());
        quartierRepository.save(existingQuartier);
        return "{Votre quartier a été mis à jour}";
        
    }
}

 public String deleteQuartierUsingId(int id){
    if (!quartierRepository.existsById(id)){
        throw new QuartierBadRequestException("{L'id "+id+" n'existe pas. Revoyez votre saisie.}");  
     }
     quartierRepository.deleteById(id); 
     return "{Le quartier "+id+" a été bien supprimé}";
    
    }   

    public Quartier getQuartierByNom(String nom){
            return quartierRepository.findByNom(nom).orElseThrow(
                ()
                    -> new QuartierNotFoundException(
                        "{Un quartier avec le nom " + nom+ " n'existe pas}"));
       
    }

    
}
