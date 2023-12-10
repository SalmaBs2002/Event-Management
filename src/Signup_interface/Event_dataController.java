package Signup_interface;

import classes.Evenement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Event_dataController implements Initializable {

 @FXML
    private Label labelId;
    
    @FXML
    private Label labelNom;
    
    @FXML
    private Label labelDate;
    
    @FXML
    private Label labelLieu;
    
    @FXML
    private Label labelCotisation;
    
    @FXML
    private Label labelCapaciteMaximale;
    @FXML
    private Label labelPassword;
    @FXML
    private Button okayButton;
    
    
    
    
   

    // ... ajoutez d'autres champs pour d'autres données ...

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void displayData(Evenement even) {
      labelId.setText(String.valueOf(even.getIdEven()));
        labelNom.setText(even.getNomEven());
        labelDate.setText(even.getDate().toString());
        labelLieu.setText(even.getLieu());
        labelCotisation.setText(String.valueOf(even.getCotisation()));
        labelCapaciteMaximale.setText(String.valueOf(even.getCapaciteMaximale()));
        
        
    }
    
}