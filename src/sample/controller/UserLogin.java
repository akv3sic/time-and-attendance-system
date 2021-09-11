package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;
import sample.model.LoggedInModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLogin implements Initializable {
    @FXML
    AnchorPane mainAP;
    @FXML
    TextField emailTxt;
    @FXML
    PasswordField passTxt;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleBtnLogin(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        String email = emailTxt.getText();
        String pass = passTxt.getText();

        if (email.equals("")||pass.equals("")){

            System.out.println("Morate unijeti sve vrijednosti!!");
        }
        else{
            LoggedInModel user = LoggedInModel.login(email, pass);
            if(user.isLogged){
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserDash.fxml"));
                UserPanel controller = new UserPanel(user.userID);
                loader.setController(controller);
                try {
                    AnchorPane ap = loader.load();
                    mainAP.getChildren().clear();
                    mainAP.getChildren().add(ap);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            else {
                System.out.println("Netočan email ili lozinka!!");

            }

    }
}}
