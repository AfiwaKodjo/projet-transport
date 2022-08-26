package com.fastTrans.fastTransapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "lignes")
public class Ligne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    private String nom;

    @Column
    private String depart;

    @Column
    private String terminus;

    @OneToMany()
    @Column(nullable= false)
    @JoinColumn(name="ligne_id")
    private List<PtArret> ptArrets;

    public Ligne(){}

  public Ligne(String nom, String depart, String terminus){

        this.nom=nom;
        this.depart=depart;
        this.terminus=terminus;
    }

    public List<PtArret> getPtArrets() {
    return ptArrets;
    }

public void setPtArrets(List<PtArret> ptArrets) {
    this.ptArrets = ptArrets;
    }

    public int getId(){
        return id;
    }

    public String getNom(){
        return nom;
    }

    public String getDepart(){
        return depart;
    }

    public String getTerminus(){
        return terminus;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public void setDepart(String depart){
        this.depart=depart;
    }

    public void setTerminus(String terminus){
        this.terminus=terminus;
    }

    public Ligne(String nom, String depart, String terminus, List<PtArret> ptArrets) {
        this.nom = nom;
        this.depart = depart;
        this.terminus = terminus;
        this.ptArrets = ptArrets;
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
        return "Ligne [depart=" + depart + ", id=" + id + ", nom=" + nom + ", ptArrets=" + ptArrets + ", terminus="
                + terminus + "]";
    }

    




    
}
