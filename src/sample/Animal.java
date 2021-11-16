package sample;

public class Animal {

    //Animal constructor for creating a new instance of keeper.
    private String name;
    private String ID;
    private String type;
    private String category;
    private String gender;
    private String dob;
    private String doa;

    //Attributes of Animal.
    public Animal(String name, String ID, String type, String category, String gender, String dob, String doa) {
        this.name = name;
        this.ID = ID;
        this.type = type;
        this.category = category;
        this.gender = gender;
        this.dob = dob;
        this.doa = doa;

    }

    //Getters and Setters to access private values in class Animal.
    public String getName() {
        return name;
    }

    public void setName(String name) throws InputValidationException{
        if (name.matches("(\\p{Alpha})")) {
            this.name = name;
        } else throw new InputValidationException("Incorrect name, please use Alphabetical letters only");
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws InputValidationException{
        if (type.matches("(\\p{Alpha})")) {
            this.type = type;
        } else throw new InputValidationException("Incorrect type, please use Alphabetical letters only");
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) throws InputValidationException {
    if (category.matches("Predator|Prey|predator|prey")) {
        this.category = category;
    } else throw new InputValidationException("Incorrect Category, please choose from Predator/Prey");
}


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) throws InputValidationException {
            if (gender.matches("Male|Female|male|female")){
                this.gender = gender;
            } else throw new InputValidationException("Incorrect Gender, please choose from Female/Male");
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) throws InputValidationException{
        if(dob.matches("([0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4})")){
            this.dob = dob;
        }
        else throw new InputValidationException("Please input a correct date of birth.");
    }

    public String getDoa() throws InputValidationException{
        return doa;
    }

    public void setDoa(String doa) throws InputValidationException {
        if(dob.matches("([0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4})")){
            this.doa = doa;
        }
        else throw new InputValidationException("Please input a correct date of acquisition.");
    }




}
