package com.fastTrans.fastTransapi.controller;

import java.util.Collection;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fastTrans.fastTransapi.model.Quartier;
import com.fastTrans.fastTransapi.service.QuartierService;

@RestController
public class QuartierController {
  @Autowired
  QuartierService quartierService;
@CrossOrigin(origins="http://localhost:4200")
//Afficher tous les quartiers
@GetMapping("/api/quartiers")
public Collection<Quartier> getAllQuartier(){
    return quartierService.getAllQuartier();
}

//Ajouter un quartier dans la base de données
@PostMapping("/api/quartiers/post")
public String addQuartier(@RequestBody Quartier q){
    return quartierService.addQuartier(q);
}

//Afficher un quartier de la base de données
@GetMapping("/api/quartiers/{id}/get")
public Quartier getQuartierById(@PathVariable("id") int id ){
  return quartierService.get(id);
  
}

/*Supprimer un élément de la base de données */
@DeleteMapping(value="/api/quartiers/{id}/delete")
public String deleteQuartier(@PathVariable("id") int id){
     return quartierService.deleteQuartierUsingId(id); 
}


/*Mettre à jour un élément de la base de données*/
@PutMapping(value="/api/quartiers/{id}/put")
public String updateQuartier(@RequestBody Quartier quartier){
    return quartierService.updateQuartier(quartier);
}

/*Afficher un quartier par rapport à son nom */
@GetMapping("/api/quartiers/")
public Quartier getQuartierByNom(@PathParam("nom") String nom ){
  return quartierService.getQuartierByNom(nom);
  
}

    
}
