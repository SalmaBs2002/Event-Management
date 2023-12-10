/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finance;

/**
 *
 * @author LENOVO
 */
public record Revenus(int idR,String description, double montantrevenus) {
    
    public Revenus {
        if (montantrevenus < 0) {
            throw new IllegalArgumentException("Montant revenus cannot be negative");
        }
    }
    
    public double getMontantrevenus (){
        return montantrevenus;
    }
    
    public String getDescription (){
        return description;
    }
    
    public int getIdR (){
        return idR;
    }
    
}
