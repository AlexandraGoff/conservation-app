package Controllers;

import Wrappers.AnimalWrapper;
import Wrappers.CageWrapper;
import Wrappers.KeeperWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.*;

import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

public class KeeperController {
    @FXML
    private Button returnBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private TextField searchField;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button allBtn;

    @FXML private TableView<KeeperWrapper> table;
    private ObservableList<KeeperWrapper> observableList;


    public static KeeperWrapper keeperResult;



    public void initialize() {

        observableList = FXCollections.observableArrayList();
        table.setItems(observableList);
        table.setEditable(false);

        Database db = new Database();


        searchBtn.setOnAction(event -> {
            String firstName = searchField.getText();


            ArrayList<Keeper> keepers = db.searchKeepers(firstName);

            observableList.clear();

            for (Keeper keeper : keepers) {
                observableList.add(new KeeperWrapper(keeper));
            }
        });

        //Event listener that gets activated when a row inside of the TableView gets clicked on, which returns the value of ID.

        table.setOnMouseClicked((MouseEvent event) -> {

            if (event.getButton().equals(MouseButton.PRIMARY)) {
                int index = table.getSelectionModel().getSelectedIndex();
                keeperResult = table.getItems().get(index);
                System.out.println("Name: " + keeperResult.getFirstName() + " " + keeperResult.getSurname());

                allBtn.setOnAction(event2 -> {
                    //Opens the cage search view
                    try {
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
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                });



                //delete from DB
                deleteBtn.setOnAction(event1 ->{
                    System.out.println("Removed");
                    db.removeKeeper(keeperResult.getID()); //Removes the subject from the Database by id.
                    table.getItems().removeAll(table.getSelectionModel().getSelectedItem()); //Removes the row from the TableView.
                });

            }


        });


        //return back
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
