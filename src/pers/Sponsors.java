/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pers;

import classes.Date;
import pers.Personne;

/**
 *
 * @author Asus
 */
public class Sponsors extends Personne {

    private String typeSponsoring;
    private String nom_entreprise;
    private int montantsponsoring;

    public Sponsors(int id, String nom, String prenom, Date dateNaiss , int tel, String adresse, String typeSponsoring,
            String nom_entreprise, int montantsponsoring) {
        super(id, nom, prenom,dateNaiss , tel, adresse);
        this.typeSponsoring = typeSponsoring;
        this.nom_entreprise=nom_entreprise;
        this.montantsponsoring = montantsponsoring;
    }

    public Sponsors() {
        super(0, "", "",new Date(0,0,0) , 00000000, "");
        this.typeSponsoring = "";
        this.nom_entreprise="";
        this.montantsponsoring = 0;
    }

    public String getTypeSponsoring() {
        return typeSponsoring;
    }

    public void setTypeSponsoring(String typeSponsoring) {
        this.typeSponsoring = typeSponsoring;
    }

    public int getMontantsponsoring() {
        return montantsponsoring;
    }

    public void setMontantsponsoring(int montantsponsoring) {
        this.montantsponsoring = montantsponsoring;
    }
    
    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }
    
    @Override
    public String toString (){
        return ("sponsor " + super.toString() + "type de sponsoring : " + typeSponsoring +
                " nom d'entreprise : " + nom_entreprise + " montant de sponsoring : " + montantsponsoring);
    }
}
