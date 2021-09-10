package sample.controller;

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
import sample.model.Radnomjesto;

import java.net.URL;
import java.util.ResourceBundle;

public class DeletedWorkplacesOverview implements Initializable {
    public TableView tableWorkplaces;
    public TableColumn workplace;
    public TableColumn hourRate;
    public AnchorPane workplaces;
    public MFXButton backBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getWorkplacesOverview();
        addRestoreButtonToTable();
    }

    private void getWorkplacesOverview() {
        ObservableList<Radnomjesto> workplaces = Radnomjesto.getDeletedWorkplaces();
        workplace.setCellValueFactory(new PropertyValueFactory<Radnomjesto, String>("ImeRadnogMjesta"));
        hourRate.setCellValueFactory(new PropertyValueFactory<Radnomjesto, String>("Satnica"));

        tableWorkplaces.setItems(workplaces);
    }

    private void addRestoreButtonToTable() {
        TableColumn<Radnomjesto, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Radnomjesto, Void>, TableCell<Radnomjesto, Void>> cellFactory = new Callback<TableColumn<Radnomjesto, Void>, TableCell<Radnomjesto, Void>>() {
            @Override
            public TableCell<Radnomjesto, Void> call(final TableColumn<Radnomjesto, Void> param) {
                final TableCell<Radnomjesto, Void> cell = new TableCell<Radnomjesto, Void>() {

                    private final Button btn = new Button("Vrati");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Radnomjesto radnomjesto = getTableView().getItems().get(getIndex());
                            System.out.println("Selected for restoring: " + radnomjesto.getRadnoMjestoId());
                            radnomjesto.restoreWorkplace(radnomjesto.getRadnoMjestoId());
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

    public void handleBackBtn(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");

        workplaces.getChildren().clear();
        workplaces.getChildren().add(view);
    }
}
