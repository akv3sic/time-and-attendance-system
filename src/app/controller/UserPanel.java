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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import app.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPanel implements Initializable {
    @FXML
    BorderPane mainPane;
    @FXML
    MFXButton btnUserData, btnUserEvidencija;
    @FXML
    Label userNameLabel;

    private IntegerProperty idProp = new SimpleIntegerProperty();
    private String userFirstName = new String();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set user label text
        userNameLabel.setText(userFirstName);
        btnUserData.setOnAction((ActionEvent event) -> {
            try {
                handleBtnUserData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnUserEvidencija.setOnAction((ActionEvent event) -> {
            handleBtnUserEvidencija();
        });

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserEdit.fxml"));
        UserSelfUpdate controller=new UserSelfUpdate(idProp.getValue());
        loader.setController(controller);
        try{
            AnchorPane ap = loader.load();
            mainPane.setCenter(ap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UserPanel(int idProp, String userFirstName) {
        this.idProp.setValue(idProp);
        this.userFirstName = userFirstName;
    }

    public void handleBtnUserData() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserEdit.fxml"));
        UserSelfUpdate controller=new UserSelfUpdate(idProp.getValue());
        loader.setController(controller);
        try{
            AnchorPane ap = loader.load();
            mainPane.setCenter(ap);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void handleBtnUserEvidencija() {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserAttendanceRecords.fxml"));
        UserAttendanceRecords controller=new UserAttendanceRecords(idProp.getValue());
        loader.setController(controller);
        try{
            AnchorPane ap = loader.load();
            mainPane.setCenter(ap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
