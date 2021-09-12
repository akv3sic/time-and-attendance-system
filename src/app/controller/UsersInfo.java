package app.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import app.Main;
import app.model.UsersInfoModel;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class UsersInfo implements Initializable {

    public UsersInfo(){

    }
    @FXML
    AnchorPane mainAP;
    @FXML
    TableView tableUsers;
    @FXML
    TableColumn name;
    @FXML
    TableColumn lastName;
    @FXML
    TableColumn jobTitle;



    public MFXButton btnAddUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getUserInfo();

    }

    public void handleBtnAddUser() {

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("AddUser");

        mainAP.getChildren().clear();
        mainAP.getChildren().add(view);




    }

    public void getUserInfo(){
        ObservableList<UsersInfoModel> usersInfo = UsersInfoModel.getUsersInfo();
        name.setCellValueFactory(new PropertyValueFactory<UsersInfoModel,String>("UserName"));
        lastName.setCellValueFactory(new PropertyValueFactory<UsersInfoModel,String>("UserLastName"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<UsersInfoModel,String>("JobTitle"));
        tableUsers.setItems(usersInfo);
        addButtonDetails();
        addButtonDelete(usersInfo);

    }

    private void addButtonDetails() {
        TableColumn<UsersInfoModel, Void> colBtnDetails = new TableColumn("Detalji");

        Callback<TableColumn<UsersInfoModel, Void>, TableCell<UsersInfoModel, Void>> cellFactory = new Callback<TableColumn<UsersInfoModel, Void>, TableCell<UsersInfoModel, Void>>() {
            @Override
            public TableCell<UsersInfoModel, Void> call(final TableColumn<UsersInfoModel, Void> param) {
                final TableCell<UsersInfoModel, Void> cell = new TableCell<UsersInfoModel, Void>() {

                    private final Button btn = new Button("Detalji");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            UsersInfoModel data = getTableView().getItems().get(getIndex());
                            FXMLLoader loader = new FXMLLoader(Main.class.getResource("view/UserDetails.fxml"));
                            UserDetails controller = new UserDetails(data.getUserID());
                            loader.setController(controller);
                            try {
                                AnchorPane ap = loader.load();
                                mainAP.getChildren().clear();
                                mainAP.getChildren().add(ap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


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

        colBtnDetails.setCellFactory(cellFactory);

        tableUsers.getColumns().add(colBtnDetails);

    }

    private void addButtonDelete(ObservableList<UsersInfoModel> usersInfo) {
        TableColumn<UsersInfoModel, Void> colBtnDel = new TableColumn();

        Callback<TableColumn<UsersInfoModel, Void>, TableCell<UsersInfoModel, Void>> cellFactory = new Callback<TableColumn<UsersInfoModel, Void>, TableCell<UsersInfoModel, Void>>() {
            @Override
            public TableCell<UsersInfoModel, Void> call(final TableColumn<UsersInfoModel, Void> param) {
                final TableCell<UsersInfoModel, Void> cell = new TableCell<UsersInfoModel, Void>() {

                    private final Button btn = new Button("Izbriši");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            UsersInfoModel data = getTableView().getItems().get(getIndex());
                            UsersInfoModel.deleteUser(data.getUserID());
                            usersInfo.remove(data);





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

        colBtnDel.setCellFactory(cellFactory);

        tableUsers.getColumns().add(colBtnDel);

    }
}

