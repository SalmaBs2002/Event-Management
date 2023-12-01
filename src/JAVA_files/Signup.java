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
public class Signup extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the Signup.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Signup/signup.fxml"));
        Parent root = loader.load();

        // Set up the scene
        Scene scene = new Scene(root);

        // Set up the stage
        primaryStage.setTitle("Signup Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}