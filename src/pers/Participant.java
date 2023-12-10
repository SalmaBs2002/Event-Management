/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pers;

import classes.Date;
import pers.Personne;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Participant extends Personne{

    private String email;
    private String typeEtablissement; 
    private boolean aPayeFrais;
    private List<String> formationsEtAteliers;
    
    public Participant(int id, String nom, String prenom, Date dateNaiss , int tel, String adresse, String email,
                        String typeEtablissement) {
        super(id, nom, prenom,dateNaiss, tel, adresse);
        this.email = email;
        this.typeEtablissement = typeEtablissement;
        this.aPayeFrais = false;
        this.formationsEtAteliers = new ArrayList<>(); 
       
    }

    public Participant() {
            super(0, "", "",new Date(0,0,0), 00000000, "");
        this.email = "";
        this.typeEtablissement = "";
        this.aPayeFrais = false;
        this.formationsEtAteliers = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String gettypeEtablissement() {
        return typeEtablissement;
    }

    public void settypeEtablissement(String typeEtablissement) {
        this.typeEtablissement = typeEtablissement;
    }
     public boolean aPayeFrais() {
        return aPayeFrais;
    }

    public boolean isaPayeFrais() {
        return aPayeFrais;
    }

    public void setaPayeFrais(boolean aPayeFrais) {
        this.aPayeFrais = aPayeFrais;
    }
    

    public void PayerFrais() {
        aPayeFrais = true;
    }

    public void afficherStatutPaiement() {
        if (aPayeFrais) {
            System.out.println("Le participant a payé la cotisation.");
        } else {
            System.out.println("Le participant n'a pas encore payé la cotisation.");
        }
    }
    public List<String> getFormationsEtAteliers() {
        return formationsEtAteliers;
    }

    public void ajouterFormationOuAtelier(String formationOuAtelier) {
        formationsEtAteliers.add(formationOuAtelier);
    }

    @Override
    public String toString () {
        StringBuffer sb = new StringBuffer (super.toString()+ "\n      son email est : " + email +
                "\n son type d'etablissement est : " + typeEtablissement + "\n a paye ses frais : " +
                aPayeFrais + "\n ***********ses formations et ateliers sont : ");
        for (String formation : formationsEtAteliers) {
            sb.append("\n       " + formation.toString() + "    ");
        }
        return sb.toString();
    }

    public String getTypeEtablissement() {
        return typeEtablissement;
    }
    
}