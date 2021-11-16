package sample;

//Allocation table that shows all the allocated animals and keepers to cages.
public class AllocationTable {

    //Allocation Table Constructor
    public AllocationTable(String cageNumber, String keepers, String animals, String capacity, String space) {
        this.cageNumber = cageNumber;
        this.keepers = keepers;
        this.animals = animals;
        this.capacity = capacity;
        this.space = space;
    }

    //Getters and Setters for the Allocation Table Class.

    public String getCageNumber(){
        return cageNumber;
    }

    public void setCageNumber(String cageNumber){
        this.cageNumber= cageNumber;
    }

    public String getKeepers() {
        return keepers;
    }

    public void setKeepers(String keepers) {
        this.keepers = keepers;
    }

    public String getAnimals() {
        return animals;
    }

    public void setAnimals(String animals) {
        this.animals = animals;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    //All attributes.
    private String cageNumber;
    private String keepers;
    private String animals;
    private String capacity;
    private String space;

}