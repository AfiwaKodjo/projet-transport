package com.fastTrans.fastTransapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastTrans.fastTransapi.exception.PtArretBadRequestException;
import com.fastTrans.fastTransapi.exception.PtArretConflictException;
import com.fastTrans.fastTransapi.exception.PtArretNotFoundException;
import com.fastTrans.fastTransapi.model.PtArret;
import com.fastTrans.fastTransapi.repository.PtArretRepository;
import com.fastTrans.fastTransapi.repository.QuartierRepository;

@Service
public class PtArretService {
@Autowired
PtArretRepository ptArretRepository;
QuartierRepository quartierRepository;

public List<PtArret> getAllPtArret(){
    return ptArretRepository.findAll();
}

public String addPtArret(PtArret a) {
    PtArret existingPtArret = ptArretRepository.findById(a.getId()).orElse(null);
    if (existingPtArret == null){
        ptArretRepository.save(a);
        return "Le point d'arrêt a été ajouté avec succès";
    }else
    {
        throw new PtArretConflictException("Le point d'arrêt existe déjà");
    }
}

public PtArret get(int id) {
    return ptArretRepository.findById(id).orElseThrow(
        ()
            -> new PtArretNotFoundException(
                "{Un point d'arrêt avec l'id " + id+ " n'existe pas}"));
}

public String deletePtArretUsingId(int id){
    if (!ptArretRepository.existsById(id)){
        throw new PtArretBadRequestException("{L'id "+id+" n'existe pas. Revoyez votre saisie.}");
    }
    ptArretRepository.deleteById(id);
    return "{Le point d'arrêt "+id+" a été bien supprimé}";
}

public String updatePtArret(PtArret ptArret) {
    PtArret existingPtArret = ptArretRepository.findById(ptArret.getId()).orElse(null);
    if(existingPtArret == null){
        throw new PtArretNotFoundException("{Ce point d'arrêt n'existe pas}");
    }
    else{
        existingPtArret.setNom(ptArret.getNom());
        ptArretRepository.save(existingPtArret);
        return "{Votre point d'arrêt a été mis à jour}";
    }

}

public PtArret getPtArretByNom(String nom){
         return ptArretRepository.findByNom(nom).orElseThrow(
             ()
                 -> new PtArretNotFoundException(
                  "{Un point d'arrêt avec le nom " + nom+ " n'existe pas}"));
    
 }

}