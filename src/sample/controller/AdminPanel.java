package sample.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import sample.model.UsersInfoModel;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.model.UsersInfoModel.getUsersInfo;

public class AdminPanel implements Initializable {



    public MFXButton btnKorisnici;
    @FXML
    private BorderPane mainPane;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainPane.setCenter(view);



    }




    public void handleBtnKorisnici(){

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainPane.setCenter(view);


    }


    public void handleBtnRadnaMjesta(ActionEvent actionEvent) {
    }

    public void handleBtnEvidencija(ActionEvent actionEvent) {
    }
}
