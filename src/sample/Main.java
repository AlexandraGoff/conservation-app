package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application {

//Method that displays the sample.fxml file with main menu options.
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/sample.fxml"));
        primaryStage.setTitle("Clyde Conservation Application");
        primaryStage.setScene(new Scene(root, 398, 400));
        primaryStage.show();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
