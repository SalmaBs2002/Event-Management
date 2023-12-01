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
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class IntrfaceJAVAController implements Initializable {

      @FXML
    private Button BackBtn;

    @FXML
    private Button add_add_btn;

    @FXML
    private TextField add_address;

    @FXML
    private Button add_clear_btn;

    @FXML
    private TableColumn<?, ?> add_col_address;

    @FXML
    private TableColumn<?, ?> add_col_email;

    @FXML
    private TableColumn<?, ?> add_col_fees;

    @FXML
    private TableColumn<?, ?> add_col_first_name;

    @FXML
    private TableColumn<?, ?> add_col_id;

    @FXML
    private TableColumn<?, ?> add_col_last_name;

    @FXML
    private TableColumn<?, ?> add_col_number;

    @FXML
    private TableColumn<?, ?> add_col_school;

    @FXML
    private Button add_delete_btn;

    @FXML
    private TextField add_email;

    @FXML
    private TextField add_first_name;

    @FXML
    private TextField add_id;

    @FXML
    private TextField add_last_name;

    @FXML
    private TextField add_number;

    @FXML
    private Button add_participant_btn;

    @FXML
    private AnchorPane add_participant_form;

    @FXML
    private TextField add_school;

    @FXML
    private TableView<?> add_table_view;

    @FXML
    private Button add_update_btn;

    @FXML
    private AnchorPane home_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Label no_paid_nbr;

    @FXML
    private Label paid_nb;

    @FXML
    private BarChart<?, ?> participant_chart;

    @FXML
    private TextField search;

    @FXML
    private Button show_statistics_btn;

    @FXML
    private AnchorPane show_statistics_form;

    @FXML
    private Button signout;

    @FXML
    private Label total_nbr;

    @FXML
    private AnchorPane total_no_paid;

    @FXML
    private AnchorPane total_paid;

    @FXML
    private AnchorPane total_participants;
    
   
    
    ///Pour changer du bouton "show statistics" et "add participant"///
    public void switchForm(ActionEvent event){
        if (event.getSource() == show_statistics_btn){
            show_statistics_form.setVisible(true);
            add_participant_form.setVisible(false);
            show_statistics_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            add_participant_btn.setStyle("-fx-background-color: transparent;");
            
        }
        else if(event.getSource()== add_participant_btn){
            show_statistics_form.setVisible(false);
            add_participant_form.setVisible(true);
            add_participant_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            show_statistics_btn.setStyle("-fx-background-color: transparent;");
        }
    }
    
    
    public void signout(){
    Alert alert = new Alert (AlertType.CONFIRMATION);
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
