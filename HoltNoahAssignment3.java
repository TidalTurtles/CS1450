import java.util.ArrayList;

public class HoltNoahAssignment3 {
    
    public static void main(String[] args) {

        ArrayList<bird> birds;
        //need open file and place in array list
        //call displayBirds
        //call findSwimmers
        //call swimmingRace

    } //main

} //assignment

class bird { //make this abstract

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

class Penguin extends bird{

    public Penguin(String name, int runSpeed, int swimSpeed) {



    }

} //penguin

class Ostrich extends bird{

    public Ostrich(String name, int runSpeed, int swimSpeed) {



    }

} //Ostrich

class Duck extends bird{

    public Duck(String name) {



    }

} //duck

class SootyTern extends bird{

    public SootyTern(String name, int runSpeed, int flySpeed) {



    }

} //SootyTern

class Loon extends bird{

    public Loon(String name, int swimSpeed, int flySpeed) {


    }

} //loon

class HummingBird extends bird {

    public HummingBird(String name) {



    }

} //HummingBird
