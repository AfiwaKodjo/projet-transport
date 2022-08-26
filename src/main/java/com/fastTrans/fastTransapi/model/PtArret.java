package com.fastTrans.fastTransapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ptArrets")

public class PtArret {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(insertable=true , updatable=false)
    private int id;

    @Column(unique=true)
    private String nom;
    
    @ManyToOne
    @JoinColumn(name="quartier_id")
    private Quartier quartier;

    public PtArret(){}

    public PtArret(String nom) {
        this.nom = nom;
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

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }

    public PtArret(String nom, Quartier quartier) {
        this.nom = nom;
        this.quartier = quartier;
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
        return "PtArret [id=" + id + ", nom=" + nom + ", quartier=" + quartier + "]";
    }

    


    
}
