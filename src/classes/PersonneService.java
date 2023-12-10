/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package classes;

import classes.Date;


/**
 *
 * @author Asus
 */
public interface PersonneService {
    String getNomComplet();
    
    boolean estMajeur(Date dateActuelle);
    
    void afficherDetails();
    
}
