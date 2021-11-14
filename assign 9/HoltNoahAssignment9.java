

/*Noah Holt
 * CS1450 Data Structures
 * Tues/Thurs Section
 * Due 16 Nov
 * Assignment 9
 *This assignment is to explore linked lists by creating destinations 
 *objects for the parrots that last week we discovered were going to 
 *japan. So we will read those destination from some files and place them
 *into a linked list, order that linked list. After that we will get more 
 *places, add them to the initial linked list as well as a double linked 
 *list and the print that list backwards.
 *
 *Step 1: create linked lists
 *
 *Step 2: place in Itinerary to the single linked list and print it
 *
 *Step 3: Sort that list and print again
 *
 *Step 4: Update list with more places (different order in file)
 *
 *Step 5: Create double linked list and print backwards
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class HoltNoahAssignment9 {

	public static void main(String[] args) throws IOException {
		
		//Step 1 create linked lists
		ItineraryLinkedList singleList = new ItineraryLinkedList();
		DoubleLinkedList doubleList = new DoubleLinkedList();

		//Step 2: fill singleListwith first Itinerary
		//open file for reading
		File travelPlan = new File("JapanItinerary.txt");
		Scanner readPlan = new Scanner(travelPlan);

		//read file into objects
		//file is (Stop(int), Type(string), Name(string), Activity(nextLn))
		while(readPlan.hasNext()) {
			//get info
			int aStop = readPlan.nextInt();
			String aType = readPlan.next();
			String aName = readPlan.next();
			String anActivity = readPlan.nextLine();
			//make Destination
			Destination aDestination = new Destination(aStop, aType, aName, anActivity);
			//place in linked list
			singleList.addDestination(aDestination);
		} //while reading file
		
		//don't need file any more
		readPlan.close();

		//print the list after reading
		singleList.printList();
		
	} //Assignment / Main method

} //Assignment Class

//class for the creation of our destination objects
class Destination {
	
	//create private data fields
	private int stop;
	private String type;
	private String name;
	private String activity;
	
	public Destination(int stop, String type, String name, String activity) {
		
		this.stop = stop;
		this.type = type;
		this.name = name;
		this.activity = activity;
		
	} //Destination / destination constructor
	
	//get and set Stop
	public int getStop() {
		return stop;
	} //destination / get stop number
	
	public void setStop(int stop) {
		this.stop = stop;
	} //destination / set stop number
	
	// get and set type
	public void setType(String type) {
		this.type = type;
	} //destination / set type
	
	public String getType() {
		return type;
	} //destination / get type
	
	//get and set name 
	public void setName(String name) {
		this.name = name;
	} //destination / set name
	
	public String getName() {
		return name;
	} //destination / get name
	
	//get and set activity
	public void setActivity(String activity) {
		this.activity = activity;
	} //destination / set activity
	
	public String getActivity() {
		return activity;
	} //destination / get activity
	
	public String toString() {
		String format = String.format("%18s\t%8s\t%s", name, type, activity);
		return format;
	} //Destination / to string method
	
} // Destination class

//this will be the singly linked list which will hold the destinations
//and a bubble sort.
class ItineraryLinkedList {
	
	//private data fields
	Node head;
	int size;
	
	public void itineraryLinkedList() {
		
		this.head = null;
		this.size = 0;
		
	} //Itinerary / constructor
	
	//just one getter for size
	public int getSize() {
		return size;
	} //Itinerary / get size
	
	public void addDestination(Destination destinationToAdd) {

		//add new dest to FRONT of list and update size
		Node newNode = new Node(destinationToAdd);
		if(head == null) {
			head = newNode;
		} else{
			newNode.next = head;
			head = newNode;
		}
		size++;
		
	} //Itinerary / add destination
	
	public void updateItinerary(String insertBeforeDestinatino, Destination adventureDestination) {
		
	} //Itinerary / update Itinerary
	
	public void bubbleSort() {
		
		
	} //Itinerary / sort
	
	public void swapNodeData(Node node1, Node node2) {
		
	} //Itinerary / swap nodes
	
	public void printList() {

		//get place holder
		Node iterateMe = head;

		//print table header
		System.out.println("");
		System.out.printf("%18s\t%8s\t%s\n", "Dest Name", "Type", "Activity");
		System.out.println("-----------------------------------------------------------------------------");

		while(iterateMe.next != null) {
			System.out.println(iterateMe.destination.toString());
			iterateMe = iterateMe.next;
		}
		//finally print last one 
		System.out.println(iterateMe.destination.toString());
		System.out.println("");

	} //Itinerary / print the list
	
	private class Node {
		
		//private fields
		private Destination destination;
		private Node next;
		
		//constructor
		public Node(Destination destination) {
			this.destination = destination;
			next = null;
		} //Node / constructor
		
	} //Node inner class Itinerary
 	
} //Itinerary linked list class

//lastly is the double linked list 
//simplified so I can better understand it
class DoubleLinkedList {
	
	//private data fields
	private Node head;
	private Node tail;
	
	public void doubleLinkedList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	} //double / constructor
	
	public void addDestination(Destination destination) {
		
	} //double / add Destination
	
	public void printListBackwards() {
		
		
	} //double / print backwards
	
	private class Node {
		
		//private data
		private Destination destination;
		private Node previous;
		private Node next;
		
		public void node(Destination destination) {
			
			this.destination = destination;
			this.previous = null;
			this.next = null;
			
		} //node / constructor
		
	} //Node inner class double
	
} //double linked list class

