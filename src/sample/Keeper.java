package sample;

public class Keeper {

    //Keeper constructor for creating a new instance of Keeper.
    public Keeper(String ID, String firstName, String surname, String contactNumber, String position) {
        this.ID = ID;
        this.firstName = firstName;
        this.surname = surname;
        this.contactNumber = contactNumber;
        this.position = position;
    }

    //Attributes of Keeper.
    private String ID;
    private String firstName;
    private String surname;
    private String contactNumber;
    private String position;

    //Getters and Setters to access private values in class Keeper.
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws InputValidationException{
        if(firstName.matches("p\\{Alpha}")){
            this.firstName = firstName;
        }
        else throw new InputValidationException("Please use Alphabetical letters only.");
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws InputValidationException {
        if(surname.matches("p\\{Alpha}")){
            this.surname = surname;
        }
        else throw new InputValidationException("Please use Alphabetical letters only.");
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) throws InputValidationException {
        if(contactNumber.matches("(p\\{Digit})")){
            this.contactNumber = contactNumber;
        }
        else throw new InputValidationException("Please only use digits for the contact number.");
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) throws InputValidationException{
        if(position.matches("p\\{Alpha}")){
            this.position = position;
        }
        else throw new InputValidationException("Position can only be in alphabetical letters.");
    }

}
