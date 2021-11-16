package Wrappers;

/*Wrapper class that turns the Strings in AllocationTable to SimpleStringProperties
 that can work with Table View and Observable Array list
 */



import javafx.beans.property.SimpleStringProperty;
import sample.AllocationTable;

public class AllocationWrapper{

    //Constructor that takes an ordinary allocationTable as a parameter.
    public AllocationWrapper(AllocationTable allocationTable) {
        this.allocationTable = allocationTable;
        setCageNumber(allocationTable.getCageNumber());
        setKeepers(allocationTable.getKeepers());
        setAnimals(allocationTable.getAnimals());
        setCapacity(allocationTable.getCapacity());
        setSpace(allocationTable.getSpace());
    }

    //Getters and Setters
    public String getCageNumber() {
        return cageNumber.get();
    }

    public SimpleStringProperty cageNumberProperty() {
        return cageNumber;
    }

    public void setCageNumber(String cageNumber) {
        this.cageNumber.set(cageNumber);
    }

    public String getKeepers() {
        return keepers.get();
    }

    public SimpleStringProperty keepersProperty() {
        return keepers;
    }

    public void setKeepers(String keepers) {
        this.keepers.set(keepers);
    }

    public String getAnimals() {
        return animals.get();
    }

    public SimpleStringProperty animalsProperty() {
        return animals;
    }

    public void setAnimals(String animals) {
        this.animals.set(animals);
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

    public String getSpace() {
        return space.get();
    }

    public SimpleStringProperty spaceProperty() {
        return space;
    }

    public void setSpace(String space) {
        this.space.set(space);
    }

    public AllocationTable getAllocationTable() {
        return allocationTable;
    }

    public void setAllocationTable(AllocationTable allocationTable) {
        this.allocationTable = allocationTable;
    }

    private SimpleStringProperty animals = new SimpleStringProperty();
    private SimpleStringProperty capacity = new SimpleStringProperty();
    private SimpleStringProperty space = new SimpleStringProperty();
    private SimpleStringProperty cageNumber = new SimpleStringProperty();
    private SimpleStringProperty keepers = new SimpleStringProperty();
    private AllocationTable allocationTable;
}
