package app.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import app.Main;
import app.helpers.PushNotifications;
import app.model.Korisnici;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSelfUpdate implements Initializable {
    private IntegerProperty idProp = new SimpleIntegerProperty();
    private StringProperty nameString = new SimpleStringProperty();
    private StringProperty lastNameString = new SimpleStringProperty();
    private StringProperty phoneString = new SimpleStringProperty();
    private StringProperty passString = new SimpleStringProperty();
    private StringProperty emailString = new SimpleStringProperty();
    @FXML
    AnchorPane mainAP;
    @FXML
    Label nameTxt, lastNameTxt;
    @FXML
    TextField phoneTxt , emailTxt;
    @FXML
    PasswordField passTxt;
    @FXML
    MFXButton btnUpdate;
    PushNotifications notifications;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        notifications = new PushNotifications();
        nameTxt.setText(nameString.get());
        lastNameTxt.setText(lastNameString.get());
        phoneTxt.setText(phoneString.get());
        passTxt.setText(passString.get());
        emailTxt.setText(emailString.get());
        btnUpdate.setOnAction((ActionEvent event) -> {
            handleBtnUpdate();

        });;

    }

    private void handleBtnUpdate() {
        Korisnici user = new Korisnici(phoneTxt.getText(), emailTxt.getText(), passTxt.getText());
        if(Korisnici.userSelfUpdate(idProp.getValue(), user)) {
           notifications.showNotification("STANDARD", "Obavijest", "Uspjeh",  nameString.get() + ", Vaši podatci su spremljeni.");
        }
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserEdit.fxml"));
        UserSelfUpdate controller=new UserSelfUpdate(idProp.getValue());
        loader.setController(controller);
        try{
            AnchorPane ap = loader.load();
            mainAP.getChildren().clear();
            mainAP.getChildren().addAll(ap.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserSelfUpdate(int id){
        idProp.setValue(id);
        Korisnici user=Korisnici.getUser(id);
        nameString.setValue(user.getIme());
        lastNameString.setValue(user.getPrezime());
        phoneString.setValue(user.getKontaktBroj());
        emailString.setValue(user.getEmail());
        passString.setValue(user.getPassword());





    }
}
