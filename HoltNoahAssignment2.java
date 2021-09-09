import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HoltNoahAssignment2{

    public static void main(String[] args) throws IOException {

        /*Noah Holt
		 * CS1450 Data Structures
		 * T/Thr section
		 * Due 10 Sept
		 * Assignment 2
		 * This assignment is to review objects and polymorphism using 
         * actors from a file and creating objects called actors with
         * subclasses depending on the actors role in the production
		 */
        
		//open file and scanner
		File actorList = new File("Actors.txt");
		Scanner readActors = new Scanner(actorList);

		int numActors = readActors.nextInt();

		Actor[] actors = new Actor[numActors];

		// lets create our Actors and store in an array
		for(int i = 0; i < actors.length; i++) {

			String type = readActors.next();
			String name = readActors.nextLine();

			switch(type) {

				case "Hero":
				Hero aHero = new Hero(name);
				actors[i] = aHero;
				break;

				case "Villain":
				Villain aVillain = new Villain(name);
				actors[i] = aVillain;
				break;

				case "Monster":
				Monster aMonster = new Monster(name);
				actors[i] = aMonster;
				break;

				case "Droid":
				Droid aDroid = new Droid(name);
				actors[i] = aDroid;
				break;

			}

		}

		readActors.close();

    } //main

} //assignment


class Actor {

	private String type;
	private String name;

	public Actor(String type, String name) {

		this.type = type;
		this.name = name;

	} //actor constructor

	public String getType() {

		return type;

	} //getType

	public String getName() {

		return name;

	} //getName

	public String motto() {

		return "I am an Actor";

	} //default motto

}

class Hero extends Actor {

	public Hero(String name) {

		

	} //hero

	public String motto() {

		return "To the rescue! KAPOW!! BAM!!! POW!!!!";

	} //hero motto

} //hero

class Villain extends Actor {

	public Villain(String name) {

		

	} //villian

	public String motto() {

		return "You'll never stop me! HAHAHAHA!!";

	} //villian motto

} //villain

class Monster extends Actor {

	public Monster(String name) {



	} //monster

	public String motto() {

		return "RRAAAUGGHH GRROWR!!!!";

	} //monster motto

} //monster

class Droid extends Actor {

	private String name;

	public Droid(String name) {



	} //droid

	public String motto() {

		return "Beep Beep Bloop Boop Beep!";

	} //droid motto

} //droid

class Movie {

	public Movie() {



	} //movie
    
} //movie

