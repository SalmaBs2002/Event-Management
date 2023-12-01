/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FinanceController implements Initializable {

    
    @FXML
    private Button BackBtn;

    @FXML
    private Button add_add_btn;

    @FXML
    private Button add_add_btn1;

    @FXML
    private TextField add_amount_exp;

    @FXML
    private TextField add_amount_inc;

    @FXML
    private Button add_clear_btn;

    @FXML
    private Button add_clear_btn1;

    @FXML
    private Button add_delete_btn;

    @FXML
    private Button add_delete_btn1;

    @FXML
    private TextField add_desc_exp;

    @FXML
    private TextField add_desc_inc;

    @FXML
    private Button add_inc_exp_btn;

    @FXML
    private AnchorPane add_inc_exp_form;

    @FXML
    private TextField add_num_exp;

    @FXML
    private TextField add_num_inc;

    @FXML
    private Button add_update_btn;

    @FXML
    private Button add_update_btn1;

    @FXML
    private Button show_stat_btn;
    
    @FXML
    private Button signout;

    @FXML
    private AnchorPane show_stat_fin_form;
    
     public void switchForm(ActionEvent event){
        if (event.getSource() == show_stat_btn){
            show_stat_fin_form.setVisible(true);
            add_inc_exp_form.setVisible(false);
            show_stat_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            add_inc_exp_btn.setStyle("-fx-background-color: transparent;");
            
        }
        else if(event.getSource()== add_inc_exp_btn){
            add_inc_exp_form.setVisible(false);
            show_stat_fin_form.setVisible(true);
            add_inc_exp_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            show_stat_btn.setStyle("-fx-background-color: transparent;");
        }
    }
    
    
    public void signout(){
    Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Message");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to logout ?");
    Optional<ButtonType> option = alert.showAndWait();
    try{
        if(option.get().equals(ButtonType.OK)){
            signout.getScene().getWindow().hide();
             Parent root = FXMLLoader.load(getClass().getResource("/FXML_files/Login.fxml"));
             Stage stage = new Stage();
             Scene scene = new Scene (root);
         }
    
       }
    catch(Exception e){e.printStackTrace();}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
