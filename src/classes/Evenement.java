/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import equipes.EquipeOrg;
import equipes.Logistique;
import equipes.Sponsoring;
import pers.Participant;
import pers.Invité;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */


public class Evenement implements GestionEquipe{

    private int idEven;
    private String nomEven;
    private Date date;
    private String lieu;
    private int cotisation;
    private int capaciteMaximale;
    private String password;
    private List<Participant> participants;
    private List<Invité> invites;
    private List<Logistique> EqLogistiques;
    private List<Sponsoring> EqSponsorings;
    private int sommeCotisationsPayees; 


    public Evenement(int idEven, String nomEven, Date date, String lieu, int cotisation ,
                     int capaciteMaximale) {
        this.idEven = idEven;
        this.nomEven = nomEven;
        this.date = date;
        this.lieu = lieu;
        this.cotisation = cotisation;
        this.participants = new ArrayList<>();
        this.invites = new ArrayList<>();
        this.EqLogistiques = new ArrayList<>();
        this.EqSponsorings = new ArrayList<>();
        
    }

    public Evenement() {
        this.participants = new ArrayList<>();
        this.invites = new ArrayList<>();
        this.EqLogistiques = new ArrayList<>();
        this.EqSponsorings = new ArrayList<>();
    }

    public int getIdEven() {
        return idEven;
    }

    public void setIdEven(int idEven) {
        this.idEven = idEven;
    }

    public String getNomEven() {
        return nomEven;
    }

    public void setNomEven(String nomEven) {
        this.nomEven = nomEven;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getCotisation() {
        return cotisation;
    }

    public void setCotisation(int cotisation) {
        this.cotisation = cotisation;
    }
    
    public int getCapaciteMaximale() {
        return capaciteMaximale;
    }

    public void setCapaciteMaximale(int capaciteMaximale) {
        this.capaciteMaximale = capaciteMaximale;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Invité> getInvites() {
        return invites;
    }

    public void setInvites(List<Invité> invites) {
        this.invites = invites;
    }

    public List<Logistique> getEqLogistiques() {
        return EqLogistiques;
    }

    public void setEqLogistiques(List<Logistique> EqLogistiques) {
        this.EqLogistiques = EqLogistiques;
    }
    
    public List<Sponsoring> getEqSponsorings() {
        return EqSponsorings;
    }

    public void setEqSponsorings(List<Sponsoring> EqSponsorings) {
        this.EqSponsorings = EqSponsorings;
    }

    
    @Override
    public boolean rechercherElement(int id) {
        for (int i=0 ;i < EqSponsorings.size();i++ ){
            if (EqSponsorings.get(i).getIdEq()==id){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ajouterEq(Sponsoring equipe) throws MyException{
        if (rechercherElement(equipe.getIdEq())){
            EqSponsorings.add(equipe);
        }
        else
            throw new MyException("equipe deja existante");
    }

    @Override
     public void supprimerElement(int id) throws MyException{
         if (rechercherElement(id)){
            EqSponsorings.removeIf(equipe -> equipe.getIdEq() == id);
         }
         else
            throw new MyException("equipe deja inexistante");
    }
     
     public boolean rechercherEqLogistiques(int id) {
        for (int i=0 ;i < EqLogistiques.size();i++ ){
            if (EqLogistiques.get(i).getIdEq()==id){
                return true;
            }
        }
        return false;
    }
    
    public void ajouterEqLogistiques(Logistique equipe) throws MyException{
        if (rechercherElement(equipe.getIdEq())){
            EqLogistiques.add(equipe);
        }
        else
            throw new MyException("equipe deja existante");
    }

     public void supprimerEqLogistiques(int id) throws MyException{
         if (rechercherElement(id)){
            EqLogistiques.removeIf(equipe -> equipe.getIdEq() == id);
         }
         else
            throw new MyException("equipe deja inexistante");
    }
    
    public boolean estComplet() {
        return participants.size() >= capaciteMaximale;
    }
    
    public int nombreParticipantsInscrits() {
        return participants.size();
    }
    
    public void rechercherParticipant(int id) {
    
    }
    
    public void calculerSommeCotisationsPayees() {
        sommeCotisationsPayees = 0; // Réinitialise la somme des cotisations
        for (Participant participant : participants) {
            if (participant.aPayeFrais()) {
                sommeCotisationsPayees += cotisation;
            }
        }
    }
  public int getSommeCotisationsPayees() {
        return sommeCotisationsPayees;
    }
    
    public void ajouterParticipant(Participant participant) {
        if (!estComplet()) {
            participants.add(participant);
        } else {
            System.out.println("L'événement est complet, l'ajout de participants n'est pas possible.");
        }
    }
    
    public void afficherInformationsEvenement() {
        System.out.println("Informations de l'événement :");
        System.out.println("Id de l'événement : " + idEven);
        System.out.println("Nom : " + nomEven);
        System.out.println("Date : " + date);
        System.out.println("Lieu : " + lieu);
        System.out.println("Cotisation : " + cotisation);
        System.out.println("Nombre de participants inscrits : " + nombreParticipantsInscrits());
    }
    
    
    @Override
    public String toString () {
        return("//////////////l'id de l'evenement est : " + idEven + "\n Nom : " + nomEven + "\n Date : " + date + 
                "\n Lieu : " + lieu + "\n Cotisation : " + cotisation + "\n Nombre de participants inscrits : " +
                nombreParticipantsInscrits());
    }

}
