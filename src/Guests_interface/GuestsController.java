package Guests_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import pers.*;
import classes.Date;
import java.io.IOException;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class GuestsController implements Initializable {
    
    @FXML
    private Button SignoutBtn;
    private ToggleGroup ConfirmedTBG;
    @FXML
    private AnchorPane add_participant_form;
    @FXML
    private TextField add_id;
    @FXML
    private TextField add_first_name;
    @FXML
    private TextField add_last_name;
    @FXML
    private TextField add_number;
    @FXML
    private TextField add_address;
    @FXML
    private TextField add_field;
    @FXML
    private TextField add_type;
    @FXML
    private Button add_clear_btn;
    @FXML
    private Button add_update_btn;
    @FXML
    private Button add_delete_btn;
    @FXML
    private Button add_add_btn;
    @FXML
    private TableView<Invité> add_table_view;
    @FXML
    private TableColumn<Invité, Integer> add_col_id;
    @FXML
    private TableColumn<Invité, String> add_col_first_name;
    @FXML
    private TableColumn<Invité, String> add_col_last_name;
    @FXML
    private TableColumn<Invité, Integer> add_col_number;
    @FXML
    private TableColumn<Invité, String> add_col_address;
    @FXML
    private TableColumn<Invité, String> add_col_field;
    @FXML
    private TableColumn<Invité, String> add_col_type;
    @FXML
    private TableColumn<Invité, String> add_col_confirm;
    @FXML
    private TextField search;
    
    private ObservableList<Invité> list = FXCollections.observableArrayList(
            new Invité(125,"ayman","triki",new Date(16,07,2001),58726518
                    ,"La soukra","spectateur","VIP",true));
    @FXML
    private CheckBox ConfirmedCB;
    
    private Boolean buttonUpdateClicked = false;
    private Boolean buttonClearClicked = false;
    @FXML
    private Button BackBtn;
    
    public int getIndex (int id) {
        for (int i =0;i<list.size();i++) {
            if (list.get(i).getId()==id)
                return i;
        }
        return list.size();
    }
    
    public Invité extract (int i) {
        if (i>=0 && i<list.size())
            return list.get(i);
        else 
            return null;
    }
     
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        add_col_first_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        add_col_last_name.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        add_col_number.setCellValueFactory(new PropertyValueFactory<>("tel"));
        add_col_address.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        add_col_field.setCellValueFactory(new PropertyValueFactory<>("spécialisation"));
        add_col_type.setCellValueFactory(new PropertyValueFactory<>("typeInvité"));
        
        add_col_confirm.setCellValueFactory(cellData-> {
            boolean isActive = cellData.getValue().isaConfirmePresence();
            return new SimpleStringProperty(isActive ? "YES" : "NO");
        
        }
        );
        
        
        add_table_view.setItems(list);
    }    

    @FXML
    private void handleClear(ActionEvent event) {
        if (!buttonClearClicked){
            add_id.clear();
            add_first_name.clear();
            add_last_name.clear();
            add_address.clear();
            add_field.clear();
            add_number.clear();
            add_type.clear();
            ConfirmedCB.setSelected(false);
            buttonClearClicked=true;}
        else {
            Invité inviteSelect = add_table_view.getSelectionModel().getSelectedItem();
            int i = getIndex(inviteSelect.getId());
            inviteSelect.setId(Integer.valueOf(inviteSelect.getId()));
            inviteSelect.setNom(add_first_name.getText());
            inviteSelect.setPrenom(add_last_name.getText());
            inviteSelect.setAdresse(add_address.getText());
            inviteSelect.setSpécialisation(add_field.getText());
            inviteSelect.setTel(Integer.valueOf(add_number.getText()));
            inviteSelect.setTypeInvité(add_type.getText());
            if (ConfirmedCB.isSelected())
                inviteSelect.setaConfirmePresence(true);
            else
                inviteSelect.setaConfirmePresence(false);
            list.set(i, inviteSelect);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked=false;
        }
        
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        Invité inviteSelect = add_table_view.getSelectionModel().getSelectedItem();

    if (inviteSelect != null) {
        if (!buttonUpdateClicked){
            add_id.setText(String.valueOf(inviteSelect.getId()));
            add_first_name.setText(inviteSelect.getNom());
            add_last_name.setText(inviteSelect.getPrenom());
            add_number.setText(String.valueOf(inviteSelect.getTel()));
            add_address.setText(String.valueOf(inviteSelect.getAdresse()));
            add_field.setText(inviteSelect.getSpécialisation());
            add_type.setText(inviteSelect.getTypeInvité());
            add_update_btn.setText("SAVE");
            add_clear_btn.setText("CANCEL");
            buttonClearClicked=true;
            buttonUpdateClicked=true;
        }
        else {
            Invité In = new Invité();
            int i = getIndex(inviteSelect.getId());
            In.setId(Integer.valueOf(inviteSelect.getId()));
            In.setNom(add_first_name.getText());
            In.setPrenom(add_last_name.getText());
            In.setAdresse(add_address.getText());
            In.setSpécialisation(add_field.getText());
            In.setTel(Integer.valueOf(add_number.getText()));
            In.setTypeInvité(add_type.getText());
            if (ConfirmedCB.isSelected())
                In.setaConfirmePresence(true);
            else
                In.setaConfirmePresence(false);
            list.set(i, In);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked=false;
            buttonUpdateClicked=false;
        }
        
    } 
    else {
        showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil pour le modifier.");
    }
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(null);

        Label label = new Label(content);
        label.setWrapText(true);
        alert.getDialogPane().setContent(label);

        alert.getDialogPane().getStylesheets().add(
                getClass().getResource("guests.css").toExternalForm());

        alert.showAndWait();
    }

    @FXML
    private void HandleDelete(ActionEvent event) {
        Invité selectedProfil = add_table_view.getSelectionModel().getSelectedItem();
        if (selectedProfil != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Profil");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Profil?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // User clicked OK, remove the selected Donneur
                list.remove(selectedProfil);
            }
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
    }

    @FXML
    private void handleAjouter(ActionEvent event) {
        Invité in = new Invité();
        in.setId(Integer.valueOf(add_id.getText()));
        in.setNom(add_first_name.getText());
        in.setPrenom(add_last_name.getText());
        in.setAdresse(add_address.getText());
        in.setSpécialisation(add_field.getText());
        in.setTel(Integer.valueOf(add_number.getText()));
        in.setTypeInvité(add_type.getText());
        if (ConfirmedCB.isSelected())
            in.setaConfirmePresence(true);
        else
            in.setaConfirmePresence(false);

        list.add(in);
        System.out.println("evenement ajoutee");
        add_table_view.refresh();
        add_first_name.clear();
        add_last_name.clear();
        add_address.clear();
        add_field.clear();
        add_number.clear();
        add_type.clear();
        ConfirmedCB.setSelected(false);
    }

    @FXML
    private void handleSignout(ActionEvent event) {
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Message");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to logout ?");
    Optional<ButtonType> option = alert.showAndWait();
    try{
        if(option.get().equals(ButtonType.OK)){
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login_interface/LoginP.fxml"));
            Parent root = loader.load();
            
            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Signup Page");
            stage.setScene(new Scene(root));
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
        }
         }
    
       }
    catch(Exception e){e.printStackTrace();}
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FullMenu_interface/FullMenu.fxml"));
            Parent root = loader.load();
            
            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Signup Page");
            stage.setScene(new Scene(root));
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }

    @FXML
    private void Participants(ActionEvent event) {
    }

    @FXML
    private void Ocs(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Oc_interface/Oc.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("New Interface");
            stage.setScene(new Scene(root));

            // Close the current stage
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

            // Show the new stage
            stage.show();
        
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }

    @FXML
    private void Finance(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Finance_interface/Finance.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("New Interface");
            stage.setScene(new Scene(root));

            // Close the current stage
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

            // Show the new stage
            stage.show();
        
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }
    
}
