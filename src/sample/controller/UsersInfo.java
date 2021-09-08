package sample.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.model.UsersInfoModel;

import javax.jws.soap.SOAPBinding;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersInfo implements Initializable {
    @FXML
    TableView tableUsers;
    @FXML
    TableColumn name;
    @FXML
    TableColumn lastName;
    @FXML
    TableColumn jobTitle;
    @FXML
    TableColumn userID;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getUserInfo();

    }

    public void getUserInfo(){
        ObservableList<UsersInfoModel> usersInfo = UsersInfoModel.getUsersInfo();
        name.setCellValueFactory(new PropertyValueFactory<UsersInfoModel,String>("UserName"));
        lastName.setCellValueFactory(new PropertyValueFactory<UsersInfoModel,String>("UserLastName"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<UsersInfoModel,String>("JobTitle"));
        tableUsers.setItems(usersInfo);
        addButtonToTable();

    }

    private void addButtonToTable() {
        TableColumn<UsersInfoModel, Void> colBtn = new TableColumn("Detalji");

        Callback<TableColumn<UsersInfoModel, Void>, TableCell<UsersInfoModel, Void>> cellFactory = new Callback<TableColumn<UsersInfoModel, Void>, TableCell<UsersInfoModel, Void>>() {
            @Override
            public TableCell<UsersInfoModel, Void> call(final TableColumn<UsersInfoModel, Void> param) {
                final TableCell<UsersInfoModel, Void> cell = new TableCell<UsersInfoModel, Void>() {

                    private final Button btn = new Button("Detalji");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            UsersInfoModel data = getTableView().getItems().get(getIndex());
                            System.out.println("selectedData: " + data.getUserID());///Dodat akciju
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableUsers.getColumns().add(colBtn);

    }
}
