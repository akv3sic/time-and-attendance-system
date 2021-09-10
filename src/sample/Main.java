package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    private String rfid;

    @Override
    public void start(Stage primaryStage) throws Exception{
        rfid = "";

        Parent root = FXMLLoader.load(getClass().getResource("view/Home.fxml"));

        primaryStage.setTitle("Time & Attendance System");
        primaryStage.getIcons().add(new Image("./assets/logo.png"));
        primaryStage.setScene(new Scene(root, 600, 575));
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED,  (event) -> {
            System.out.println("Key pressed: " + event.toString());
            rfid = rfid + event.getText();
            System.out.println(rfid);
            switch(event.getCode().getCode()) {
                case 27 : { // 27 = ESC key
                    primaryStage.close();
                    break;
                }
                case 10 : { // 10 = Return
                    System.out.println("Enter clicked");
                    rfid = "";
                }
                default:  {
                    System.out.println("Unrecognized key");
                }
            }
        });

        primaryStage.requestFocus();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
