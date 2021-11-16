package Controllers;

import Wrappers.CageWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.fxml.*;
import sample.Animal;
import sample.Cage;
import sample.Database;

import static Controllers.KeeperController.keeperResult;

public class CageController {

    @FXML private Button returnBtn;
    @FXML private Button searchBtn;
    @FXML private TextField searchField;
    @FXML private Button deleteBtn;
    @FXML private Button allocateBtn;
    @FXML private Label messageLabel;
    @FXML private TableView<CageWrapper> table;
    private ObservableList<CageWrapper> observableList;

    public static CageWrapper cageResult;
    public ArrayList<String> allocatedAnimalsList = new ArrayList<String>();
    public boolean allocated = false;

    public void initialize() {

        observableList = FXCollections.observableArrayList();
        table.setItems(observableList);
        table.setEditable(false);
        Database db = new Database();


        searchBtn.setOnAction(event -> {
            String cageNumber = searchField.getText();


            ArrayList<Cage> cages = db.searchCages(cageNumber);

            observableList.clear();

            for (Cage cage : cages) {
                observableList.add(new CageWrapper(cage));
            }
        });

        //Event listener that gets activated when a row inside of the TableView gets clicked on, which returns the value of ID.

        table.setOnMouseClicked((MouseEvent event) -> {


            if (event.getButton().equals(MouseButton.PRIMARY)) {
                int index = table.getSelectionModel().getSelectedIndex();
                cageResult = table.getItems().get(index);
                System.out.println("ID: " + cageResult.getCageNumber());
                //returns the value that was clicked on

                allocateBtn.setOnAction(event2 -> {
                    //When Allocate Button is pressed
                    if(keeperResult != null){ //If Keeper Results is not empty

                    try {
                        //Allocates the values from the Keeper row to the selected cage.
                        db.allocateKeeperToCage(keeperResult, cageResult);
                        messageLabel.setText("Keeper allocated.");
                        messageLabel.setStyle("-fx-text-fill: green;");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }


                    try{
                        //If a cage is medium or large a Predator cannot be assigned to it, as it has to be on its own in a cage.
                        if(cageResult.getDescription().equals("medium") || cageResult.getDescription().equals("large") && AnimalController.animalResult.getType().equals("predator")){
                            System.out.println("Predators must be in cages by themselves!");
                            messageLabel.setText("Predators must be in cages by themselves!");
                            messageLabel.setStyle("-fx-text-fill: red;");

                        }
                        //If arrayList of allocated animals already contains the ID, the user sees a message that it is already allocated.
                        else if(allocatedAnimalsList.contains(AnimalController.animalResult.getID())){
                            System.out.println("Already allocated!!");
                            messageLabel.setText("Already allocated!");
                            messageLabel.setStyle("-fx-text-fill: red;");

                        }

                        else {
                            //If all it passes all previous conditions, animal can be succesfully allocated.
                            db.allocateAnimalToCage(AnimalController.animalResult, cageResult);
                            allocatedAnimalsList.add(AnimalController.animalResult.getID());
                            System.out.println(allocatedAnimalsList);
                            messageLabel.setText("Animal allocated.");
                            messageLabel.setStyle("-fx-text-fill: green;");
                        }

                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }

                });

                //Deletes from database
                deleteBtn.setOnAction(event1 ->{
                    System.out.println("Removed");
                    db.removeCage(cageResult.getID()); //Removes the subject from the Database by id.
                    table.getItems().removeAll(table.getSelectionModel().getSelectedItem()); //Removes the row from the TableView.
                });

            }


        });



        //Returns to previous view
        returnBtn.setOnAction(event -> {
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
    }
}
