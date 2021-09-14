package app.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import app.helpers.PushNotifications;
import app.model.Radnomjesto;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewWorkplace implements Initializable {
    public AnchorPane workplaces;
    public MFXButton backBtn;
    public TextField workplaceNameField;
    public TextField hourRateField;
    public MFXButton addNewBtn;
    public Label errorLabel;
    PushNotifications notifications;

    public void handleBackBtn(ActionEvent actionEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");

        workplaces.getChildren().clear();
        workplaces.getChildren().add(view);
    }

    public void handleAddNewBtn(ActionEvent actionEvent) {
        String workPlace = workplaceNameField.getText();
        String  hourRate = hourRateField.getText();
        if(workPlace == "" || hourRate == "") {
            errorLabel.setText("Obavezno polje.");
        }
        else {
            Radnomjesto rm = new Radnomjesto(workplaceNameField.getText(), Double.parseDouble(hourRateField.getText()));
            if(rm.createWorkplace()) {
                notifications.showNotification("STANDARD", "Obavijest", "Uspjeh",  "Radno mjesto " + workplaceNameField.getText() + " dodano");
            }
            clearFields();
            loadWorkplacesOverview();
        }
    }

    private void loadWorkplacesOverview() {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPane("WorkplacesOverview");

        workplaces.getChildren().clear();
        workplaces.getChildren().add(view);
    }

    private void clearFields() {
        this.workplaceNameField.clear();
        this.hourRateField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        notifications = new PushNotifications();
    }
}
