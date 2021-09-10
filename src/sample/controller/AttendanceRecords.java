package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Evidencijarada;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AttendanceRecords implements Initializable {
    public TableView attendanceRecordsTable;
    public TableColumn firstName;
    public TableColumn lastName;
    public TableColumn jobTitle;
    public TableColumn timeIn;
    public TableColumn timeOut;
    public TableColumn date;
    public TableColumn inOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getRecords();
    }

    private void getRecords() {
        ObservableList<Evidencijarada> records = Evidencijarada.getAllAttendanceRecords();

        firstName.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("Ime"));
        lastName.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("Prezime"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("radnoMjesto"));
        timeIn.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("vrijemePocetka"));
        timeOut.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("vrijemeKraja"));
        date.setCellValueFactory(new PropertyValueFactory<Evidencijarada, Date>("datum"));
        inOut.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("inOut"));

        attendanceRecordsTable.setItems(records);
    }
}
