package Oc_interface;

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
import equipes.*;
import classes.Date;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pers.Sponsors;

/**
 *
 * @author Asus
 */
public class OcController implements Initializable {

    @FXML
    private AnchorPane main_form;
    @FXML
    private Button BackBtn;
    @FXML
    private Button Logistics_btn;
    @FXML
    private Button sponsoring_btn;
    @FXML
    private Button signout;
    @FXML
    private Button add_sponsor_btn;
    @FXML
    private AnchorPane logistics_form;
    @FXML
    private TextField add_log_id;
    @FXML
    private TextField add_log_name;
    @FXML
    private TextField add_team_log_dom;
    @FXML
    private TextField add_team_log_sup;
    @FXML
    private TextField add_team_log_charge;
    @FXML
    private TextField add_team_log_nb;
    @FXML
    private TextField add_team_log_mat;
    @FXML
    private Button add_clear_btn;
    @FXML
    private Button add_update_btn;
    @FXML
    private Button add_delete_btn;
    @FXML
    private Button add_add_btn;
    @FXML
    private TableView<Logistique> add_table_view;
    @FXML
    private TableColumn<Logistique, Integer> add_log_col_id;
    @FXML
    private TableColumn<Logistique, String> add_log_col_name;
    @FXML
    private TableColumn<Logistique, String> add_log_col_dom;
    @FXML
    private TableColumn<Logistique, String> add_log_col_sup;
    @FXML
    private TableColumn<Logistique, String> add_log_col_charge;
    @FXML
    private TableColumn<Logistique, Integer> add_log_col_nbr;
    @FXML
    private TableColumn<Logistique, Integer> add_log_col_mat;
    @FXML
    private TextField search;
    @FXML
    private AnchorPane sponsoring_form;
    @FXML
    private TextField add_team_spons_id;
    @FXML
    private TextField add_team_spons_name;
    @FXML
    private TextField add_team_spons_dom;
    @FXML
    private TextField add_team_spons_sup;
    @FXML
    private TextField add_team_spons_charge;
    @FXML
    private TextField add_team_spons_nbr;
    @FXML
    private TextField add_team_spons_Bud;
    @FXML
    private Button add_clear_btn1;
    @FXML
    private Button add_update_btn1;
    @FXML
    private Button add_delete_btn1;
    @FXML
    private Button add_add_btn1;
    @FXML
    private TableView<Sponsoring> add_table_view1;
    @FXML
    private TableColumn<Sponsoring, Integer> add_col_sponsoring_id;
    @FXML
    private TableColumn<Sponsoring, String> add_col_sponsoring_name;
    @FXML
    private TableColumn<Sponsoring, String> add_col_sponsoring_domain;
    @FXML
    private TableColumn<Sponsoring, String> add_col_sponsoring_sup;
    @FXML
    private TableColumn<Sponsoring, String> add_col_sponsoring_charge;
    @FXML
    private TableColumn<Sponsoring, Integer> add_col_sponsoring_memb;
    @FXML
    private TableColumn<Sponsoring, Integer> add_col_sponsoring_budget;
    @FXML
    private TextField search1;
    @FXML
    private AnchorPane add_sponsor_form;
    @FXML
    private TextField add_spons_id;
    @FXML
    private TextField add_spons_first;
    @FXML
    private TextField add_spons_last;
    @FXML
    private TextField add_spons_numb;
    @FXML
    private TextField add_spons_addr;
    @FXML
    private TextField add_spons_entr;
    @FXML
    private TextField add_spons_budg;
    @FXML
    private TextField add_spons_type;
    @FXML
    private Button add_clear_btn2;
    @FXML
    private Button add_update_btn2;
    @FXML
    private Button add_delete_btn2;
    @FXML
    private Button add_add_btn2;
    @FXML
    private TableView<Sponsors> add_table_view2;
    @FXML
    private TableColumn<Sponsors, Integer> add_spons_id_col;
    @FXML
    private TableColumn<Sponsors, String> add_spons_first_col;
    @FXML
    private TableColumn<Sponsors, String> add_spons_last_col;
    @FXML
    private TableColumn<Sponsors, String> add_spons_numb_col;
    @FXML
    private TableColumn<Sponsors, String> add_spons_addr_col;
    @FXML
    private TableColumn<Sponsors, String> add_spons_entr_col;
    @FXML
    private TableColumn<Sponsors, Integer> add_spons_budg_col;
    @FXML
    private TableColumn<Sponsors, Integer> add_spons_type_col;
    @FXML
    private TextField search2;
    
