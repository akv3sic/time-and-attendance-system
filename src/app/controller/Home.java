package app.controller;

import eu.hansolo.medusa.Clock;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import app.Main;
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
        primaryStage.getIcons().add(new Image("./assets/logo.png"));
        primaryStage.setScene(new Scene(root, 570, 500));
        // specifies modality
        primaryStage.initModality(Modality.WINDOW_MODAL); // default
        primaryStage.show();
    }

    public void handleBtnUsers(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Main.class.getResource("view/UserLogin.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Time & Attendance System - Korisnici");
        primaryStage.getIcons().add(new Image("./assets/logo.png"));
        primaryStage.setScene(new Scene(root, 570, 500));
        primaryStage.initModality(Modality.WINDOW_MODAL); // default
        primaryStage.show();



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clock.setSkinType(Clock.ClockSkinType.SLIM);
        clock.setPrefSize(174, 174);
        clock.setRunning(true);

        // remove focus from buttons
        btnAdministration.setFocusTraversable(false);
        btnUsers.setFocusTraversable(false);
    }
}
