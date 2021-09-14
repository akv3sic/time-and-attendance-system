package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import app.helpers.PushNotifications;
import app.helpers.Rfid;
import java.sql.SQLException;


public class Main extends Application {

    private String buffer;
    PushNotifications notifications;

    @Override
    public void start(Stage primaryStage) throws Exception{
        buffer = "";
        notifications = new PushNotifications();
        Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));

        primaryStage.setTitle("Time & Attendance System");
        primaryStage.getIcons().add(new Image("./assets/logo.png"));
        primaryStage.setScene(new Scene(root, 600, 575));

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            //System.out.println("Key pressed: " + event.toString());
            buffer = buffer + event.getText();
            //System.out.println(buffer);
            switch(event.getCode()) {
                case F5: { // F5 key -> go to full screen
                    primaryStage.setFullScreen(!primaryStage.isFullScreen());
                    break;
                }
                case ENTER: { // Enter -> activate RFID processing chain
                    //System.out.println("Enter clicked");
                    try {
                        handleRfidEvent();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    clearBuffer();
                }
                default:  {
                    //System.out.println("Unrecognized key");
                }
            }
        });

        primaryStage.requestFocus();
        primaryStage.show();
    }

    private void clearBuffer() {
        buffer = "";
    }

    /*
    IN  ---- 1
    OUT ---- 0
    */
    private void handleRfidEvent() throws SQLException {
        if(isBufferValid()) {
            Rfid rfid = new Rfid(buffer);
            if(rfid.isCardRegistered()) {
                if(rfid.saveRecord() == 1) {
                    // IN notification
                    notifications.showNotification("IN", rfid.getFirstName(), rfid.getLastName(), rfid.getTime());
                }
                else {
                    // OUT notification
                    notifications.showNotification("OUT", rfid.getFirstName(), rfid.getLastName(), rfid.getTime());
                }
            }
            else {
                // INVALID CARD notification
                notifications.showNotification("INVALIDCARD");
            }
        }
    }

    private boolean isBufferValid() {
        try {
            this.buffer = buffer.substring(0,10);
            if (buffer.length() == 10 && buffer.matches("\\d{10}")) {
                return true;
            }
        }
        catch (Exception ex){
            System.out.println("RFID buffer greška: " + ex);
        }
        return false;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
