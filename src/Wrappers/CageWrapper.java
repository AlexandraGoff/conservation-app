package Wrappers;

import javafx.beans.property.SimpleStringProperty;
import sample.Cage;

/*Wrapper class that turns the Strings in Cage to SimpleStringProperties
 that can work with Table View and Observable Array list
 */

public class CageWrapper {

    private SimpleStringProperty ID = new SimpleStringProperty();
    private SimpleStringProperty cageNumber = new SimpleStringProperty();
    private SimpleStringProperty description = new SimpleStringProperty();
    private SimpleStringProperty capacity = new SimpleStringProperty();
    private Cage cage;

    //Constructor that takes an ordinary cage as a parameter.
    public CageWrapper(Cage cage){
        this.cage = cage;
        setID(cage.getID());
        setCageNumber(cage.getCageNumber());
        setDescription(cage.getDescription());
        setCapacity(cage.getCapacity());
    }


    public String getID() {
        return ID.get();
    }

    public SimpleStringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
    }

    public String getCageNumber() {
        return cageNumber.get();
    }

    public SimpleStringProperty cageNumberProperty() {
        return cageNumber;
    }

    public void setCageNumber(String cageNumber) {
        this.cageNumber.set(cageNumber);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getCapacity() {
        return capacity.get();
    }

    public SimpleStringProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }

}
