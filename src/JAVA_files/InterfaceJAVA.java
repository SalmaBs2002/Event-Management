/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JAVA_files;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class InterfaceJAVA extends Application {

    @Override
   public void start(Stage stage) throws Exception{
        
            Parent root = FXMLLoader.load(getClass().getResource("InterfaceJAVA.fxml"));
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
       
    }

    public static void main(String[] args) {
        launch(args);
    }
}
