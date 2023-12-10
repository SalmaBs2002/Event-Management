/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Finance_interface;

import classes.Date;
import finance.Dépenses;
import finance.Revenus;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FinanceController implements Initializable {

    @FXML
    private Button BackBtn;
    
    @FXML
    private Button add_add_btn;

    @FXML
    private Button add_add_btn1;

    @FXML
    private TextField add_amount_exp;

    @FXML
    private TextField add_amount_inc;

    @FXML
    private Button add_clear_btn;

    @FXML
    private Button add_clear_btn1;

    @FXML
    private Button add_delete_btn;

    @FXML
    private Button add_delete_btn1;

    @FXML
    private TextField add_desc_exp;

    @FXML
    private TextField add_desc_inc;

    @FXML
    private Button add_inc_exp_btn;

    @FXML
    private AnchorPane add_inc_exp_form;


    @FXML
    private TextField add_num_inc;
    @FXML
    private TextField add_num_exp;
    
    @FXML
    private TextField add_tva_exp;


    @FXML
    private Button show_stat_btn;
    
    @FXML
    private Button signout;

    @FXML
    private AnchorPane show_stat_fin_form;
    
    @FXML
    private TableView<Revenus> table_inc;
    @FXML
    private TableColumn<Revenus, Integer> colonne_num_inc;
    @FXML
    private TableColumn<Revenus, String> colonne_desc_inc;
    @FXML
    private TableColumn<Revenus, Double> colonne_montant_inc;
    
    @FXML
    private TableView<Dépenses> table_exp;
    @FXML
    private TableColumn<Dépenses, Integer> colonne_num_exp;
    @FXML
    private TableColumn<Dépenses, String> colonne_desc_exp;
    @FXML
    private TableColumn<Dépenses, Double> colonne_montant_exp;
    @FXML
    private TableColumn<Dépenses, Double> colonne_tva_exp;
    @FXML
    private Label total_income;
    @FXML
    private Label total_expenses;
    @FXML
    private Label status;
    
    private ObservableList<Revenus> listInc = FXCollections.observableArrayList(
            new Revenus(1,"sponsoring",3000));
    
    private ObservableList<Dépenses> listExp = FXCollections.observableArrayList(
            new Dépenses(1,"dejeuner",25,0.1));
    
    private double total_inc=3000;
    private double total_exp=25;
    
    
    private boolean buttonClearClicked=true;
    private boolean buttonUpdateClicked=true;
    @FXML
    private BarChart<String, Number> BarChart;
    
   
    

    
    @FXML
     public void switchForm(ActionEvent event){
        if (event.getSource() == show_stat_btn){
            show_stat_fin_form.setVisible(true);
            show_stat_fin_form.setManaged(true);
            add_inc_exp_form.setVisible(false);
            add_inc_exp_form.setManaged(false);
            show_stat_btn.setStyle("-fx-background-color: #121c76;");
            add_inc_exp_btn.setStyle("-fx-background-color: transparent;");
            
        }
        else if(event.getSource()== add_inc_exp_btn){
            add_inc_exp_form.setVisible(true);
            add_inc_exp_form.setManaged(true);
            show_stat_fin_form.setVisible(false);
            show_stat_fin_form.setManaged(false);
            add_inc_exp_btn.setStyle("-fx-background-color: #121c76;");
            show_stat_btn.setStyle("-fx-background-color: transparent;");
        }
    }
    
    
    @FXML
    public void signout(ActionEvent event){
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
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
    catch(Exception e){
        e.printStackTrace();}
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colonne_num_inc.setCellValueFactory(new PropertyValueFactory<>("idR"));
        colonne_desc_inc.setCellValueFactory(new PropertyValueFactory<>("description"));
        colonne_montant_inc.setCellValueFactory(new PropertyValueFactory<>("montantrevenus"));
        table_inc.setItems(listInc);

        
        colonne_num_exp.setCellValueFactory(new PropertyValueFactory<>("id"));
        colonne_desc_exp.setCellValueFactory(new PropertyValueFactory<>("description"));
        colonne_montant_exp.setCellValueFactory(new PropertyValueFactory<>("montant"));
        colonne_tva_exp.setCellValueFactory(new PropertyValueFactory<>("tauxTVA"));
        table_exp.setItems(listExp);
        
        total_income.setText(String.valueOf(total_inc));
        total_expenses.setText(String.valueOf(total_exp));
 
        initializeBarChart();
        
    }    

    @FXML
    private void handleAddIN(ActionEvent event) {
        int id =Integer.valueOf(add_num_inc.getText());
        String desc =add_desc_inc.getText();
        Double amount = Double.valueOf(add_amount_inc.getText());
        Revenus in = new Revenus(id,desc,amount);

        
        listInc.add(in);
        System.out.println("Revenus ajoutee");
        table_inc.refresh();
        add_num_inc.clear();
        add_desc_inc.clear();
        add_amount_inc.clear();
        total_inc=total_inc+amount;
        total_income.setText(String.valueOf(total_inc));
        
         updateStatusLabel();
         updateBarChart();
    }


    @FXML
    private void handleClearIn(ActionEvent event) {
        
            add_num_inc.clear();
            add_desc_inc.clear();
            add_amount_inc.clear();
            buttonClearClicked=true;}
        
         
    

    @FXML
    private void handleDeleteIn(ActionEvent event) {
        Revenus selectedProfil = table_inc.getSelectionModel().getSelectedItem();
        if (selectedProfil != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Profil");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Profil?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                total_inc=total_inc-selectedProfil.getMontantrevenus();

                // User clicked OK, remove the selected Donneur
                listInc.remove(selectedProfil);
                total_income.setText(String.valueOf(total_inc));
                 updateStatusLabel();
                 updateBarChart();

            }
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
    }

    @FXML
    private void handleAddEx(ActionEvent event) {
        Dépenses in = new Dépenses();
        in.setId(Integer.valueOf(add_num_exp.getText()));
        in.setDescription(add_desc_exp.getText());
        in.setMontant(Double.valueOf(add_amount_exp.getText()));
        double amount=Double.valueOf(add_amount_exp.getText());
        in.setTauxTVA(Double.valueOf(add_tva_exp.getText()));
        
        listExp.add(in);
        System.out.println("Dépense ajoutee");
        table_exp.refresh();
        add_num_exp.clear();
        add_desc_exp.clear();
        add_amount_exp.clear();
        add_tva_exp.clear();
        total_exp=total_exp+amount;
        total_expenses.setText(String.valueOf(total_exp));
        
         updateStatusLabel();
         updateBarChart();
    }

    
    public int getIndexE (int idR) {
        for (int i =0;i<listExp.size();i++) {
            if (listExp.get(i).getId()==idR)
                return i;
        }
        return listExp.size();
    }
    
    public Dépenses extractE (int i) {
        if (i>=0 && i<listExp.size())
            return listExp.get(i);
        else 
            return null;
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
    private void HandleClearEx(ActionEvent event) {
            add_num_exp.clear();
            add_desc_exp.clear();
            add_amount_exp.clear();
            add_tva_exp.clear();
            
    }
    
    public int getIndexR (int idR) {
        for (int i =0;i<listInc.size();i++) {
            if (listInc.get(i).getIdR()==idR)
                return i;
        }
        return listInc.size();
    }
    
    public Revenus extractR (int i) {
        if (i>=0 && i<listInc.size())
            return listInc.get(i);
        else 
            return null;
    }
    

    @FXML
    private void HandleDeleteEx(ActionEvent event) {
        Dépenses selectedProfil = table_exp.getSelectionModel().getSelectedItem();
        if (selectedProfil != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Profil");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Profil?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                total_exp=total_exp-selectedProfil.getMontant();

                // User clicked OK, remove the selected Donneur
                listExp.remove(selectedProfil);
                total_expenses.setText(String.valueOf(total_exp));
                
                 updateStatusLabel();
                 updateBarChart();
            }
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
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
    

    private void initializeBarChart() {
        
     XYChart.Series<String, Number> expenseSeries = new XYChart.Series<>();
    expenseSeries.setName("Expenses");

    // Add total expense amount to the expense series
    expenseSeries.getData().add(new XYChart.Data<>("Expenses", total_exp));

    // Create series for revenues
    XYChart.Series<String, Number> revenueSeries = new XYChart.Series<>();
    revenueSeries.setName("Incomes");

    // Add total income amount to the revenue series
    revenueSeries.getData().add(new XYChart.Data<>("Incomes", total_inc));

    // Clear existing data from the BarChart
    BarChart.getData().clear();

    // Add series to the existing BarChart
    BarChart.getData().addAll(expenseSeries, revenueSeries);

    // Set the bar width to fit the content
    for (XYChart.Series<String, Number> series : BarChart.getData()) {
        for (XYChart.Data<String, Number> data : series.getData()) {
            data.getNode().setStyle("-fx-bar-width: 40;");
            customizeBarChartAppearance();
        }
    }
    }
    
    private void updateStatusLabel() {
    if (total_inc > total_exp) {
        status.setText("Profitable");
    } else if (total_inc < total_exp) {
        status.setText("Loss");
    } else {
        status.setText("Balanced");
    }}
private void updateBarChart() {
    XYChart.Series<String, Number> expenseSeries = new XYChart.Series<>();
    expenseSeries.setName("Expenses");

    // Add total expense amount to the expense series
    expenseSeries.getData().add(new XYChart.Data<>("Expenses", total_exp));

    // Create series for revenues
    XYChart.Series<String, Number> revenueSeries = new XYChart.Series<>();
    revenueSeries.setName("Incomes");

    // Add total income amount to the revenue series
    revenueSeries.getData().add(new XYChart.Data<>("Incomes", total_inc));

    // Clear existing data from the BarChart
    BarChart.getData().clear();

    // Add series to the existing BarChart
    BarChart.getData().addAll(expenseSeries, revenueSeries);

    // Set the bar width to fit the content
    for (XYChart.Series<String, Number> series : BarChart.getData()) {
        for (XYChart.Data<String, Number> data : series.getData()) {
            data.getNode().setStyle("-fx-bar-width: 40;");
        
    }
    }}
private void customizeBarChartAppearance(){
    BarChart.setStyle("-fx-bar-gap: 5; -fx-category-gap: 10;");
    for (XYChart.Series<String, Number> series : BarChart.getData()){
    for(XYChart.Data<String,Number> data: series.getData()){
    Node bar =data.getNode();
    bar.setStyle("-fx-bar-fill: " +(series.getName().equals("Expenses")? "#FF6347;" : "#32CD32;")+
            "-fx-bar-width: 30; -fx-bar-border-color: #000000; -fx-bar-border-width: 1;");
    }
    }
}




}



    
