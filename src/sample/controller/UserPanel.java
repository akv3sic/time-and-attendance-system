package sample.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.Main;
import sample.model.Korisnici;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPanel implements Initializable {
    @FXML
    BorderPane mainPane;

    private IntegerProperty idProp = new SimpleIntegerProperty();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    public  UserPanel(int id){
        idProp.setValue(id);

    }


    public void handleBtnUserData(ActionEvent actionEvent) throws IOException {
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

    public void handleBtnUserEvidencija(ActionEvent actionEvent) {
    }


}
