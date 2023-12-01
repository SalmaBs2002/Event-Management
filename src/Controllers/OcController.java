/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 *
 * @author LENOVO
 */
public class OcController implements Initializable{
     @FXML
    private Button BackBtn;

    @FXML
    private Button Logistics_btn;

    @FXML
    private Button add_add_btn;

    @FXML
    private Button add_add_btn1;

    @FXML
    private Button add_add_btn2;

    @FXML
    private Button add_clear_btn;

    @FXML
    private Button add_clear_btn1;

    @FXML
    private Button add_clear_btn2;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_charge;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_domain;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_id;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_memb;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_name;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_sponsid;

    @FXML
    private TableColumn<?, ?> add_col_sponsoring_sup;

    @FXML
    private Button add_delete_btn;

    @FXML
    private Button add_delete_btn1;

    @FXML
    private Button add_delete_btn2;

    @FXML
    private TableColumn<?, ?> add_log_col_charge;

    @FXML
    private TableColumn<?, ?> add_log_col_dom;

    @FXML
    private TableColumn<?, ?> add_log_col_id;

    @FXML
    private TableColumn<?, ?> add_log_col_name;

    @FXML
    private TableColumn<?, ?> add_log_col_nbr;

    @FXML
    private TableColumn<?, ?> add_log_col_sup;

    @FXML
    private TextField add_log_id;

    @FXML
    private TextField add_log_name;

    @FXML
    private TextField add_spons_addr;

    @FXML
    private TableColumn<?, ?> add_spons_addr_col;

    @FXML
    private TextField add_spons_budg;

    @FXML
    private TableColumn<?, ?> add_spons_budg_col;

    @FXML
    private TextField add_spons_entr;

    @FXML
    private TableColumn<?, ?> add_spons_entr_col;

    @FXML
    private TextField add_spons_first;

    @FXML
    private TableColumn<?, ?> add_spons_first_col;

    @FXML
    private TextField add_spons_id;

    @FXML
    private TableColumn<?, ?> add_spons_id_col;

    @FXML
    private TextField add_spons_last;

    @FXML
    private TableColumn<?, ?> add_spons_last_col;

    @FXML
    private TextField add_spons_numb;

    @FXML
    private TableColumn<?, ?> add_spons_numb_col;

    @FXML
    private AnchorPane add_sponsor_form;

    @FXML
    private TableView<?> add_table_view;

    @FXML
    private TableView<?> add_table_view1;

    @FXML
    private TableView<?> add_table_view2;

    @FXML
    private TextField add_team_log_charge;

    @FXML
    private TextField add_team_log_dom;

    @FXML
    private TextField add_team_log_nb;

    @FXML
    private TextField add_team_log_sup;

    @FXML
    private TextField add_team_spons_charge;

    @FXML
    private TextField add_team_spons_dom;

    @FXML
    private TextField add_team_spons_id;

    @FXML
    private TextField add_team_spons_name;

    @FXML
    private TextField add_team_spons_nbr;

    @FXML
    private TextField add_team_spons_sup;

    @FXML
    private Button add_update_btn;

    @FXML
    private Button add_update_btn1;

    @FXML
    private Button add_update_btn2;

    @FXML
    private AnchorPane logistics_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TextField search;

    @FXML
    private TextField search1;

    @FXML
    private TextField search2;

    @FXML
    private Button signout;

    @FXML
    private Button sponsoring_btn;

    @FXML
    private Button add_sponsor_btn;

    @FXML
    private AnchorPane sponsoring_form;
    
       public void switchForm(ActionEvent event){
        if (event.getSource() == Logistics_btn){
            logistics_form.setVisible(true);
            sponsoring_form.setVisible(false);
            add_sponsor_form.setVisible(false);
            Logistics_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            sponsoring_btn.setStyle("-fx-background-color: transparent;");
            add_sponsor_btn.setStyle("-fx-background-color: transparent;");
            
        }
        else if(event.getSource()== sponsoring_btn){
            logistics_form.setVisible(false);
            sponsoring_form.setVisible(true);
            add_sponsor_form.setVisible(false);
            sponsoring_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            Logistics_btn.setStyle("-fx-background-color: transparent;");
            add_sponsor_btn.setStyle("-fx-background-color: transparent;");
        }
        else if(event.getSource()== add_sponsor_btn){
            logistics_form.setVisible(false);
            sponsoring_form.setVisible(false);
            add_sponsor_form.setVisible(true);
            add_sponsor_btn.setStyle("-fx-background-color: linear-gradient(to bottom right, #121c76, #ffff);");
            sponsoring_btn.setStyle("-fx-background-color: transparent;");
            Logistics_btn.setStyle("-fx-background-color: transparent;");
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
