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
        ArrayList<Bird> birds = new ArrayList<Bird>();

        //creating the array list.
        int numBirds = readBirds.nextInt();

        for(int i = 0; i < numBirds; i++) {

            String birdType = readBirds.next();
            String birdName = readBirds.next();
            int birdRun = readBirds.nextInt();
            int birdSwim = readBirds.nextInt();
            int birdFly = readBirds.nextInt();

            if(birdType.equals("penguin")) {
                Penguin aPenguin = new Penguin(birdName, birdRun, birdSwim);
                birds.add(aPenguin);
            } else if(birdType.equals("ostrich")){
                Ostrich aOstrich = new Ostrich(birdName, birdRun, birdSwim);
                birds.add(aOstrich);
            } else if(birdType.equals("sootytern")) {
                SootyTern aSootyTern = new SootyTern(birdName, birdRun, birdFly);
                birds.add(aSootyTern);
            }else {
                Loon aLoon = new Loon(birdName, birdSwim, birdFly);
                birds.add(aLoon);
            } //if

        } // for

        
        
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

interface Swimmer {
    abstract void swim();
} //swimmer

interface Runner {
    abstract void run();
} //runner

interface Flyer {
    abstract void fly();
} //flyer

abstract class Bird { 

    private String type;
    private String name;

    public void setType(String type) {

        this.type = type;

    } //set type
    public String getType() {

        return type;
 
    } //get type

    public void setName(String name) {

        this.name = name;

    } //set name

    public String getName() { 

        return name;

    } //get name

    abstract String strangeFact();

} //bird

class Penguin extends Bird{

    public Penguin(String name, int runSpeed, int swimSpeed) {



    } //construct

    public String strangeFact() {
        return "I can't fly but I'm the fastest swimmer and the deepest diver and can stay underwater up to 20 minutes.";
    } //strange penguin

} //penguin

class Ostrich extends Bird{

    public Ostrich(String name, int runSpeed, int swimSpeed) {



    } //construct

    public String strangeFact() {
        return "Who needs flying when you're the biggest bird on earth! I can be up to 9 feet tall and weigh up to 300 punds - bring it on!";
    } //strange ostrich

} //Ostrich

class SootyTern extends Bird{

    public SootyTern(String name, int runSpeed, int flySpeed) {



    } //construct

    public String strangeFact() {
        return "Strange as it may sound, I spend most of my life at sea and I can't swim but I can nap while flying!";
    } //strange tern

} //SootyTern

class Loon extends Bird{

    public Loon(String name, int swimSpeed, int flySpeed) {


    } //construct

    public String strangeFact() {
        return "My legs are so far back on my body that I cannot walkd on land, so I push myself along the ground on my chest.";
    } // strange loon

} //loon
