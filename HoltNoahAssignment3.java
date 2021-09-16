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
                aPenguin.setName(birdName);
                aPenguin.setType(birdType);
                aPenguin.setRunSpeed(birdRun);
                aPenguin.setSwimSpeed(birdSwim);
                birds.add(aPenguin);
            } else if(birdType.equals("ostrich")){
                Ostrich aOstrich = new Ostrich(birdName, birdRun, birdSwim);
                aOstrich.setName(birdName);
                aOstrich.setType(birdType);
                aOstrich.setRunSpeed(birdRun);
                aOstrich.setSwimSpeed(birdSwim);
                birds.add(aOstrich);
            } else if(birdType.equals("sootytern")) {
                SootyTern aSootyTern = new SootyTern(birdName, birdRun, birdFly);
                aSootyTern.setName(birdName);
                aSootyTern.setType(birdType);
                aSootyTern.setFlySpeed(birdFly);
                aSootyTern.setRunSpeed(birdRun);
                birds.add(aSootyTern);
            }else {
                Loon aLoon = new Loon(birdName, birdSwim, birdFly);
                aLoon.setName(birdName);
                aLoon.setType(birdType);
                aLoon.setFlySpeed(birdFly);
                aLoon.setSwimSpeed(birdSwim);
                birds.add(aLoon);
            } //if

        } // for

        
        displayBirds(birds);

        ArrayList<Bird> swimBirds= findSwimmers(birds);
        //printing birds that can swimm
        System.out.println("-------------------------------------------------");
        System.out.println("Bird    Type    SwimSpeed");
        System.out.println("-------------------------------------------------");
        for(int i = 0; i < swimBirds.size(); i++) {
            System.out.println(swimBirds.get(i).getName() + "\t" + swimBirds.get(i).getType() + "\t" + ((Swimmer)swimBirds.get(i)).swim());
        }
        System.out.println("");

        Bird bestSwimmer = swimmingRace(swimBirds);
        //print out swim race winner
        System.out.println("-------------------------------------------------");
        System.out.println("Swim Race Winner");
        System.out.println("-------------------------------------------------");
        System.out.println("Swimming birds get ready... get set... GO!!!");
        System.out.println("The winner is " + bestSwimmer.getName() + " the " + bestSwimmer.getType() + " swimming at " + ((Swimmer)bestSwimmer).swim() + " mph!");

        //remember to close scanner
        readBirds.close();

    } //main

    public static void displayBirds(ArrayList<Bird> birds){

        System.out.println("Birds and Abilities");
        System.out.println("-----------------------------------------------");
        
        for(int i = 0; i < birds.size(); i++) {
            
            System.out.println(" ");
            System.out.println(birds.get(i).getName() + " is a " + birds.get(i).getType());
            System.out.println(birds.get(i).strangeFact());

            //had to hard code this for while I try to figure out how to search if fly is aplicable to each class? not sure but if it gets left like this you now know why.
            if(birds.get(i) instanceof Swimmer){ //if bird can swim
                System.out.print("Swim Speed: "+ ((Swimmer)birds.get(i)).swim() + "\t");
            } else { //no swim
                System.out.print("Swim Speed: 0"  + "\t");
            }
            if(birds.get(i) instanceof Runner){ //if bird can run
                System.out.print("Run Speed: "+ ((Runner)birds.get(i)).run() + "\t");
            } else { //no run
                System.out.print("Run Speed: 0"  + "\t");
            }
            if(birds.get(i) instanceof Flyer){
                System.out.print("Flying Altitude: "+ ((Flyer)birds.get(i)).fly() + "\t");
            } else { //no fly
                System.out.print("Flying Altitude: 0"  + "\t");
            }
            System.out.println(" ");
        }

    } //display
    
    public static ArrayList<Bird> findSwimmers(ArrayList<Bird> birds) {

        ArrayList<Bird> swimmingBirds = new ArrayList<Bird>();

        for(int i = 0; i < birds.size(); i++) {
            if (birds.get(i) instanceof Swimmer) {
                swimmingBirds.add(birds.get(i));
            }
        }

        return swimmingBirds;

    }
    
    
    public static Bird swimmingRace(ArrayList<Bird> swimBirds) {
        
        Bird winner = swimBirds.get(0);
            
        
        for(int i = 1; i < swimBirds.size(); i ++) {
            if(((Swimmer)winner).swim() < ((Swimmer)swimBirds.get(i)).swim()) {
                winner = swimBirds.get(i);
            }
        }
        
        return winner;
    }



} //assignment

