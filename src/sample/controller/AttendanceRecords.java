package sample.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Evidencijarada;
import java.net.URL;
import java.sql.SQLException;
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
    public MFXDatePicker datePicker;
    public MFXButton refreshBtn;

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

    private void getRecords(Date pickedDate) throws SQLException {
        try {
            ObservableList<Evidencijarada> records = Evidencijarada.getAllAttendanceRecords((java.sql.Date) pickedDate);

            firstName.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("Ime"));
            lastName.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("Prezime"));
            jobTitle.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("radnoMjesto"));
            timeIn.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("vrijemePocetka"));
            timeOut.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("vrijemeKraja"));
            date.setCellValueFactory(new PropertyValueFactory<Evidencijarada, Date>("datum"));
            inOut.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("inOut"));

            attendanceRecordsTable.setItems(records);
        }
        catch (SQLException ex) {
            System.out.println("Greška: " + ex);
        }

    }

    public void handleRefreshBtn(ActionEvent actionEvent) throws SQLException {
        try {
            getRecords(java.sql.Date.valueOf(datePicker.getDate()));
        }
        catch (SQLException ex) {
            System.out.println("Greška: " + ex);
        }

    }
}
