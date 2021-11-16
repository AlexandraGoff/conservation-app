package sample;

public class Test {
    public static void main(String[] args) throws InputValidationException {

        //Test for setting Animal details
        Animal animal = new Animal("052147","10","Zebra","Insect","Femmmale","21stOctober","21/10/2020");

        //Test for setting Keeper details
        Keeper keeper = new Keeper("11","~@Joh3","Th8mpson$","12345678924697855256", "125555~");


        //Test for setting Cage details
        Cage cage = new Cage("12", "20", "Tiny", "11");

    }
}
