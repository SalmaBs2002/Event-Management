/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipes;

/**
 *
 * @author Asus
 */
public sealed class EquipeOrg permits Sponsoring , Logistique {

    private int idEq;
    private String nomEquipe;
    private String domaine;
    private int nombreMembres;
    private String responsable;

    public EquipeOrg(int idEq,String nomEquipe, String domaine, int nombreMembres, String responsable) {
        this.idEq=idEq;
        this.nomEquipe = nomEquipe;
        this.domaine = domaine;
        this.nombreMembres = nombreMembres;
        this.responsable = responsable;
    }


    public int getIdEq() {
        return idEq;
    }

    public void setIdEq(int idEq) {
        this.idEq = idEq;
    }
    
    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getNombreMembres() {
        return nombreMembres;
    }

    public void setNombreMembres(int nombreMembres) {
        this.nombreMembres = nombreMembres;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    @Override
    public String toString() {
        return("\n      Id de l'equipe est : " + idEq + "\n son Nom est : " + nomEquipe + "\n son Domaine : " + domaine +
                "\n possedant" + nombreMembres + " membres \n son Responsable est :" + responsable);
    }
}
