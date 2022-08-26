package com.fastTrans.fastTransapi.controller;

import java.util.List;

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

import com.fastTrans.fastTransapi.model.PtArret;
import com.fastTrans.fastTransapi.service.PtArretService;
import com.fastTrans.fastTransapi.service.QuartierService;


@RestController
public class PtArretController {
@Autowired
PtArretService ptArretService;
QuartierService quartierService;
@CrossOrigin(origins="http://localhost:4200")
/*Afficher tous les éléments de la base de données*/
@GetMapping(value = "/api/pt-arrets")
public List<PtArret> getAllPtArret(){
    return ptArretService.getAllPtArret();
}

/*Ajouter un élément dans la base de données*/
@PostMapping(value = "/api/pt-arrets/post")
public String addPtArret(@RequestBody PtArret a){
    return ptArretService.addPtArret(a);
}

/*Afficher un point d'arrêt de la base de données*/
@GetMapping(value = "api/pt-arrets/{id}/get")
public /*Optional<PtArret>*/PtArret getPtArretById(@PathVariable("id") int id){
    return ptArretService.get(id);
}

/* Supprimer un élément de la base de données*/
@DeleteMapping(value="/api/pt-arrets/{id}/delete")
public String deletePtArret(@PathVariable("id") int id){
    return ptArretService.deletePtArretUsingId(id);
}

/*Mettre à jour un élément de la base de données*/
@PutMapping(value="/api/pt-arrets/{id}/put")
public String updatePtArret(@RequestBody PtArret ptArret,@PathVariable("id") int id){
    return ptArretService.updatePtArret(ptArret);
}

/*Afficher un point d'arrêt par rapport à son nom */
@GetMapping("/api/pt-arrets/")
public PtArret getPtArretByNom(@PathParam("nom") String nom ){
  return ptArretService.getPtArretByNom(nom);
  
}

}
