package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.helpers.Rfid;

import java.sql.SQLException;


public class Main extends Application {

    private String buffer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        buffer = "";

        Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));

        primaryStage.setTitle("Time & Attendance System");
        primaryStage.getIcons().add(new Image("./assets/logo.png"));
        primaryStage.setScene(new Scene(root, 600, 575));

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            //System.out.println("Key pressed: " + event.toString());
            buffer = buffer + event.getText();
            //System.out.println(buffer);
            switch(event.getCode()) {
                case ESCAPE: { // 27 = ESC key -> close stage
                    primaryStage.close();
                    break;
                }
                case ENTER: { // 10 = Enter -> activate RFID processing chan
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

    private void handleRfidEvent() throws SQLException {
        if(isBufferValid()) {
            Rfid rfid = new Rfid(buffer);
            if(rfid.isCardRegistered()) {
                rfid.saveRecord();
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
