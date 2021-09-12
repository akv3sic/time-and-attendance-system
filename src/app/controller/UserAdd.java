package app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import app.helpers.PushNotifications;
import app.model.Korisnici;
import app.model.Radnomjesto;
import app.model.Role;

import java.net.URL;
import java.util.ResourceBundle;

public class UserAdd implements Initializable {

    public AnchorPane mainAP;

    @FXML
    TextField nameTxt , lastNameTxt , phoneTxt , passTxt , emailTxt , rfidTxt;

    @FXML
    ChoiceBox<String> workplaceCB;
    @FXML
    ChoiceBox<String> roleCB;
    PushNotifications notifications;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    getWorkplaces();
    getRoles();
    notifications = new PushNotifications();
    }

    public void getRoles(){
        ObservableList<String> roles = Role.getRoleNames();
        roleCB.getItems().addAll(roles);

    }

    public void getWorkplaces(){
        ObservableList<String> workplaces = Radnomjesto.getWorkplaceNames();

        workplaceCB.getItems().addAll(workplaces);

    }




    public void handleAddUser(ActionEvent actionEvent) {
        Korisnici user = new Korisnici(
                nameTxt.getText(),
                lastNameTxt.getText(),
                phoneTxt.getText(),
                roleCB.getSelectionModel().getSelectedItem(),
                workplaceCB.getSelectionModel().getSelectedItem(),
                passTxt.getText(),
                emailTxt.getText(),
                rfidTxt.getText()


        );
        if(Korisnici.addUser(user)) {
            notifications.showNotification("STANDARD", "Obavijest", "Uspjeh",  "Korisnik " + nameTxt.getText() +
                                                " " + lastNameTxt.getText() + " dodan.");
        }
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");

        mainAP.getChildren().clear();
        mainAP.getChildren().add(view);





    }
}
