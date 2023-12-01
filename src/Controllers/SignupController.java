/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class SignupController implements Initializable {

    @FXML
    private Button back;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         back.setOnMouseClicked(event -> openNewView());
    }    
    
    @FXML
    private void handleBack(MouseEvent event) {
    }
    
    
     private void openNewView() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML_files/Login.fxml"));
            Parent root = loader.load();

            // Create a new scene
            Scene scene = new Scene(root);

            // Get the stage
            Stage stage = (Stage) back.getScene().getWindow();

            // Set the new scene
            stage.setScene(scene);

            // Show the stage
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }}
}
