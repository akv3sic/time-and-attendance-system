package app.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import app.model.Radnomjesto;

import java.net.URL;
import java.util.ResourceBundle;

public class WorkplacesOverview implements Initializable{
    public TableColumn workplace;
    public TableColumn hourRate;
    public TableView tableWorkplaces;
    public MFXButton trashBtn;
    public AnchorPane workplaces;
    public MFXButton addNewBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getWorkplacesOverview();
        addDeleteButtonToTable();
    }

    private void getWorkplacesOverview() {
        ObservableList<Radnomjesto> workplaces = Radnomjesto.getWorkplaces();
        workplace.setCellValueFactory(new PropertyValueFactory<Radnomjesto, String>("ImeRadnogMjesta"));
        hourRate.setCellValueFactory(new PropertyValueFactory<Radnomjesto, String>("Satnica"));

        tableWorkplaces.setItems(workplaces);
    }

    private void addDeleteButtonToTable() {
        TableColumn<Radnomjesto, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Radnomjesto, Void>, TableCell<Radnomjesto, Void>> cellFactory = new Callback<TableColumn<Radnomjesto, Void>, TableCell<Radnomjesto, Void>>() {
            @Override
            public TableCell<Radnomjesto, Void> call(final TableColumn<Radnomjesto, Void> param) {
                final TableCell<Radnomjesto, Void> cell = new TableCell<Radnomjesto, Void>() {

                    private final Button btn = new Button("Izbriši");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Radnomjesto radnomjesto = getTableView().getItems().get(getIndex());
                            System.out.println("Selected for deleting: " + radnomjesto.getRadnoMjestoId());
                            radnomjesto.deleteWorkplace(radnomjesto.getRadnoMjestoId());
                            getWorkplacesOverview();
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

        tableWorkplaces.getColumns().add(colBtn);

    }


    public void handleTrashBtn(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("DeletedWorkplacesOverview");

        workplaces.getChildren().clear();
        workplaces.getChildren().addAll(view.getChildren());
    }

    public void handleAddNewBtn(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("AddNewWorkplace");

        workplaces.getChildren().clear();
        workplaces.getChildren().addAll(view.getChildren());
    }
}
