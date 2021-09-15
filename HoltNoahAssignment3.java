import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HoltNoahAssignment3 {
    
    public static void main(String[] args) throws IOException{

        //open file and scanner
        File birdList = new File("Birds.txt");
        Scanner readBirds = new Scanner(birdList);
        //open array list
        ArrayList<Bird> birds;
        
        //call displayBirds
        //call findSwimmers
        //call swimmingRace


        //remember to close scanner
        readBirds.close();

    } //main

    public static void displayBirds(ArrayList<Bird> birds){



    } //display
    /*
    public static ArrayList<Bird> findSwimmers(ArrayList<Bird> birds) {

        ArrayList<Bird> swimmingBirds;

        return swimmingBirds;

    }
    
    public static Bird swimmingRace (ArrayList<Bird> swimmingBirds) {
        
        
    }*/



} //assignment

class Bird { //make this abstract

    private String type;
    private String name;

    public String getType() {

        return type;

    }

    public String getName() { 

        return name;

    }

    //abstract method strangeFact();

} //bird

class Penguin extends Bird{

    public Penguin(String name, int runSpeed, int swimSpeed) {



    }

} //penguin

class Ostrich extends Bird{

    public Ostrich(String name, int runSpeed, int swimSpeed) {



    }

} //Ostrich

class Duck extends Bird{

    public Duck(String name) {



    }

} //duck

class SootyTern extends Bird{

    public SootyTern(String name, int runSpeed, int flySpeed) {



    }

} //SootyTern

class Loon extends Bird{

    public Loon(String name, int swimSpeed, int flySpeed) {


    }

} //loon

class HummingBird extends Bird {

    public HummingBird(String name) {



    }

} //HummingBird
