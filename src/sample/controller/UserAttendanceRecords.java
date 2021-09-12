package sample.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.Evidencijarada;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class UserAttendanceRecords implements Initializable {

    private IntegerProperty idProp = new SimpleIntegerProperty();



    public UserAttendanceRecords(int id){

        idProp.setValue(id);



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getRecords(java.sql.Date.valueOf(LocalDate.now()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        refreshBtn.setOnAction((ActionEvent event) -> {
            try {
                handleRefreshBtn();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

    }
    @FXML
    MFXButton refreshBtn;
    @FXML
    MFXDatePicker datePicker;
    @FXML
    TableView attendanceRecordsTable;
    @FXML
    TableColumn timeIn, timeOut, date;
    private void getRecords() throws SQLException {
        ObservableList<Evidencijarada> records = Evidencijarada.getAllAttendanceRecords(idProp.getValue());


        timeIn.setCellValueFactory(new PropertyValueFactory<Evidencijarada, String>("vrijemePocetka"));
        timeOut.setCellValueFactory(new PropertyValueFactory<Evidencijarada, String>("vrijemeKraja"));
        date.setCellValueFactory(new PropertyValueFactory<Evidencijarada, Date>("datum"));

        attendanceRecordsTable.setItems(records);
    }

    private void getRecords(Date pickedDate) throws SQLException {
        try {
            ObservableList<Evidencijarada> records = Evidencijarada.getAllAttendanceRecords((java.sql.Date) pickedDate, idProp.getValue());


            timeIn.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("vrijemePocetka"));
            timeOut.setCellValueFactory(new PropertyValueFactory<Evidencijarada,String>("vrijemeKraja"));
            date.setCellValueFactory(new PropertyValueFactory<Evidencijarada, Date>("datum"));

            attendanceRecordsTable.setItems(records);
        }
        catch (SQLException ex) {
            System.out.println("Greška: " + ex);
        }

    }

    public void handleRefreshBtn() throws SQLException {
        try {
            LocalDate date = datePicker.getDate();
            if(date == null){
                date = LocalDate.now();
            }
            getRecords(java.sql.Date.valueOf(date));
        }
        catch (SQLException ex) {
            System.out.println("Greška: " + ex);
        }
    }



}
