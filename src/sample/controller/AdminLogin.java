package sample.controller;

import com.mysql.cj.log.Log;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import javafx.scene.control.Alert.AlertType;
import sample.model.LoggedInModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLogin implements Initializable  {

    public MFXButton btnLogin;

    @FXML
    TextField emailTxt;
    @FXML
    PasswordField passTxt;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleBtnLogin(ActionEvent e) throws IOException {

        String email = emailTxt.getText();
        String pass = passTxt.getText();

        //String email = "vjeko@gmail.com";
        //String pass = "password123";

        if (email.equals("")||pass.equals("")){

            System.out.println("Morate unijeti sve vrijednosti!!");
        }
        else{
            LoggedInModel user = LoggedInModel.login(email, pass);
            if(user.isLogged && user.isAdmin){
                System.out.println("Pozdrav"+ user.userName + "!  Uspješno ste se prijavili u admin panel");

            }

            else if (user.isLogged && (user.isAdmin==false) ){
                System.out.println("Nemate pristup administraciji!!");
            }

            else {
                System.out.println("Netočan email ili lozinka!!");

            }


        }


    }
}
