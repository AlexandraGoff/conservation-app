package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SampleController {

    @FXML
    private Button searchButton;
    @FXML
    private Button capacityButton;
    @FXML
    private Button addButton;


    public void initialize(){

        //Different button options for the main menu with event handlers and views.
        addButton.setOnAction(event -> {
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/addWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();
        });

        searchButton.setOnAction(event -> {
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/MenuWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(p);
            Stage addStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            addStage.setScene(scene);
            addStage.show();
        });


        capacityButton.setOnAction(event -> {
            Parent p = null;
            try {
                p = FXMLLoader.load(getClass().getResource("../FXML/AllocationTable.fxml"));
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

