package Wrappers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.Animal;
import sample.InputValidationException;

/*Wrapper class that turns the Strings in Animal to SimpleStringProperties
 that can work with Table View and Observable Array list
 */

public class AnimalWrapper {

    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty ID = new SimpleStringProperty();

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
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

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getDob() {
        return dob.get();
    }

    public SimpleStringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }

    public String getDoa() {
        return doa.get();
    }

    public SimpleStringProperty doaProperty() {
        return doa;
    }

    public void setDoa(String doa) {
        this.doa.set(doa);
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    private SimpleStringProperty type = new SimpleStringProperty();
    private SimpleStringProperty category = new SimpleStringProperty();
    private SimpleStringProperty gender = new SimpleStringProperty();
    private SimpleStringProperty dob = new SimpleStringProperty();
    private SimpleStringProperty doa = new SimpleStringProperty();
    private Animal animal;


    //Constructor that takes an ordinary animal as a parameter.
    public AnimalWrapper(Animal animal) throws InputValidationException {
        this.animal = animal;
        setName(animal.getName());
        setID(animal.getID());
        setType(animal.getType());
        setCategory(animal.getCategory());
        setGender(animal.getGender());
        setDob(animal.getDob());
        setDoa(animal.getDoa());

    }

}
