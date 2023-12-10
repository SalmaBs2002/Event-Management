package login_interface;



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
public class LoginPController implements Initializable {

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

 CreateAccount.setOnMouseClicked(event -> openCreateAccountView());
    }

    @FXML
    public void handleLogin(ActionEvent event) {
        // This method will be called when the button is clicked
        String username = usernameField.getText();
        String password = passwordField.getText();

     if (!isInValidLogin(username, password)) {
         openAcceuilView();
        } 
     else {
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
    public void handleSignup(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUp_interface/Signup.fxml"));
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

    @FXML
    private void handleSignup(MouseEvent event) {
    }
    
    
     private void openCreateAccountView() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Signup_interface/Signup.fxml"));
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
        }
    }

    private void openAcceuilView() {
try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Accueil_interface/Acceuil.fxml"));
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
        }    }

    @FXML
    private void handleLogin(MouseEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

     if (!isInValidLogin(username, password)) {
         openAcceuilView();
        } 
     else {
          String errorMessage = "Please try again.";
            showAlert(Alert.AlertType.ERROR, "Warning", "LOGIN or PASSWORD ERROR",errorMessage );
            
            // Add error handling or display a message to the user
        }
        
    }

    public void setPreFilledData(int idEven, String password) {
    usernameField.setText(String.valueOf(idEven));
    passwordField.setText(password);    }
    
}