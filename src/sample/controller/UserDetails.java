package sample.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sample.model.Korisnici;
import sample.model.Radnomjesto;
import sample.model.Role;

import java.net.URL;
import java.util.ResourceBundle;

public class UserDetails implements Initializable {
    private IntegerProperty idProp = new SimpleIntegerProperty();
    private StringProperty nameString = new SimpleStringProperty();
    private StringProperty lastNameString = new SimpleStringProperty();
    private StringProperty phoneString = new SimpleStringProperty();
    private StringProperty passString = new SimpleStringProperty();
    private StringProperty emailString = new SimpleStringProperty();
    private StringProperty rfidString = new SimpleStringProperty();
    private StringProperty workplaceString = new SimpleStringProperty();
    private StringProperty roleString = new SimpleStringProperty();

    @FXML
     AnchorPane mainAP;

     @FXML
     MFXButton btnUpdate;



    @FXML
    TextField nameTxt , lastNameTxt , phoneTxt , passTxt , emailTxt , rfidTxt;

    @FXML
    ChoiceBox<String> workplaceCB;
    @FXML
    ChoiceBox<String> roleCB;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getWorkplaces();
        getRoles();
        nameTxt.setText(nameString.get());
        lastNameTxt.setText(lastNameString.get());
        phoneTxt.setText(phoneString.get());
        passTxt.setText(passString.get());
        emailTxt.setText(emailString.get());
        rfidTxt.setText(rfidString.get());
        workplaceCB.setValue(workplaceString.get());
        roleCB.setValue(roleString.get());
        btnUpdate.setOnAction((ActionEvent event) -> {
            handleBtnUpdate();

        });
    }

    public UserDetails (int id){
        System.out.println(id);
        initUser(id);
        idProp.set(id);


    }
    public void initUser(int id){
        Korisnici user = Korisnici.getUser(id);



        nameString.set(user.getIme());
        lastNameString.set(user.getPrezime());
        phoneString.set(user.getKontaktBroj());
        passString.set(user.getPassword());
        emailString.set(user.getEmail());
        rfidString.set(user.getRfid());
        workplaceString.set(user.getRadnoMjesto());
        roleString.set(user.getRole());





    }

    public void getRoles(){
        ObservableList<String> roles = Role.getRoleNames();
        roleCB.getItems().addAll(roles);

    }

    public void getWorkplaces(){
        ObservableList<String> workplaces = Radnomjesto.getWorkplaceNames();

        workplaceCB.getItems().addAll(workplaces);

    }

    public void handleBtnUpdate(){
        Korisnici user = new Korisnici();
        user.setIme(nameTxt.getText());
        user.setPrezime(lastNameTxt.getText());
        user.setEmail(emailTxt.getText());
        user.setRadnoMjesto(workplaceCB.getValue());
        user.setRole(roleCB.getValue());
        user.setPassword(passTxt.getText());
        user.setKontaktBroj(phoneTxt.getText());
        user.setRfid(rfidTxt.getText());
        Korisnici.updateUser(user, idProp.getValue());

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainAP.getChildren().clear();
        mainAP.getChildren().add(view);


    }




}
