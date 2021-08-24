package sample.controller;

import eu.hansolo.medusa.Clock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Clock clock;
    @FXML
    private Button btnAdministration;
    @FXML
    private Button btnUsers;


    public void handleBtnAdministration(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("view/AdminLogin.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Time & Attendance System - Administration");
        primaryStage.setScene(new Scene(root, 400, 375));
        // specifies modality
        primaryStage.initModality(Modality.WINDOW_MODAL); // default
        primaryStage.show();
    }

    public void handleBtnUsers(ActionEvent actionEvent) {
        System.out.println("Button Korisnici clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clock.setSkinType(Clock.ClockSkinType.SLIM);
        clock.setPrefSize(174, 174);
        clock.setRunning(true);
    }
}
