package FullMenu_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class FullMenuController implements Initializable {
    
    private Label label;
    
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonSignOut(ActionEvent event) {
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
    private void clickedParticipant(MouseEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Participant_interface/InterfaceJAVA.fxml"));
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
    private void OCTeamClicked(MouseEvent event) {
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
    private void GuestsClicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Guests_interface/Guests.fxml"));
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
    private void FinanceClicked(MouseEvent event) {
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

    @FXML
    private void YourEventClicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Event_interface/event.fxml"));
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
