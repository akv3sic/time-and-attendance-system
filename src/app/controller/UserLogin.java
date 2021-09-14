package app.controller;

import app.helpers.Email;
import app.helpers.PushNotifications;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import app.Main;
import app.model.LoggedInModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin implements Initializable {
    public Label errorLabel;
    @FXML
    AnchorPane mainAP;
    @FXML
    TextField emailTxt;
    @FXML
    PasswordField passTxt;
    Email eMailHelper;
    PushNotifications notifications;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eMailHelper = new Email();
        notifications = new PushNotifications();
    }

    public void handleBtnLogin(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        String email = emailTxt.getText();
        String pass = passTxt.getText();

        // e-mail and password validation
        if (email.equals("") || pass.equals("")){
            errorLabel.setText("Potrebno je popuniti oba polja.");
        }
        else if(eMailHelper.isValid(email)){
            LoggedInModel user = LoggedInModel.login(email, pass);
            if(user == null) {
                errorLabel.setText("Pogrešan e-mail ili lozinka!");
            }
            else if(user.isLogged){
                // fire success notification
                notifications.showNotification("STANDARD", "Uspješna prijava", "Pozdrav " + user.userName + "!", "Lijepo je vidjeti Vas opet.");
                // load user account
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserDash.fxml"));
                UserPanel controller = new UserPanel(user.userID);
                loader.setController(controller);
                try {
                    AnchorPane ap = loader.load();
                    mainAP.getChildren().clear();
                    mainAP.getChildren().add(ap);
                    // set appropriate stage size
                    stage.setWidth(800);
                    stage.setHeight(650);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                errorLabel.setText("Izgleda da je došlo do pogreške.");
            }
        }
        else {
            errorLabel.setText("E-adresa nije valjana.");
        }
}}
