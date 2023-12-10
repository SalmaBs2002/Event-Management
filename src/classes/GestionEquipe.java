/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package classes;

import equipes.EquipeOrg;
import equipes.Sponsoring;


/**
 *
 * @author Asus
 */
public interface GestionEquipe extends GestionListe {
    void ajouterEq(Sponsoring equipe) throws MyException;
}
