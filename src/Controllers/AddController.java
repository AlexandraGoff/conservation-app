package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class AddController {

    @FXML private Button returnBtn;
    @FXML private Button animalBtn;
    @FXML private Button keeperBtn;
    @FXML private Button cageBtn;

    public static String getChoice() {
        return choice;
    }

    private static String choice;

    //Initialize() is called in every controller class for event handlers to be able to work with buttons.
    public void initialize() {

        //Event handlers in lamba that handle different buttons being clicked.
        animalBtn.setOnAction(event -> {
            choice = "animal";

            //loads fxml file.
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/detailsScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();

        });


        keeperBtn.setOnAction(event -> {
            choice = "keeper";
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/detailsScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();


        });

        cageBtn.setOnAction(event -> {
            choice = "cage";
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/detailsScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();

        });

        returnBtn.setOnAction(event -> {

            //Return to previous screen
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();
        });


    }
}
