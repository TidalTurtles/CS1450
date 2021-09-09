import java.io.File;

public class HoltNoahAssignment2{

    public static void main(String[] args) {

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


    }

}

class actor {

	private String type;
	private String name;

	public actor(String type, String name) {



	}

	public String getType() {

		return type;

	}

	public String getName() {

		return name;

	}

	public String motto() {

		return "I am an Actor";

	}

}

class hero extends actor {



}

class villain extends actor {



}

class monster extends actor {



}

class droid extends actor {



}

class movie {


    
}