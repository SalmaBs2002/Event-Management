/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Participant_interface;

import classes.Date;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pers.Participant;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class IntrfaceJAVAController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private Button BackBtn;
    @FXML
    private Button show_statistics_btn;
    @FXML
    private Button add_participant_btn;
    @FXML
    private Button signout;
    @FXML
    private AnchorPane show_statistics_form;
    @FXML
    private AnchorPane home_form;
    @FXML
    private BarChart<String, Number> participant_chart;
    @FXML
    private AnchorPane total_participants;
    @FXML
    private Label total_nbr;
    @FXML
    private AnchorPane total_paid;
    @FXML
    private Label paid_nb;
    @FXML
    private AnchorPane total_no_paid;
    @FXML
    private Label no_paid_nbr;
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
    private TextField add_email;
    @FXML
    private TextField add_school;
    @FXML
    private Button add_clear_btn;
    @FXML
    private Button add_update_btn;
    @FXML
    private Button add_delete_btn;
    @FXML
    private Button add_add_btn;
    @FXML
    private TableView<Participant> add_table_view;
    @FXML
    private TableColumn<Participant, Integer> add_col_id;
    @FXML
    private TableColumn<Participant, String> add_col_first_name;
    @FXML
    private TableColumn<Participant, String> add_col_last_name;
    @FXML
    private TableColumn<Participant, Integer> add_col_number;
    @FXML
    private TableColumn<Participant, String> add_col_address;
    @FXML
    private TableColumn<Participant, String> add_col_email;
    @FXML
    private TableColumn<Participant, String> add_col_school;
    @FXML
    private TableColumn<Participant, String> add_col_fees;
    @FXML
    private TextField search;
    @FXML
    private CheckBox cbfees;
    
    private ObservableList<Participant> list = FXCollections.observableArrayList(
            new Participant(125,"ayman","triki",new Date(16,07,2001),58726518
                    ,"La soukra","tayman620@gmail.com","Enicarthage"),new Participant(126,"Salma","Bensaad",new Date(03,01,2002),92631204
                    ,"Sousse","salmabs@gmail.com","Esprit"),
    new Participant(127, "Alice", "Smith", new Date(12, 11, 2000), 98765432,
            "456 Oak St", "alice.smith@example.com", "ABC High School"),new Participant(132, "Oliver", "Davis", new Date(30, 06, 1994), 47586930,
            "345 Cedar St", "oliver.davis@example.com", "567 School"),new Participant(131, "Sophia", "Miller", new Date(30, 06, 1994), 19283746,
            "901 Birch St", "sophia.miller@example.com", "234 Academy"));
    

    
    private Boolean buttonUpdateClicked = false;
    private Boolean buttonClearClicked = false;
    
    private int paidParticipants = 0;
    private int unpaidParticipants = 0;
    private int totalParticipants=0;
    @FXML
    private PieChart PieChart;
    
    
    public int getIndex (int id) {
        for (int i =0;i<list.size();i++) {
            if (list.get(i).getId()==id)
                return i;
        }
        return list.size();
    }
    
    public Participant extract (int i) {
        if (i>=0 && i<list.size())
            return list.get(i);
        else 
            return null;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        add_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        add_col_first_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        add_col_last_name.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        add_col_number.setCellValueFactory(new PropertyValueFactory<>("tel"));
        add_col_address.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        add_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        add_col_school.setCellValueFactory(new PropertyValueFactory<>("typeEtablissement"));
        
        add_col_fees.setCellValueFactory(cellData-> {
            boolean isActive = cellData.getValue().aPayeFrais();
            return new SimpleStringProperty(isActive ? "YES" : "NO");
        
        }
                
        );
        
        
        add_table_view.setItems(list);
        for (Participant participant : list) {
        if (participant.aPayeFrais()) {
            paidParticipants++;
        } else {
            unpaidParticipants++;
        }
    }
        
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("Paid", paidParticipants));
        series.getData().add(new XYChart.Data<>("Unpaid", unpaidParticipants));

        participant_chart.getData().add(series);
        updateLabels();
        updateChart();
        updatePieChart();
         initializePieChart();
    }    

    @FXML
    private void switchForm(ActionEvent event) {
        if (event.getSource() == add_participant_btn){
            add_participant_form.setVisible(true);
            add_participant_form.setManaged(true);
            show_statistics_form.setVisible(false);
            show_statistics_form.setManaged(false);
            add_participant_btn.setStyle("-fx-background-color: #121c76;");
            show_statistics_btn.setStyle("-fx-background-color: transparent;");
            
        }
        else if(event.getSource()== show_statistics_btn){
            show_statistics_form.setVisible(true);
            show_statistics_form.setManaged(true);
            add_participant_form.setVisible(false);
            add_participant_form.setManaged(false);
            show_statistics_btn.setStyle("-fx-background-color: #121c76;");
            add_participant_btn.setStyle("-fx-background-color: transparent;");
        }
    }

    @FXML
    private void signout(ActionEvent event) {
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
    private void back(ActionEvent event) {
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
    private void Clear(ActionEvent event) {
         if (!buttonClearClicked){
            add_id.clear();
            add_first_name.clear();
            add_last_name.clear();
            add_address.clear();
            add_school.clear();
            add_number.clear();
            add_email.clear();
            cbfees.setSelected(false);
            buttonClearClicked=true;}
        else {
            Participant ParticipantSelect = add_table_view.getSelectionModel().getSelectedItem();
            int i = getIndex(ParticipantSelect.getId());
            ParticipantSelect.setId(Integer.valueOf(ParticipantSelect.getId()));
            ParticipantSelect.setNom(add_first_name.getText());
            ParticipantSelect.setPrenom(add_last_name.getText());
            ParticipantSelect.setAdresse(add_address.getText());
            ParticipantSelect.settypeEtablissement(add_school.getText());
            ParticipantSelect.setTel(Integer.valueOf(add_number.getText()));
            ParticipantSelect.setEmail(add_email.getText());
            if (cbfees.isSelected())
                ParticipantSelect.setaPayeFrais(true);
            else
                ParticipantSelect.setaPayeFrais(false);
            list.set(i, ParticipantSelect);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked=false;
        }
        
    }

    @FXML
    private void Update(ActionEvent event) {
        Participant ParticipantSelect = add_table_view.getSelectionModel().getSelectedItem();

    if (ParticipantSelect != null) {
        if (!buttonUpdateClicked){
            add_id.setText(String.valueOf(ParticipantSelect.getId()));
            add_first_name.setText(ParticipantSelect.getNom());
            add_last_name.setText(ParticipantSelect.getPrenom());
            add_number.setText(String.valueOf(ParticipantSelect.getTel()));
            add_address.setText(String.valueOf(ParticipantSelect.getAdresse()));
            add_email.setText(ParticipantSelect.getEmail());
            add_school.setText(ParticipantSelect.gettypeEtablissement());
            add_update_btn.setText("SAVE");
            add_clear_btn.setText("CANCEL");
            buttonClearClicked=true;
            buttonUpdateClicked=true;
            
             
        }
        else {
            Participant In = new Participant();
            int i = getIndex(ParticipantSelect.getId());
            In.setId(Integer.valueOf(ParticipantSelect.getId()));
            In.setNom(add_first_name.getText());
            In.setPrenom(add_last_name.getText());
            In.setAdresse(add_address.getText());
            In.setEmail(add_email.getText());
            In.settypeEtablissement(add_school.getText());
            In.setTel(Integer.valueOf(add_number.getText()));
            if (cbfees.isSelected())
                In.setaPayeFrais(true);
            else
                In.setaPayeFrais(false);
            list.set(i, In);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked=false;
            buttonUpdateClicked=false;
            
             if (ParticipantSelect.aPayeFrais()) {
                paidParticipants++;
                unpaidParticipants--;
            } else {
                paidParticipants--;
                unpaidParticipants++;
            }
         updateChart();  
        updateLabels();
        updateStatistics();
        updatePieChart();
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
    private void Delete(ActionEvent event) {
        Participant selectedProfil = add_table_view.getSelectionModel().getSelectedItem();
        if (selectedProfil != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Profil");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Profil?");
            
            if (selectedProfil != null) {
            if (selectedProfil.aPayeFrais()) {
                paidParticipants--;
            } else {
                unpaidParticipants--;
            }

            // Update the BarChart
          
        }

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // User clicked OK, remove the selected Donneur
                list.remove(selectedProfil);
            }
            
             updateLabels();
            updateChart();
            updateStatistics();
            updatePieChart();
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
    }

    @FXML
    private void Add(ActionEvent event) {
      try {
        int id = Integer.valueOf(add_id.getText());
        String firstName = add_first_name.getText();
        String lastName = add_last_name.getText();
        int number = Integer.valueOf(add_number.getText());
        String address = add_address.getText();
        String email = add_email.getText();
        String school = add_school.getText();
        boolean hasFees = cbfees.isSelected();

        Participant participant = new Participant(id, firstName, lastName, null, number, address, email, school);
        participant.setaPayeFrais(hasFees);

        list.add(participant);
        System.out.println("Participant ajouté");
        updateLabels();
        updateChart();
        updateStatistics();
        updatePieChart();
       

    } catch (NumberFormatException e) {
        showAlert("Erreur de saisie", "Veuillez saisir des valeurs valides pour les champs numériques.");
    }
    }
    private void updateStatistics() {
    totalParticipants = list.size();
    total_nbr.setText(String.valueOf(totalParticipants));
    
    // Calculate paid and unpaid participants
    paidParticipants = 0;
    unpaidParticipants = 0;
    for (Participant participant : list) {
        if (participant.aPayeFrais()) {
            paidParticipants++;
        } else {
            unpaidParticipants++;
        }
    }

    // Update labels
    paid_nb.setText(String.valueOf(paidParticipants));
    no_paid_nbr.setText(String.valueOf(unpaidParticipants));

    // Update BarChart
    updateChart();
     updatePieChart();
}
   
 private void updateChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
    series.getData().add(new XYChart.Data<>("Paid", paidParticipants));
    series.getData().add(new XYChart.Data<>("Unpaid", unpaidParticipants));

    participant_chart.getData().clear();
    participant_chart.getData().add(series);
    }
 private void initializePieChart() {
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Paid", 0), // Initial values, you can set them to actual initial values
            new PieChart.Data("Unpaid", 0));

    PieChart.setData(pieChartData);
    PieChart.setTitle("Paid vs Unpaid Participants");
    PieChart.setLegendVisible(true);
    PieChart.setLabelsVisible(true);
}
 private void updatePieChart() {
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Paid", paidParticipants),
            new PieChart.Data("Unpaid", unpaidParticipants));

    PieChart.setData(pieChartData);
}
 private void updateLabels() {
    int totalParticipants = list.size();
    int paidParticipants = 0;
    int unpaidParticipants = 0;

    // Iterate through the list to count paid and unpaid participants
    for (Participant participant : list) {
        if (participant.aPayeFrais()) {
            paidParticipants++;
        } else {
            unpaidParticipants++;
        }
    }

    // Update the labels
    total_nbr.setText(String.valueOf(totalParticipants));
    paid_nb.setText(String.valueOf(paidParticipants));
    no_paid_nbr.setText(String.valueOf(unpaidParticipants));
}
    
}