     private ObservableList<Sponsors> list = FXCollections.observableArrayList(
            new Sponsors(1,"Lilia","Fourati",new Date(16,07,2001),23232323
                    ,"SFAX","Espece","COGNIRA",3000));
     private ObservableList<Sponsoring> list1 = FXCollections.observableArrayList(
            new Sponsoring(1,"AAA","BBB",0,"Ayman","Transport",30000));
      private ObservableList<Logistique> list2 = FXCollections.observableArrayList(
            new Logistique(1,"AAA","BBB",0,"Ayman","Transport",25));
    
    private Boolean buttonUpdateClicked = false;
    private Boolean buttonClearClicked = false;
    private Boolean buttonUpdateClicked1 = false;
    private Boolean buttonClearClicked1 = false;
    private Boolean buttonUpdateClicked2 = false;
    private Boolean buttonClearClicked2 = false;

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
    public void switchForm(ActionEvent event){
        if (event.getSource() == Logistics_btn){
            logistics_form.setVisible(true);
            logistics_form.setManaged(true);
            sponsoring_form.setVisible(false);
            sponsoring_form.setManaged(false);
            add_sponsor_form.setVisible(false);
            add_sponsor_form.setManaged(false);
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        add_spons_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        add_spons_first_col.setCellValueFactory(new PropertyValueFactory<>("nom"));
        add_spons_last_col.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        add_spons_numb_col.setCellValueFactory(new PropertyValueFactory<>("tel"));
        add_spons_addr_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        add_spons_entr_col.setCellValueFactory(new PropertyValueFactory<>("nom_entreprise"));
        add_spons_budg_col.setCellValueFactory(new PropertyValueFactory<>("montantsponsoring"));
        add_spons_type_col.setCellValueFactory(new PropertyValueFactory<>("typeSponsoring"));
        add_table_view2.setItems(list);
        
        add_col_sponsoring_id.setCellValueFactory(new PropertyValueFactory<>("idEq"));
        add_col_sponsoring_name.setCellValueFactory(new PropertyValueFactory<>("nomEquipe"));
        add_col_sponsoring_domain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        add_col_sponsoring_sup.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        add_col_sponsoring_memb.setCellValueFactory(new PropertyValueFactory<>("nombreMembres"));
        add_col_sponsoring_budget.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        add_col_sponsoring_charge.setCellValueFactory(new PropertyValueFactory<>("typeSponsoring"));
        add_table_view1.setItems(list1);
        
        add_log_col_id.setCellValueFactory(new PropertyValueFactory<>("idEq"));
        add_log_col_name.setCellValueFactory(new PropertyValueFactory<>("nomEquipe"));
        add_log_col_dom.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        add_log_col_nbr.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        add_log_col_sup.setCellValueFactory(new PropertyValueFactory<>("nombreMembres"));
        add_log_col_charge.setCellValueFactory(new PropertyValueFactory<>("domaineLogistique"));
        add_log_col_mat.setCellValueFactory(new PropertyValueFactory<>("nombreMateriels"));
        add_table_view.setItems(list2);

    }
    
    @FXML
    private void handleClear(ActionEvent event) {
        if (!buttonClearClicked){
            add_spons_id.clear();
            add_spons_first.clear();
            add_spons_last.clear();
            add_spons_addr.clear();
            add_spons_budg.clear();
            add_spons_numb.clear();
            add_spons_entr.clear();
            add_spons_type.clear();
            buttonClearClicked=true;}
        else {
            Sponsors SponsSelect = add_table_view2.getSelectionModel().getSelectedItem();
            int i = getIndex(SponsSelect.getId());
            SponsSelect.setId(Integer.valueOf(SponsSelect.getId()));
            SponsSelect.setNom(add_spons_first.getText());
            SponsSelect.setPrenom(add_spons_last.getText());
            SponsSelect.setAdresse(add_spons_addr.getText());
            SponsSelect.setMontantsponsoring(Integer.valueOf(add_spons_budg.getText()));
            SponsSelect.setTel(Integer.valueOf(add_spons_numb.getText()));
            SponsSelect.setNom_entreprise(add_spons_entr.getText());
            SponsSelect.setTypeSponsoring(add_spons_type.getText());
            
            list.set(i, SponsSelect);
            add_update_btn2.setText("Update");
            add_clear_btn2.setText("Clear");
            buttonClearClicked=false;
        }
        
    }
    
    public int getIndex (int id) {
        for (int i =0;i<list.size();i++) {
            if (list.get(i).getId()==id)
                return i;
        }
        return list.size();
    }
    
    public Sponsors extract (int i) {
        if (i>=0 && i<list.size())
            return list.get(i);
        else 
            return null;
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        Sponsors SponsSelect = add_table_view2.getSelectionModel().getSelectedItem();

    if (SponsSelect != null) {
        if (!buttonUpdateClicked){
            add_spons_id.setText(String.valueOf(SponsSelect.getId()));
            add_spons_first.setText(SponsSelect.getNom());
            add_spons_last.setText(SponsSelect.getPrenom());
            add_spons_addr.setText(SponsSelect.getAdresse());
            add_spons_budg.setText(String.valueOf(SponsSelect.getMontantsponsoring()));
            add_spons_numb.setText(String.valueOf(SponsSelect.getTel()));
            add_spons_entr.setText(SponsSelect.getNom_entreprise());
            add_spons_type.setText(SponsSelect.getTypeSponsoring());
            add_update_btn2.setText("SAVE");
            add_clear_btn2.setText("CANCEL");
            buttonUpdateClicked=true;
        }
        else {
            Sponsors s = new Sponsors();
            int i = getIndex(SponsSelect.getId());
            s.setId(Integer.valueOf(SponsSelect.getId()));
            s.setNom(add_spons_first.getText());
            s.setPrenom(add_spons_last.getText());
            s.setAdresse(add_spons_addr.getText());
            s.setMontantsponsoring(Integer.valueOf(add_spons_budg.getText()));
            s.setTel(Integer.valueOf(add_spons_numb.getText()));
            s.setNom_entreprise(add_spons_entr.getText());
            s.setTypeSponsoring(add_spons_type.getText());
           
            list.set(i, s);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked=false;
            buttonUpdateClicked=true;
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
                getClass().getResource("Oc.css").toExternalForm());

        alert.showAndWait();
    }

    @FXML
    private void HandleDelete(ActionEvent event) {
        Sponsors selectedProfil = add_table_view2.getSelectionModel().getSelectedItem();
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
        Sponsors in = new Sponsors();
        in.setId(Integer.valueOf(add_spons_id.getText()));
        in.setNom(add_spons_first.getText());
        in.setPrenom(add_spons_last.getText());
        in.setAdresse(add_spons_addr.getText());
        in.setMontantsponsoring(Integer.valueOf(add_spons_budg.getText()));
        in.setTel(Integer.valueOf(add_spons_numb.getText()));
        in.setTypeSponsoring(add_spons_type.getText());
        in.setNom_entreprise(add_spons_entr.getText());
       

        list.add(in);
        System.out.println("sponsor ajoutee");
        add_table_view2.refresh();
        add_spons_id.clear();
        add_spons_first.clear();
        add_spons_last.clear();
        add_spons_addr.clear();
        add_spons_budg.clear();
        add_spons_numb.clear();
        add_spons_type.clear();
        add_spons_entr.clear();
    }
    
    


    
    public int getIndexES (int id) {
        for (int i =0;i<list1.size();i++) {
            if (list1.get(i).getIdEq()==id)
                return i;
        }
        return list1.size();
    }
    
    public Sponsoring extractES (int i) {
        if (i>=0 && i<list1.size())
            return list1.get(i);
        else 
            return null;
    }
    
    @FXML
    private void handleClearES(ActionEvent event) {
        if (!buttonClearClicked1){
            add_team_spons_id.clear();
            add_team_spons_name.clear();
            add_team_spons_dom.clear();
            add_team_spons_sup.clear();
            add_team_spons_charge.clear();
            add_team_spons_nbr.clear();
            add_team_spons_Bud.clear();
            buttonClearClicked1=true;

        }
        else {
            Sponsoring SponsSelect = add_table_view1.getSelectionModel().getSelectedItem();
            int i = getIndexES(SponsSelect.getIdEq());
            SponsSelect.setIdEq(SponsSelect.getIdEq());
            SponsSelect.setNomEquipe(add_team_spons_name.getText());
            SponsSelect.setDomaine(add_team_spons_dom.getText());
            SponsSelect.setResponsable(add_team_spons_sup.getText());
            SponsSelect.setTypeSponsoring(add_team_spons_charge.getText());
            SponsSelect.setNombreMembres(Integer.valueOf(add_team_spons_nbr.getText()));
            SponsSelect.setBudget(Integer.valueOf(add_team_spons_Bud.getText()));
            
            list1.set(i, SponsSelect);
            add_update_btn1.setText("Update");
            add_clear_btn1.setText("Clear");
            buttonClearClicked1=false;
        }
    }

    @FXML
    private void handleUpdateES(ActionEvent event) {
        Sponsoring SponsSelect = add_table_view1.getSelectionModel().getSelectedItem();

    if (SponsSelect != null) {
        if (!buttonUpdateClicked1){
            add_team_spons_id.setText(String.valueOf(SponsSelect.getIdEq()));
            add_team_spons_name.setText(SponsSelect.getNomEquipe());
            add_team_spons_dom.setText(SponsSelect.getDomaine());
            add_team_spons_sup.setText(SponsSelect.getResponsable());
            add_team_spons_charge.setText(String.valueOf(SponsSelect.getTypeSponsoring()));
            add_team_spons_nbr.setText(String.valueOf(SponsSelect.getNombreMembres()));
            add_team_spons_Bud.setText(String.valueOf(SponsSelect.getBudget()));
            add_update_btn1.setText("SAVE");
            add_clear_btn1.setText("CANCEL");
            buttonUpdateClicked1=true;
        }
        else {
            Sponsoring s = new Sponsoring();
            int i = getIndexES(SponsSelect.getIdEq());
            s.setIdEq(SponsSelect.getIdEq());
            s.setNomEquipe(add_team_spons_name.getText());
            s.setDomaine(add_team_spons_dom.getText());
            s.setResponsable(add_team_spons_sup.getText());
            s.setTypeSponsoring(add_team_spons_charge.getText());
            s.setNombreMembres(Integer.valueOf(add_team_spons_nbr.getText()));
            s.setBudget(Integer.valueOf(add_team_spons_Bud.getText()));
           
            list1.set(i, s);
            add_update_btn1.setText("Update");
            add_clear_btn1.setText("Clear");
            buttonClearClicked1=false;
            buttonUpdateClicked1=true;
        }
    }
    }

    @FXML
    private void handleDeleteES(ActionEvent event) {
        Sponsoring selectedProfil = add_table_view1.getSelectionModel().getSelectedItem();
        if (selectedProfil != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Profil");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Profil?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // User clicked OK, remove the selected Donneur
                list1.remove(selectedProfil);
            }
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
    }

    @FXML
    private void handleAddES(ActionEvent event) {
        Sponsoring in = new Sponsoring();
        in.setIdEq(Integer.valueOf(add_team_spons_id.getText()));
        in.setNomEquipe(add_team_spons_name.getText());
        in.setDomaine(add_team_spons_dom.getText());
        in.setNombreMembres(Integer.valueOf(add_team_spons_nbr.getText()));
        in.setResponsable(add_team_spons_sup.getText());
        in.setTypeSponsoring(add_team_spons_charge.getText());
        in.setBudget(Integer.valueOf(add_team_spons_Bud.getText()));
       

        list1.add(in);
        System.out.println("Equipe Sponsoring ajoutee");
        add_table_view1.refresh();
        add_team_spons_id.clear();
        add_team_spons_name.clear();
        add_team_spons_dom.clear();
        add_team_spons_nbr.clear();
        add_team_spons_sup.clear();
        add_team_spons_charge.clear();
        add_team_spons_Bud.clear();
    }

    @FXML
    private void handleClearEL(ActionEvent event) {
        if (!buttonClearClicked2){
            add_log_id.clear();
            add_log_name.clear();
            add_team_log_dom.clear();
            add_team_log_sup.clear();
            add_team_log_nb.clear();
            add_team_log_mat.clear();
            add_team_log_charge.clear();
            buttonClearClicked2=true;

        }
        else {
            Logistique SponsSelect = add_table_view.getSelectionModel().getSelectedItem();
            int i = getIndexEL(SponsSelect.getIdEq());
            SponsSelect.setIdEq(SponsSelect.getIdEq());
            SponsSelect.setNomEquipe(add_log_name.getText());
            SponsSelect.setDomaine(add_team_log_dom.getText());
            SponsSelect.setResponsable(add_team_log_sup.getText());
            SponsSelect.setDomaineLogistique(add_team_log_charge.getText());
            SponsSelect.setNombreMembres(Integer.valueOf(add_team_log_nb.getText()));
            SponsSelect.setNombreMateriels(Integer.valueOf(add_team_log_mat.getText()));
            
            list2.set(i, SponsSelect);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked2=false;
            add_log_id.clear();
            add_log_name.clear();
            add_team_log_sup.clear();
            add_team_log_charge.clear();
            add_team_log_nb.clear();
            add_team_log_dom.clear();
            add_team_log_mat.clear();
        }
    }

    @FXML
    private void handleUpdateEL(ActionEvent event) {
        Logistique SponsSelect = add_table_view.getSelectionModel().getSelectedItem();

    if (SponsSelect != null) {
        if (!buttonUpdateClicked2){
            add_log_id.setText(String.valueOf(SponsSelect.getIdEq()));
            add_log_name.setText(SponsSelect.getNomEquipe());
            add_team_log_dom.setText(SponsSelect.getDomaine());
            add_team_log_sup.setText(SponsSelect.getResponsable());
            add_team_log_nb.setText(String.valueOf(SponsSelect.getNombreMembres()));
            add_team_log_mat.setText(String.valueOf(SponsSelect.getNombreMateriels()));
            add_team_log_charge.setText(SponsSelect.getDomaineLogistique());
            add_update_btn.setText("SAVE");
            add_clear_btn.setText("CANCEL");
            buttonUpdateClicked2=true;
            buttonClearClicked2=true;

        }
        else {
            Logistique s = new Logistique();
            int i = getIndexEL(SponsSelect.getIdEq());
            s.setIdEq(SponsSelect.getIdEq());
            s.setNomEquipe(add_log_name.getText());
            s.setDomaine(add_team_log_dom.getText());
            s.setResponsable(add_team_log_sup.getText());
            s.setDomaineLogistique(add_team_log_charge.getText());
            s.setNombreMembres(Integer.valueOf(add_team_log_nb.getText()));
            s.setNombreMateriels(Integer.valueOf(add_team_log_mat.getText()));
           
            list2.set(i, s);
            add_update_btn.setText("Update");
            add_clear_btn.setText("Clear");
            buttonClearClicked2=false;
            buttonUpdateClicked2=false;
            add_log_id.clear();
            add_log_name.clear();
            add_team_log_sup.clear();
            add_team_log_charge.clear();
            add_team_log_nb.clear();
            add_team_log_dom.clear();
            add_team_log_mat.clear();
        }
    }
    }
    
    public int getIndexEL (int id) {
        for (int i =0;i<list2.size();i++) {
            if (list2.get(i).getIdEq()==id)
                return i;
        }
        return list2.size();
    }
    
    public Logistique extractEL (int i) {
        if (i>=0 && i<list2.size())
            return list2.get(i);
        else 
            return null;
    }

    @FXML
    private void handleDeleteEL(ActionEvent event) {
        Logistique selectedProfil = add_table_view.getSelectionModel().getSelectedItem();
        if (selectedProfil != null) {
            // Show a confirmation dialog
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText("Supprimer Profil");
            alert.setContentText("Êtes-vous sûr de vouloir supprimer ce Profil?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // User clicked OK, remove the selected Donneur
                list2.remove(selectedProfil);
            }
        } else {
            showAlert("Aucun Profil sélectionné", "Veuillez sélectionner un Profil à supprimer.");
        }
    }

    @FXML
    private void handleAddEL(ActionEvent event) {
        Logistique in = new Logistique();
        in.setIdEq(Integer.valueOf(add_log_id.getText()));
        in.setNomEquipe(add_log_name.getText());
        in.setDomaine(add_team_log_dom.getText());
        in.setNombreMembres(Integer.valueOf(add_team_log_sup.getText()));
        in.setResponsable(add_team_log_charge.getText());
        in.setDomaineLogistique(add_team_log_nb.getText());
        in.setNombreMateriels(Integer.valueOf(add_team_log_mat.getText()));
       

        list2.add(in);
        System.out.println("Equipe Logistique ajoutee");
        add_table_view.refresh();
        add_log_id.clear();
        add_log_name.clear();
        add_team_log_sup.clear();
        add_team_log_charge.clear();
        add_team_log_nb.clear();
        add_team_log_dom.clear();
        add_team_log_mat.clear();
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
    

     
    
}
