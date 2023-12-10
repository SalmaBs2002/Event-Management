package Signup_interface;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import classes.Evenement;
import classes.Date;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import login_interface.LoginPController;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class signupController implements Initializable {

    LinkedList<Evenement> evenements;
    @FXML
    private Label back;
    @FXML
    private TextField tfID;
    @FXML
    private DatePicker dpStart;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfFees;
    @FXML
    private TextField tfCapacity;
    @FXML
    private TextField tfLocation;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private DatePicker dpEnd;
    @FXML
    private Label loginlab;
    @FXML
    private Button saveButton;
    @FXML
    private PasswordField tfConfirmPassword;
    
    public signupController (){
        evenements = new LinkedList();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        back.setOnMouseClicked(event -> openNewView());
        saveButton.setOnAction(event -> saving(event));
    }    

    private void openNewView() {
        try {
            // Load the new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/login_interface/LoginP.fxml"));
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
        }    }

    @FXML
    private void saving(ActionEvent event) {
        Evenement even = new Evenement();
        even.setIdEven(Integer.valueOf(tfID.getText()));
        even.setNomEven(tfName.getText());
        even.setDate(new Date(dpStart.getValue().getDayOfMonth(),dpStart.getValue().getMonthValue(),dpStart.getValue().getYear()));
        even.setLieu(tfLocation.getText());
        even.setCotisation(Integer.valueOf(tfFees.getText()));
        even.setCapaciteMaximale(Integer.valueOf(tfCapacity.getText()));
        even.setPassword(tfPassword.getText());
        
        String confirmPassword = tfConfirmPassword.getText();
    if (!confirmPassword.equals(even.getPassword())) {
        // Afficher une alerte si les mots de passe ne correspondent pas
        showAlert(AlertType.ERROR, "Erreur", "Les mots de passe ne correspondent pas.", "Veuillez saisir le même mot de passe dans les champs de mot de passe et de confirmation.");
        return; // Sortir de la méthode si les mots de passe ne correspondent pas
    }
    
        evenements.add(even);
        System.out.println("evenement ajoutee");
        
        
        openLoginView(even.getIdEven(), even.getPassword());
        openNewInterface(even, event);
        
        Stage signupStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        signupStage.close();
        
        
    }
    
    private void showAlert(AlertType alertType, String title, String headerText, String contentText) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(headerText);
    alert.setContentText(contentText);
    alert.showAndWait();
}
    private void openNewInterface(Evenement even, ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Event_data.fxml"));
        Parent root = loader.load();
        Event_dataController controller = loader.getController();
        controller.displayData(even);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);

        // Set the onCloseRequest event to handle the close operation
        stage.setOnCloseRequest(windowEvent -> {
            // Handle the close operation as needed (e.g., show an alert)
            System.out.println("Event_data stage is closing.");
        });

        // Show the stage
        stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void openLoginView(int idEven, String password) {
 try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login_interface/LoginP.fxml"));
        Parent root = loader.load();

        // Get the controller for the login page
        LoginPController loginController = loader.getController();

        // Set pre-filled data in the login controller
        loginController.setPreFilledData(idEven, password);

        // Create a new stage
        Stage stage = new Stage();
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root));
        stage.show();

        // Close the current stage (signup interface)
        Stage currentStage = (Stage) back.getScene().getWindow();
    } catch (Exception e) {
        e.printStackTrace();
    }    }
    
    public void setPreFilledData(int eventId, String password) {
    tfName.setText(String.valueOf(eventId));
     tfPassword.setText(password);
}

    @FXML
    private void openLoginView(MouseEvent event) {
        
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login_interface/LoginP.fxml"));
        Parent root = loader.load();

        // Get the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene
        stage.setScene(new Scene(root));

        // Show the stage
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
   
}
