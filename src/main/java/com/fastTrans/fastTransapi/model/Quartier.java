package com.fastTrans.fastTransapi.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quartiers")
public class Quartier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;

    @Column(unique=true)
    private String nom;

    public Quartier(){}

    public Quartier(String nom){
        this.nom=nom;
    }

    public int getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setNom(String nom){
        this.nom=nom;
    }


    @Override
    public int hashCode() {
        final int prime = 10;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "Quartier [id=" + id + ", nom=" + nom + "]";
    }

    


    
}
