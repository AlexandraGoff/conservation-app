package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class SearchChoiceController {

    @FXML private Button returnBtn;
    @FXML private Button animalBtn;
    @FXML private Button keeperBtn;
    @FXML private Button cageBtn;

    public static String getChoice() {
        return choice;
    }

    private static String choice;


    public void initialize() {

    //Different options with event handlers and buttons for the search through database functions.

        animalBtn.setOnAction(event -> {
            choice = "animal";
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/AnimalSearch.fxml"));
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
                p = FXMLLoader.load(getClass().getResource("../FXML/KeeperSearch.fxml"));
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
                p = FXMLLoader.load(getClass().getResource("../FXML/CageSearch.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();
        });



        returnBtn.setOnAction(event -> {
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