package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Radnomjesto;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkplacesOverview implements Initializable {
    public TableColumn workplace;
    public TableColumn hourRate;
    public TableView tableWorkplaces;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getWorkplacesOverview();
    }

    private void getWorkplacesOverview() {
        ObservableList<Radnomjesto> workplaces = Radnomjesto.getWorkplaces();
        workplace.setCellValueFactory(new PropertyValueFactory<Radnomjesto, String>("ImeRadnogMjesta"));
        hourRate.setCellValueFactory(new PropertyValueFactory<Radnomjesto, String>("Satnica"));

        tableWorkplaces.setItems(workplaces);
    }
}
