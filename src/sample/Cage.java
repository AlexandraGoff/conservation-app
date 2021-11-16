package sample;

public class Cage {

    //Animal constructor for creating a new instance of Cage.
    public Cage(String ID, String cageNumber, String description, String capacity) {
        this.ID = ID;
        this.cageNumber = cageNumber;
        this.description = description;
        this.capacity = capacity;
    }

    //Attributes of Cage.
    private String ID;
    private String cageNumber;
    private String description;
    private String capacity;

    //Getters and Setters to access private values in class Cage.
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCageNumber() {
        return cageNumber;
    }

    public void setCageNumber(String cageNumber) throws InputValidationException{
        if(cageNumber.matches("(\\p{Digit})[1,15]")) {
            this.cageNumber = cageNumber;
        }
        else throw new InputValidationException("Please select a cage number, between 1-15.");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws InputValidationException {
        if(description.matches("Large|Medium|Small"))
        {
            this.description = description;
        }
        else throw new InputValidationException("Please select either Large,Medium or Small cage.");
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) throws InputValidationException{
        if(capacity.matches("(\\p{Digit})[1,10]")) {
            this.capacity = capacity;
        }
        else throw new InputValidationException("Incorrect input. Maximum capacity is 10.");
    }




}
