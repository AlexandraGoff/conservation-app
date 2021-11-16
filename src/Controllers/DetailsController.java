package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import sample.Animal;
import sample.Cage;
import sample.Database;
import sample.Keeper;

import java.io.IOException;
import java.util.UUID;

public class DetailsController { //Gets details about a subject from the user
    @FXML private Button returnBtn;
    @FXML private Button mainMenuBtn;
    @FXML private TextField field1;
    @FXML private TextField field2;
    @FXML private TextField field3;
    @FXML private TextField field4;
    @FXML private TextField field5;
    @FXML private TextField field6;
    @FXML private Button submitBtn;
    @FXML private Label title;

    Database db = new Database();

    public void initialize() {



        if (AddController.getChoice().equals("animal")) {


            submitBtn.setOnAction(event -> {
                //When submit button is clicked get all the information from fields and create a new instance of Animal.
                String uniqueID = UUID.randomUUID().toString();
                Animal animal = new Animal(field1.getText(),uniqueID,field2.getText(), field3.getText(),field4.getText(),field5.getText(),field6.getText());
                db.addAnimal(animal); //add to database
                field1.clear();
                field2.clear();
                field3.clear();
                field4.clear();
                field5.clear();
                field6.clear();

            });
        }

        if (AddController.getChoice().equals("keeper")) {

            title.setText("Add a New Keeper");

            field1.setPromptText("First Name...");
            field2.setPromptText("Surname...");
            field3.setPromptText("Contact Number...");
            field4.setPromptText("Position");
            field5.setVisible(false);
            field6.setVisible(false);

            submitBtn.setOnAction(event -> {
                //When submit button is clicked get all the information from fields and create a new instance of Keeper.
                String uniqueID = UUID.randomUUID().toString();
                Keeper keeper = new Keeper(uniqueID, field1.getText(), field2.getText(), field3.getText(),field4.getText());
                db.addKeeper(keeper);

                field1.clear();
                field2.clear();
                field3.clear();
                field4.clear();
                field5.clear();

            });
        }


        if (AddController.getChoice().equals("cage")) {

            title.setText("Add a New Cage");

            field1.setPromptText("Cage Number...");
            field2.setPromptText("Description...");
            field3.setPromptText("Capacity...");
            field4.setVisible(false);
            field5.setVisible(false);
            field6.setVisible(false);

            submitBtn.setOnAction(event -> {
                //When submit button is clicked get all the information from fields and create a new instance of Cage.
                String uniqueID = UUID.randomUUID().toString();
                Cage cage = new Cage(uniqueID, field1.getText(),field2.getText(),field3.getText());
                db.addCage(cage);

                field1.clear();
                field2.clear();
                field3.clear();
            });
        }

        mainMenuBtn.setOnAction(event -> {
            //return to main menu
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

        returnBtn.setOnAction(event -> {
            //return to previous view
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


    }
}
