/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package classes;


/**
 *
 * @author Asus
 */
public interface GestionListe {
    boolean rechercherElement(int id);
    void supprimerElement(int id) throws MyException ;
}
