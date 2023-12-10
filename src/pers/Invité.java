/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pers;

import classes.Date;

/**
 *
 * @author Asus
 */
public class Invité extends Personne {

    private String spécialisation;
    private String typeInvité;
    private boolean aConfirmePresence;

    // Constructeur
    public Invité(int id, String nom, String prenom,Date dateNaiss , int tel, String adresse, String spécialisation,
            String typeInvité, boolean aConfirmePresence) {
        super(id, nom, prenom,dateNaiss , tel, adresse);
        this.spécialisation = spécialisation;
        this.typeInvité=typeInvité;
        this.aConfirmePresence = aConfirmePresence;
    }

    public Invité() {
        super(0, "", "",new Date(0,0,0) , 0, "");
        this.spécialisation = "";
        this.typeInvité="";
        this.aConfirmePresence = true;
    }

    public String getSpécialisation() {
        return spécialisation;
    }

    public void setSpécialisation(String spécialisation) {
        this.spécialisation = spécialisation;
    }
    
    public String getTypeInvité() {
        return typeInvité;
    }

    public void setTypeInvité(String typeInvité) {
        this.typeInvité = typeInvité;
    }

    public boolean isaConfirmePresence() {
        return aConfirmePresence;
    }

    public void setaConfirmePresence(boolean aConfirmePresence) {
        this.aConfirmePresence = aConfirmePresence;
    }
    
    @Override
    public String toString () {
        return (super.toString() + "\n specialisation : " + spécialisation + "\n son Type : " + typeInvité 
                + "\n sa presence est : " + aConfirmePresence);
    }
}

