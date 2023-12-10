/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pers;

import classes.Date;
import classes.PersonneService;


/**
 *
 * @author Asus
 */
public abstract class Personne implements PersonneService{

    private int id;
    private String nom;
    private String prenom;
    private Date dateNaiss;
    private int tel;
    private String adresse;

    public Personne(int id, String nom, String prenom, Date dateNaiss , int tel, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss=dateNaiss;
        this.tel = tel;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    @Override
    public String toString (){
        return("   Id : " + id + "\n son Nom : " + nom + "\n son Prenom : " + prenom +"\n date de naissance : " + dateNaiss +
                "\n son numero de telephone " + tel + "\n son adresse : " + adresse );
    }

    @Override
    public String getNomComplet() {
        return prenom + " " + nom;
    }

    @Override
    public boolean estMajeur(Date dateActuelle) {
        if (dateNaiss.getAnnée()<dateActuelle.getAnnée()-18)
            return true;
        else
            if (dateActuelle.getAnnée()-18==dateNaiss.getAnnée()) {
                if (dateNaiss.getMois()<dateActuelle.getMois()) {
                    return true;
                }
                else
                    if (dateNaiss.getMois()==dateActuelle.getMois()) {
                        if (dateActuelle.getJour() >= dateNaiss.getJour()) {
                            return true;
                        }
                    }
            }
        return false;
    }

    @Override
    public void afficherDetails() {
        System.out.println("Détails de la personne :");
        System.out.println("Id : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Prénom : " + prenom);
        System.out.println("Date de naissance : " + dateNaiss);
        System.out.println("Téléphone : " + tel);
        System.out.println("Adresse : " + adresse);    }
}

