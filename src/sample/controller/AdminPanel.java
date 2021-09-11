package sample.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import sample.model.UsersInfoModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static sample.model.UsersInfoModel.getUsersInfo;

public class AdminPanel implements Initializable {
    public MFXButton btnKorisnici;
    public ImageView userIconBtn;

    @FXML
    public BorderPane mainPane;





    public void initialize(URL url, ResourceBundle resourceBundle) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainPane.setCenter(view);



    }



    public void handleBtnKorisnici(ActionEvent actionEvent){

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("UsersInfoTable");
        mainPane.setCenter(view);


    }


    public void handleBtnRadnaMjesta(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");
        mainPane.setCenter(view);
    }

    public void handleBtnEvidencija(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("AttendanceRecords");
        mainPane.setCenter(view);
    }

    public BorderPane getPane() {
        return mainPane;

    }
}
