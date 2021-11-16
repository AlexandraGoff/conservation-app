package Wrappers;

import javafx.beans.property.SimpleStringProperty;
import sample.Keeper;

/*Wrapper class that turns the Strings in Keeper to SimpleStringProperties
 that can work with Table View and Observable Array list.
 */

public class KeeperWrapper {


    //Constructor that takes an ordinary keeper as a parameter.
    public KeeperWrapper(Keeper keeper) {
        this.keeper = keeper;
        setID(keeper.getID());
        setFirstName(keeper.getFirstName());
        setSurname(keeper.getSurname());
        setContactNumber(keeper.getContactNumber());
        setPosition(keeper.getPosition());
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

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public SimpleStringProperty contactNumberProperty() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    private SimpleStringProperty ID = new SimpleStringProperty();
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty surname = new SimpleStringProperty();
    private SimpleStringProperty contactNumber = new SimpleStringProperty();
    private SimpleStringProperty position = new SimpleStringProperty();
    private Keeper keeper;



}