interface Swimmer {
    abstract int swim();
} //swimmer

interface Runner {
    abstract int run();
} //runner

interface Flyer {
    abstract int fly();
} //flyer

abstract class Bird { 

    private String type;
    private String name;

    public String getType() {

        return type;
 
    } //get type

    public void setType(String birdType) {

        this.type = birdType;

    } //set type

    public String getName() { 

            return name;

    } //get name

    public void setName(String birdName) {

        this.name = birdName;

    } //set name

    abstract String strangeFact();

} //bird

class Penguin extends Bird implements Swimmer, Runner{
    private int swimSpeed;
    private int runSpeed;

    public Penguin(String name, int runSpeed, int swimSpeed) {

        

    }

    public void setSwimSpeed(int swimSpeed) {

        this.swimSpeed = swimSpeed;

    }
    public void setRunSpeed(int runSpeed) {

        this.runSpeed = runSpeed;

    }

    @Override
    public String strangeFact() {
        return "I can't fly but I'm the fastest swimmer and the deepest diver and can stay underwater up to 20 minutes.";
    } //strange penguin
    @Override
    public int swim() {
        return swimSpeed;
    }
    @Override
    public int run(){
        return runSpeed;
    }

} //penguin

class Ostrich extends Bird implements Runner, Swimmer{
    private int runSpeed;
    private int swimSpeed;

    public Ostrich(String name, int runSpeed, int swimSpeed) {

        

    } //construct

    public void setSwimSpeed(int swimSpeed) {

        this.swimSpeed = swimSpeed;

    }
    public void setRunSpeed(int runSpeed) {

        this.runSpeed = runSpeed;

    }
    
    @Override
    public String strangeFact() {
        return "Who needs flying when you're the biggest bird on earth! I can be up to 9 feet tall and weigh up to 300 punds - bring it on!";
    } //strange ostrich
    @Override
    public int swim() {
        return swimSpeed;
    }
    @Override
    public int run() {
        return runSpeed;
    }

} //Ostrich

class SootyTern extends Bird implements Runner, Flyer{
    private int runSpeed;
    private int flySpeed;

    public SootyTern(String name, int runSpeed, int flySpeed) {

        

    } //construct

    public void setFlySpeed(int flySpeed) {

        this.flySpeed = flySpeed;

    }
    public void setRunSpeed(int runSpeed) {

        this.runSpeed = runSpeed;

    }
    
    @Override
    public String strangeFact() {
        return "Strange as it may sound, I spend most of my life at sea and I can't swim but I can nap while flying!";
    } //strange tern
    @Override
    public int fly() {
        return flySpeed;
    }
    @Override
    public int run() {
        return runSpeed;
    }

} //SootyTern

class Loon extends Bird implements Swimmer, Flyer{
    private int swimSpeed;
    private int flySpeed;

    public Loon(String name, int swimSpeed, int flySpeed) {

        

    } //construct

    public void setSwimSpeed(int swimSpeed) {

        this.swimSpeed = swimSpeed;

    }
    public void setFlySpeed(int flySpeed) {

        this.flySpeed = flySpeed;

    }
    
    @Override
    public String strangeFact() {
        return "My legs are so far back on my body that I cannot walkd on land, so I push myself along the ground on my chest.";
    } // strange loon
    @Override
    public int swim() {
        return swimSpeed;
    }
    @Override
    public int fly() {
        return flySpeed;
    }

} //loon
