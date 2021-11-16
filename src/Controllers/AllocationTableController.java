package Controllers;

import Wrappers.AllocationWrapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.AllocationTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import sample.Database;

import java.io.IOException;
import java.util.ArrayList;

public class AllocationTableController {
    @FXML
    private TableView<AllocationWrapper> table;
    private ObservableList<AllocationWrapper> observableList;
    @FXML private Button returnBtn;

//Controller that manipulates the Allocation Table.fxml file.
    public void initialize(){

        observableList = FXCollections.observableArrayList(); //New observable arraylist
        table.setItems(observableList);  // set the TableView to the observable list
        table.setEditable(false);

        Database db = new Database();

        ArrayList<AllocationTable> allocationTables = db.displayAllocationTable(); //Displays the allocationTable data from the database.

        observableList.clear();

        for (AllocationTable allocationTable : allocationTables) {
            observableList.add(new AllocationWrapper(allocationTable));
        }

        returnBtn.setOnAction(event ->{
            //return back
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
