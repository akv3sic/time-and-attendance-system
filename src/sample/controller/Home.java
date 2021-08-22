package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;

public class Home {
    @FXML
    private Button btnAdministration;
    @FXML
    private Button btnUsers;


    public void handleBtnAdministration(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("view/AdminLogin.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Time & Attedndance System - Administration");
        primaryStage.setScene(new Scene(root, 400, 375));
        // specifies modality
        primaryStage.initModality(Modality.WINDOW_MODAL); // default
        primaryStage.show();
    }

    public void handleBtnUsers(ActionEvent actionEvent) {
        System.out.println("Button Korisnici clicked");
    }
}
