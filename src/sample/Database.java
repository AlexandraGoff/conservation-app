package sample;

import Wrappers.AnimalWrapper;
import Wrappers.CageWrapper;
import Wrappers.KeeperWrapper;

import java.sql.*;
import java.util.ArrayList;


public class Database {
    public Database() {
        try {
            //CONNECT TO DATABASE
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            Statement statement = connection.createStatement();
            //Create tables with table columns and various data types
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS allocationTable(cageNumber TEXT PRIMARY KEY, keepers TEXT , animals TEXT, capacity TEXT, space TEXT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS animals(ID TEXT, name TEXT, type TEXT, category TEXT, dob TEXT, doa TEXT, gender TEXT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS keepers(ID TEXT, firstName TEXT, Surname TEXT, contactNumber INT, Position TEXT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS cages(ID TEXT, cageNumber INT, Description TEXT, Capacity INT)");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS allocatedList(ID TEXT PRIMARY KEY)");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //ADD TO DATABASE

        //Add an animal to the database.
        public void addAnimal(Animal newAnimal){

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO animals (ID, name, type, category, doa, dob, gender) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, newAnimal.getID());
            statement.setString(2, newAnimal.getName());
            statement.setString(3, newAnimal.getType());
            statement.setString(4, newAnimal.getCategory());
            statement.setString(5, newAnimal.getDoa());
            statement.setString(6, newAnimal.getDob());
            statement.setString(7, newAnimal.getGender());

            statement.executeUpdate();
            statement.close();
            connection.close();
        }

        catch (SQLException | InputValidationException e){
            e.printStackTrace();
        }
        }

    //Add a Keeper to the database.
    public void addKeeper(Keeper newKeeper){

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO keepers (ID, firstName, Surname, contactNumber, Position) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, newKeeper.getID());
            statement.setString(2, newKeeper.getFirstName());
            statement.setString(3, newKeeper.getSurname());
            statement.setString(4, newKeeper.getContactNumber());
            statement.setString(5, newKeeper.getPosition());

            statement.executeUpdate();
            statement.close();
            connection.close();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Add a Cage to the database.
    public void addCage(Cage newCage){

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cages (ID, cageNumber, Description, Capacity) VALUES (?, ?, ?, ?)");
            statement.setString(1, newCage.getID());
            statement.setString(2, newCage.getCageNumber());
            statement.setString(3, newCage.getDescription());
            statement.setString(4, newCage.getCapacity());
            statement.executeUpdate();
            statement.close();
            connection.close();
        }

        catch (SQLException e){
            e.printStackTrace();
        }
    }

    //SEARCH THE DATABASE

    //Search through table "animals" to find a matching name, then return all results as an array.
    public ArrayList<Animal> searchAnimals(String name){
        ArrayList<Animal> animals = new ArrayList<Animal>();
        try{
            Connection connection = DriverManager.getConnection(("jdbc:sqlite:database.jar"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM animals WHERE name LIKE '" + name + "'");


            while (resultSet.next()){

                Animal searchAnimals = new Animal(resultSet.getString("name"), resultSet.getString("ID"), resultSet.getString("type"), resultSet.getString("category"),resultSet.getString("gender"),resultSet.getString("dob"),resultSet.getString("doa"));
                animals.add(searchAnimals);

                statement.close();
                connection.close();
            }
            return animals;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //Search through table "keepers" to find a matching name, then return all results as an array.
    public ArrayList<Keeper> searchKeepers(String firstName){
        ArrayList<Keeper> keepers = new ArrayList<Keeper>();
        try{
            Connection connection = DriverManager.getConnection(("jdbc:sqlite:database.jar"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM keepers WHERE firstName LIKE '" + firstName + "'");


            while (resultSet.next()){

                Keeper searchKeepers = new Keeper(resultSet.getString("ID"), resultSet.getString("firstName"), resultSet.getString("surname"), resultSet.getString("contactNumber"),resultSet.getString("position"));
                keepers.add(searchKeepers);

                statement.close();
                connection.close();
            }
            return keepers;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //Search through table "cages" to find a matching name, then return all results as an array.
    public ArrayList<Cage> searchCages(String cageNumber){
        ArrayList<Cage> cages = new ArrayList<Cage>();
        try{
            Connection connection = DriverManager.getConnection(("jdbc:sqlite:database.jar"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cages WHERE cageNumber LIKE '" + cageNumber + "'");


            while (resultSet.next()){

                Cage searchCages = new Cage(resultSet.getString("ID"), resultSet.getString("cageNumber"), resultSet.getString("description"), resultSet.getString("capacity"));
                cages.add(searchCages);

                statement.close();
                connection.close();
            }
            return cages;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //ALLOCATE IN DATABASE

    /*Takes keeper and cage from the ObservableArrayList that has been clicked on and inserts the keeperID into allocation table, if the record with cageNumber already exists
    it simply updates it instead*/
    public void allocateKeeperToCage(KeeperWrapper keeper, CageWrapper cage){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            //UPSERT
            PreparedStatement statement = connection.prepareStatement("INSERT INTO allocationTable(Keepers, cageNumber) VALUES (?, ?) ON CONFLICT(cageNumber) DO UPDATE SET Keepers = excluded.Keepers");

            statement.setString(1, keeper.getID());
            statement.setString(2, cage.getCageNumber());

            statement.executeUpdate();

            statement.close();

            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*Takes animal and cage from the ObservableArrayList that has been clicked on and inserts the animalID into allocation table, if the record with cageNumber already exists
    it simply updates it instead*/
    public void allocateAnimalToCage(AnimalWrapper animal, CageWrapper cage){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            //UPSERT
            PreparedStatement statement = connection.prepareStatement("INSERT INTO allocationTable (Animals, cageNumber) VALUES (?, ?) ON CONFLICT(cageNumber) DO UPDATE SET Animals = excluded.Animals");

            statement.setString(1, animal.getID());
            statement.setString(2, cage.getCageNumber());


            statement.executeUpdate();


            statement.close();


            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    //Displays the allocation table with all assigned Animals and Keepers to Cages.
    public ArrayList<AllocationTable> displayAllocationTable(){
        ArrayList<AllocationTable> allocationTables = new ArrayList<AllocationTable>();
        try{
            Connection connection = DriverManager.getConnection(("jdbc:sqlite:database.jar"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM allocationTable"); //SELECT ALL FROM THE ALLOCATION TABLE


            while (resultSet.next()){

                AllocationTable displayAllocations = new AllocationTable(resultSet.getString("cageNumber"), resultSet.getString("keepers"), resultSet.getString("animals"), resultSet.getString("capacity"),resultSet.getString("space"));
                allocationTables.add(displayAllocations);

                statement.close();
                connection.close();
            }
            return allocationTables;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //REMOVE FROM DATABASE

    //Removes an animal from database by ID.
    public void removeAnimal(String uniqueID){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM animals WHERE ID = ? ");
            statement.setString(1, uniqueID);
            statement.executeUpdate();
            statement.close();
            connection.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }




    }

    //Removes a keeper from the Database.
    public void removeKeeper(String uniqueID){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM keepers WHERE ID = ? ");
            statement.setString(1, uniqueID);
            statement.executeUpdate();
            statement.close();
            connection.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }




    }
    //Removes a cage from the database.
    public void removeCage(String uniqueID){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cages WHERE ID = ? ");
            statement.setString(1, uniqueID);
            statement.executeUpdate();
            statement.close();
            connection.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }




    }


    //Code that didn't work because of a null pointer exception, instead I have implemented a regular arraylist for allocated animals for the purposes of the assignment.
    /*
    public void addAllocated(String ID){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO allocatedList (ID) values (?) ON CONFLICT(ID) DO UPDATE SET ID = excluded.ID");
            statement.setString(1, ID);
            statement.executeUpdate();
            statement.close();
            connection.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String checkIfContains(String ID){
        try{

            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.jar");
            Statement statement = connection.createStatement();
            String id;
            try (ResultSet resultSet = statement.executeQuery("SELECT ID FROM allocatedList WHERE EXISTS (SELECT ID FROM allocatedList WHERE ID = ?)")) {
                id = resultSet.getString(1);
            }

            statement.close();
            connection.close();

            return id;


        }
        catch(SQLException e){
            e.printStackTrace();

        }
        return null;
    }*/


}
