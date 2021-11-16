package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Animal;
import sample.Database;
import Wrappers.AnimalWrapper;
import sample.InputValidationException;

import java.io.IOException;
import java.util.ArrayList;
public class AnimalController {

    @FXML private Button returnBtn;
    @FXML private Button searchBtn;
    @FXML private TextField searchField;
    @FXML private Button deleteBtn;
    @FXML private Button allBtn;
    @FXML private TableView<AnimalWrapper> table;
    private ObservableList<AnimalWrapper> observableList;

    public static AnimalWrapper animalResult;


    public void initialize() {

        observableList = FXCollections.observableArrayList();
        table.setItems(observableList);
        table.setEditable(false);
        Database db = new Database();


        searchBtn.setOnAction(event -> {
            String name = searchField.getText();


            ArrayList<Animal> animals = db.searchAnimals(name); //Searches through the database to find a name of the animal.

            observableList.clear();

            for (Animal animal : animals) {
                try {
                    observableList.add(new AnimalWrapper(animal));
                } catch (InputValidationException e) {
                    e.printStackTrace();
                }
            }
        });

        //Event listener that gets activated when a row inside of the TableView gets clicked on, which returns the value of ID.

        table.setOnMouseClicked((MouseEvent event) -> {

                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    int index = table.getSelectionModel().getSelectedIndex();
                    animalResult = table.getItems().get(index);
                    System.out.println("ID: " + animalResult.getID());

                    deleteBtn.setOnAction(event1 ->{
                        System.out.println("Removed");
                        db.removeAnimal(animalResult.getID()); //Removes the subject from the Database by id.
                        table.getItems().removeAll(table.getSelectionModel().getSelectedItem()); //Removes the row from the TableView.
                    });

                    allBtn.setOnAction(event2 -> {
                        //allocate button opens the CageSearch.fxml view.
                        Parent p = null;
                        try {
                            p = FXMLLoader.load(getClass().getResource("../FXML/CageSearch.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(p);
                        Stage addStage = (Stage) ((Node) event2.getSource()).getScene().getWindow();
                        addStage.setScene(scene);
                        addStage.show();
                    });

                }

        });




        returnBtn.setOnAction(event -> {
            //Returns back
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
