/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipes;

import classes.GestionListe;
import classes.MyException;
import pers.Sponsors;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public final class Sponsoring extends EquipeOrg implements GestionListe {

    private String typeSponsoring;
    private int Budget;
   final private List<Sponsors> listeSponsors;

    public Sponsoring(int idEq,String nomEquipe, String domaine, int nombreMembres, String responsable, String typeSponsoring, int Budget) {
        super(idEq,nomEquipe, domaine, nombreMembres, responsable);
        this.typeSponsoring = typeSponsoring;
        this.Budget = Budget;
        this.listeSponsors = new ArrayList<>();
    }

    public Sponsoring() {
        super(0,"", "", 0, "");
        this.typeSponsoring = "";
        this.Budget = 0;
        this.listeSponsors = new ArrayList<>();
    }
        

    public String getTypeSponsoring() {
        return typeSponsoring;
    }

    public void setTypeSponsoring(String typeSponsoring) {
        this.typeSponsoring = typeSponsoring;
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int Budget) {
        this.Budget = Budget;
    }
    
     public List<Sponsors> getListeSponsors() {
        return listeSponsors;
    }

    public void ajouterSponsor(Sponsors sponsor) throws MyException {
        if ( rechercherElement(sponsor.getId()) ==false){
            listeSponsors.add(sponsor);
        }
        else    
            throw new MyException ("sponsor existe deja");
    }
    
    public void calculBudget(){
        Budget=0;
        for (int i =0;i< listeSponsors.size();i++)
            Budget+=listeSponsors.get(i).getMontantsponsoring();
    }

    public void modifierSponsor(int id, Sponsors nouveauSponsor) throws MyException {
        for (int i = 0; i < listeSponsors.size(); i++) {
            if (listeSponsors.get(i).getId() == id) {
                setBudget(Budget-listeSponsors.get(i).getMontantsponsoring()
                        +nouveauSponsor.getMontantsponsoring());
                listeSponsors.set(i, nouveauSponsor);
                break;
            }
            else
                throw new MyException ("sponsor inexistant");
        }
    }

    public void supprimerSponsor(int id) throws MyException{
        for (int i = 0; i < listeSponsors.size(); i++) {
            if (listeSponsors.get(i).getId() == id) {
                setBudget(Budget-listeSponsors.get(i).getMontantsponsoring());
                listeSponsors.remove(i);
                break;
            }
            else
                throw new MyException ("sponsor inexistant");
        }
    }
    public String getRole() {
        return "Membre du Sponsoring";
    }
    
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer ("\n -----equipe de Sponsoring de Type : " + typeSponsoring 
                + "\n -----son Budget : " + Budget + "\n *****liste des sponsors : " );
        int i=1;
        for (Sponsors sponsor : listeSponsors) {
            sb.append("\n " + "i)" + "       " + sponsor.toString() + "    ");
            i++;
        }
        return (sb.toString());
    }

    @Override
    public boolean rechercherElement(int id) {
        for (int i = 0; i < listeSponsors.size(); i++) {
            if (listeSponsors.get(i).getId() == id) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void supprimerElement(int id) throws MyException {
        for (int i = 0; i < listeSponsors.size(); i++) {
            if (listeSponsors.get(i).getId() == id) {
                setBudget(Budget-listeSponsors.get(i).getMontantsponsoring());
                listeSponsors.remove(i);
                break;
            }
            else
                throw new MyException ("sponsor inexistant");
        }
    }
}