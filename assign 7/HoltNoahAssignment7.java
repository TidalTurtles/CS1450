// CS 1450 Assignment #4 Solution Fall 2021
// Topic: Nested Objects, Arrays, ArrayLists, Comparable, and Collections
//
// Note: 
// This solution code may not be copied, doing so will result in a grade of zero.
// This solution is not for distribution online or by any other means. Copyright M. Gonzalez UCCS

// Went ahead and downloaded the solutions for this code
//just in case there was something wrong or different about
//mine that I might have missed so that I can start where I 
//need to with something that is definitely working and set up for 
//this particular assignment.
//Also noticing a lot more comments in the solutions than I ever
//put in any assignment, will try to do better about that from here 
//on I guess (sorry this is the first time I have ever actually
//looked at a solutions document)

//oops forgot this step in the last assignment
/*Noah Holt
 * CS1450 Data Structures
 * T/Thr section
 * Due 28 Oct
 * Assignment 7
 * This assignment is an extention of assignment for where
 * we get to practice and utilize the different queue types
 * using our different train objects and the associated classes
 * and methods and also add some new ones (a departure and receiving 
 * methods in particular).
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class HoltNoahAssignment7 {

	public static void main(String[] args) throws IOException {
		
		// Name of files to read from
		final String TRAINS_FILE_NAME = "Trains7.txt";
		final String RAIL_CARS_FILE_NAME = "RailCars7.txt";	

		// Setup a file reference variable to refer to text file
		File trainsFileName = new File(TRAINS_FILE_NAME);
		File railCarsFileName = new File(RAIL_CARS_FILE_NAME);

		// Open the file for reading by creating a scanner for the file
		// First value in the file tells how many tracks the railroad sorting yard contains
		Scanner trainsFile = new Scanner (trainsFileName);
		Scanner railCarsFile = new Scanner (railCarsFileName);
		int numberTracks = trainsFile.nextInt();

		// Create the railroad with the number of sorting yard tracks specified in the file
		RailroadF21 railroad = new RailroadF21(numberTracks);

		// Load the railroad's sorting yard tracks with trains  
		System.out.println("Loading trains onto tracks in sorting yard...");
		System.out.println();

		// Create the train objects from the details provided in the file
		// Student Note: In this assignment you are not told how many train objects are in the file so you
		// need to use a while loop and the hasNext method on the Scanner to read train objects until the
		// end of the file is reached.
		while (trainsFile.hasNext()) {
			
			// Read information from one line in the file into separate variables
			// The last value on the line is the name of the destination city so use a nextLine to 
			// consume the entire string from the file.
			int trackNumber = trainsFile.nextInt();
			int engineNumber = trainsFile.nextInt();
			String company = trainsFile.next();
			int numberCars = trainsFile.nextInt();
			String type = trainsFile.next();
			String destCity = trainsFile.nextLine().trim();

			// Create a train object
			// Move train to its correct track in the sorting yard (slot in array)
			TrainF21 train = new TrainF21(engineNumber, company, numberCars, type, destCity);			
			railroad.addTrainToSortingYard(trackNumber, train);

		} // while more trains

		//now for assignment 7

		//creating rail car objects from the provided file format
		//part b of this assignment
		while(railCarsFile.hasNext()) {

			//set up in file is car num, type, then destination
			int carNum = railCarsFile.nextInt();
			String carType = railCarsFile.next();
			String carDest = railCarsFile.nextLine();

			//use above criteria for the railcar objects
			//then send those objects to the receiving track
			RailCarF21 railCar = new RailCarF21(carNum, carType, carDest);
			railroad.addRailCarToReceivingTrack(railCar);

		} // while rail cars

		// Close the trains files
		trainsFile.close();
		railCarsFile.close();

		///Display the railroad's sorting yard  
		railroad.displaySortingYard();

		// More assignment 7
		//part b continued is to display the receiving track once filled
		railroad.displayReceivingTrack();

		// part c step 1
		// set up railroad controller  to put the railcars on
		// the trains and display table as in assignment 


	} // main

} // Assignment4


// Represents a railroad.  A railroad is a complex series of tracks for storing, sorting, 
// loading, and unloading cars and engines.  Our railroad contains one sorting yard with 
// several tracks.  The sorting yard is modeled with an array.
class RailroadF21 {
	
	private int numberTracks;													// Number of tracks the sorting yard contains
	private TrainF21[] sortingYard;												// Yard where trains are assembled and wait to move to main line
	private Queue<RailCarF21> receivingTrack = new LinkedList<>();					// Regular Queue of Rail Cars
	private PriorityQueue<TrainF21> departureTrack = new PriorityQueue<>();		// Priority queue to depart the largest train
								// This is a HAS-A relationship - Railroad HAS-A sorting yard
								// Don't make an arrayList because of insertion rules
	
	public RailroadF21 (int numberTracks) {
		this.numberTracks = numberTracks;
		
		// Allocate memory for the sorting yard array which has a certain number of tracks (slots) 
		sortingYard = new TrainF21[numberTracks];
	}

	// Returns the number of tracks in the sorting yard
	public int getNumberTracks() {
		return numberTracks;
	}
		
	// Add a train to the sorting yard to a specific track
	public void addTrainToSortingYard (int trackNumber, TrainF21 train) {
		sortingYard[trackNumber] = train;
	}
	
	// Returns the train in the specified track in the sorting yard array.  
	// When a track does NOT contain a train return null.
	public TrainF21 getTrainInSortingYard(int trackNumber) {
		
		// Return the train which could be null if the slot is empty
		// Student Note: When you created the array, Java initialized the array with null values
		return sortingYard[trackNumber];
	}

	// Display all trains in the sorting yard
	public void displaySortingYard () {
		
		// Display header 
		System.out.println ("-------------------------------------------------------------------------------------------");
		System.out.printf("%s\t%s\t%s\t\t%s\t%s\t\t%s\n", "Track", "Engine", "Company", "Rail Cars", "Type", "Destination");
		System.out.println ("-------------------------------------------------------------------------------------------");

		// For each track print the train if there is one
		for (int track = 0; track < numberTracks; track++) {
			
			// Get train in current track
			TrainF21 train = sortingYard[track];
				
			// If there is a train in this track display it's details
			// If there is no train display dashes
			if (train != null) {
				System.out.println (track + "       " + train.toString());				
			}
			else {
				System.out.printf ("%d\t%s\t%s\t\t%s\t\t%s\t\t%s\n", track, "----", "----", "----", "----", "----");
			}
				
		} // for each track
		
		System.out.println();
		
	} // displaySortingYard

	//assignment 7 methods

	//receiving rail cars
	//first to check if receiving is empty
	public boolean isReceivingTrackEmpty() {

		if(receivingTrack.isEmpty() == true) {
			return true;
		} else {
			return false;
		}

	} //is empty

	//need to add things to the queue
	public void addRailCarToReceivingTrack(RailCarF21 railCar) {

		receivingTrack.add(railCar);

	} //adding cars

	//take it away too
	public RailCarF21 removeRailCarFromReceivingTrack() {

		RailCarF21 notIn = receivingTrack.remove();
		return notIn;

	} //take it away

	//departing Trains
	//is it empty
	public boolean isDepartureTrackEmpty() {

		if(departureTrack.isEmpty() == true) {
			return true;
		} else {
			return false;
		} // if else

	} //is it empty

	//add on those trains
	public void addTrainToDepartureTrack(TrainF21 departingTrain) {
		departureTrack.add(departingTrain);
	} //add on those trains

	//done with train so remove
	public TrainF21 removeTrainFromDepartureTrack() {
		TrainF21 notIn = departureTrack.remove();
		return notIn;
	} //take it away boys

	//other methods to add for assignment 7
	//find the train to give the railcar with same destination and type
	public int findTrain(RailCarF21 railcar) {
		
		return 1; //place holder

	} //finding the train

	//add rail cars to train queue
	public void addRailCarToTrainInSortingYard(RailCarF21 railcar, int trackNumber) {



	} //add it on

	// remove the train from sorting yard track
	public void removeTrainFromSortingYard(int trackNumber) {



	} // take it out of the sorting yard

	//display the receiving track
	public void displayReceivingTrack() {

		//table header
		System.out.println("---------------------------------------------------");
		System.out.printf("%s\t%s\t%s\n", "Car Number", "Type", "Destination");
		System.out.println("---------------------------------------------------");

		//itrerate through and display
		Queue<RailCarF21> tempCars = new LinkedList<>();
		RailCarF21 tempPrint;
		while(!receivingTrack.isEmpty()) {
			tempPrint = receivingTrack.remove();
			tempCars.add(tempPrint);
			System.out.println(tempPrint.toString());
		}
		//now reset the receiving yard
		receivingTrack = tempCars;

	} //displaying receiving track

} // RailroadYard


// Represents a train 
class TrainF21 implements Comparable<TrainF21>{
	
	private int engineNumber;								// Train's engine number
	private String company;									// Train's company such as BNSF, CSX, Union Pacific, etc
	private int numberRailCars;		    					// Number of rail cars the train contains
	private String type;									// Type of train (i.e. passenger, freight, etc.)
	private String destinationCity;							// Where train is departing to
	private Queue<RailCarF21> railCars = new LinkedList<>(); 	// represents rail cars to make up the trains

	// Create a train
	public TrainF21 (int engineNumber, String company, int numberRailCars, String type, String destinationCity) {
		this.engineNumber= engineNumber;
		this.company = company;
		this.numberRailCars = numberRailCars;
		this.type = type;
		this.destinationCity = destinationCity;
		Queue<RailCarF21> railCars = new LinkedList<>();
	}
	
	public int getEngineNumber() {
		return engineNumber;
	}

	public String getCompany() {
		return company;
	}

	public int getNumberRailCars() {
		return numberRailCars;
	}
	
	public String getType() {
		return type;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	// This method overrides the toString method in the Object class.
	// It creates a printable string to describe the train
	@Override 
	public String toString() {
		return String.format("%d\t%s\t\t%d\t\t%-15s\t%s",
				 engineNumber, 
				 company, 										
				 numberRailCars, 
				 type, 
				 destinationCity);	
		
	} // toString

	@Override // This is where we write the code to compare two trains.
	// In this assignment, compare two trains based on the number of rail cars in each train.
	// By writing this method, it will now be possible to sort an array of trains by the
	// number of rail cars when calling the Collections.sort method	
	public int compareTo(TrainF21 otherTrain) {
	
		// Student Note: numberRailCars is a private data field in the Train and since we are inside the  
		// Train class we can access numberRailcars directly. Thus, there is no need to use getter.  Also,
		// the use of "this" is not needed.  I included on this assignment to help make it clear for students.
		if (this.numberRailCars < otherTrain.numberRailCars) {
			return 1;
		}
		else if (this.numberRailCars > otherTrain.numberRailCars) {
			return -1;
		}
		else {
			return 0;
		}

	} // compareTo

	//assignment 7 update

	//adding Rail cars
	public void addRailCar(RailCarF21 railcar) {
		railCars.offer(railcar);
	} //adding rail cars

} // Train

// Rail Cars for assignment 7

class RailCarF21 {

	//class private vars
	int carNumber;
	String carType;
	String carDestination;

	//constructor
	public RailCarF21(int carNumber, String carType, String carDestination) {

		//initialize vars
		this.carNumber = carNumber;
		this.carType = carType;
		this.carDestination = carDestination;

	} //rail car constructor

	//getters

	//getnum
	public int getCarNumber() {
		return carNumber;
	} //get number

	//get type
	public String getCarType() {
		return carType;
	} //get Type

	//get destination
	public String getCarDestination() {
		return carDestination;
	} //get destination

	//make one string
	public String toString() {
		String printOut = String.format("%d\t%12s\t%s", carNumber, carType, carDestination);
		return printOut;
	} //make String
 
} //Rail car class

//need the controller to play
class RailroadControllerF21 {

	//place cars in receiving queue then move to trains in sorting yard
	public void moveRailCarsToTrains (RailroadF21 railroad) {

		

	} //move rail cars

	//move trains from sorting yard to departure track and prints
	public void moveTrainsToDepartureTrack(RailroadF21 railroad) {



	} // move trains

	//sends trains out for departure
	public void clearedForDeparture(RailroadF21 railroad) {



	} //clear it out

} //controller Class

