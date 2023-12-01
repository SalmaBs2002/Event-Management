package Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField usernameField;
    @FXML
    private Label CreateAccount;
    @FXML
    private Button LoginButton;
    
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
// Optional: You can perform any initialization here

 CreateAccount.setOnMouseClicked(event -> openNewView());
    }

    @FXML
    public void handleLogin(ActionEvent event) {
        // This method will be called when the button is clicked
        String username = usernameField.getText();
        String password = passwordField.getText();

     if (!isInValidLogin(username, password)) {
            System.out.println("Valid User");
             loadAccueilPage();     
             
            // Add navigation or further actions here
        } else {
          String errorMessage = "Please try again.";
            showAlert(Alert.AlertType.ERROR, "Warning", "LOGIN or PASSWORD ERROR",errorMessage );
            
            // Add error handling or display a message to the user
        }
    }

 
    private boolean isInValidLogin(String username, String password) {
        // Add your login validation logic here
        // For demonstration purposes, always return true
        if (username.equals("") || password.equals("")) return true;
        return false;
    }

    private void showAlert(Alert.AlertType alertType, String title,String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
         alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
 

    @FXML
    private void handleSignup(MouseEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML_files/signup.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Signup Page");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }
    
    
     private void openNewView() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/signup/signup.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the stage
            Stage stage = (Stage) CreateAccount.getScene().getWindow();

            // Set the new scene
            stage.setScene(scene);

            // Show the stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }}
    private void loadAccueilPage() {
    try {
        // Load the "accueil" page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Accueil/accueil.fxml"));
        Parent root = loader.load();

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Accueil Page");
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current login page (optional)
        ((Stage) usernameField.getScene().getWindow()).close();
    } catch (Exception e) {
        e.printStackTrace(); // Handle exception appropriately
    }
    }
    
}