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

import com.fastTrans.fastTransapi.model.Ligne;
import com.fastTrans.fastTransapi.service.LigneService;



@RestController
public class LigneController {
@Autowired
LigneService ligneService;
@CrossOrigin(origins="http://localhost:4200")
/*Afficher tous les éléments de la base de données*/
@GetMapping(value="/api/lignes")
public Collection<Ligne> getAllLigne(){
    return ligneService.getAllLigne();
}
 
/*Ajouter un élément dans la base de données*/
@PostMapping(value="/api/lignes/post")
public String addLigne(@RequestBody Ligne l){
    return ligneService.addLigne(l);
    }
   
/*Afficher un élément de la base de données */
@GetMapping(value="/api/lignes/{id}/get")
public /*Optional<Ligne>*/ Ligne getLigneById(@PathVariable("id") int id){
return ligneService.get(id);
}

/*Message de bienvenue(essayage) */
   @GetMapping(value="/")
   public String getPage(){
       return "Welcome to FASTTRANS-API";
   }

/*Supprimer un élément de la base de données */
@DeleteMapping(value="/api/lignes/{id}/delete")
public String deleteLigne(@PathVariable("id") int id){
    return ligneService.deleteLigneUsingId(id);   
}

/*Mettre à jour un élément de la base de données*/
@PutMapping(value="/api/lignes/{id}/put")
public String updateLigne(@RequestBody Ligne ligne){
    return ligneService.updateLigne(ligne);
}

/*Afficher une ligne par rapport à son nom */
@GetMapping("/api/lignes/")
public Ligne getLigneByNom(@PathParam("nom") String nom ){
  return ligneService.getLigneByNom(nom);
  
}
}
