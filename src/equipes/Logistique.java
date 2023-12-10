/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipes;

/**
 *
 * @author Asus
 */
public final class Logistique extends EquipeOrg {

    private String domaineLogistique;
    private int nombreMateriels;

    public Logistique(int idEq,String nomEquipe, String domaine, int nombreMembres, String responsable,
                        String domaineLogistique, int nombreMateriels) {
        super(idEq,nomEquipe, domaine, nombreMembres, responsable);
        this.domaineLogistique = domaineLogistique;
        this.nombreMateriels = nombreMateriels;
    }

    public Logistique() {
        super(0,"", "", 0, "");
        this.domaineLogistique = "";
        this.nombreMateriels = 0;
    }

    public String getDomaineLogistique() {
        return domaineLogistique;
    }

    public void setDomaineLogistique(String domaineLogistique) {
        this.domaineLogistique = domaineLogistique;
    }

    public int getNombreMateriels() {
        return nombreMateriels;
    }

    public void setNombreMateriels(int nombreMateriels) {
        this.nombreMateriels = nombreMateriels;
    }
    
    public String getRole() {
    return("membre de la logistique");
    }
    
    @Override
    public String toString() {
        return(super.toString() + "\n son domaine : " + domaineLogistique + " possedant " 
                + nombreMateriels + " Materiels");
    }
}
