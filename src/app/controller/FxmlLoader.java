package app.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import app.Main;

import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPane(String fileName){

        try{
            URL fileUrl = Main.class.getResource("view/"+fileName+".fxml");
            if(fileUrl == null){
                throw new java.io.FileNotFoundException("FXML file can not be found!");
            }
            view =new FXMLLoader().load(fileUrl);
        }

        catch (Exception e){
            System.out.println(e);
        }

        return view;





    }
}