

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
import java.util.Scanner;


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

	//Step 3: Sort Itinerary by stop number
		//bubble sort
		singleList.bubbleSort();
		//print again
		System.out.println("Sorted List");
		singleList.printList();

	//Step 4: Update File
		//open file and scanner
		File updatedTravelPlan = new File("JapanItineraryUpdates.txt");
		Scanner readUpdates = new Scanner(updatedTravelPlan);

		//read in from file (format is Dest, Stop, type, name, activity)
		while(readUpdates.hasNext()) {
			//get data
			String aDestination = readUpdates.next();
			int aStop = readUpdates.nextInt();
			String aType = readUpdates.next();
			String aName = readUpdates.next();
			String anActivity = readUpdates.nextLine();
			//make dest
			Destination activeDestination = new Destination(aStop, aType, aName, anActivity);
			//update single
			singleList.updateItinerary(aDestination, activeDestination);
			//also add to double
			doubleList.addDestination(activeDestination);

		}
		
		//done with file
		readUpdates.close();

		//now print single
		System.out.println("Add Adventures");
		singleList.printList();

	//Step 5: Final Step: Double linked list
		System.out.println("Backwards Adventures");
		doubleList.printListBackwards();
		
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
		
		//create temp
		Node temp = head;
		Node afterTemp = temp.next;
		//until found 
		if(insertBeforeDestinatino.equals(temp.destination.getName())) {
			addDestination(adventureDestination);
		} else{
			while(!afterTemp.destination.getName().equals(insertBeforeDestinatino)) {
				temp = temp.next;
				afterTemp = temp.next;
			}// while next is not what we want

			Node adventure = new Node(adventureDestination);
			adventure.next = afterTemp;
			temp.next = adventure;

		} //if else insert
		
	} //Itinerary / update Itinerary
	
	public void bubbleSort() {
		
		// create temp node
		Node temp = head; //will change in for loop
		//for stop we want
		for(int i = 1; i < size; i++) {
			//create current place holder
			Node current = temp;
			//check for stop number
			while(current.destination.getStop() != i) {
				current = current.next;
			}
			//now current is stop we want
			swapNodeData(current, temp);
			//step over temp
			temp = temp.next;
			
		} //for sorting

	} //Itinerary / sort
	
	public void swapNodeData(Node node1, Node node2) {

		//temp Dest
		Destination temp = node1.destination;
		//perform swap
		node1.destination = node2.destination;
		node2.destination = temp;

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
		
		//add to END of list
		Node newNode = new Node(destination);
		if(head == null) { //list is empty
			head = tail = newNode;
		} else{ //list not empty
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}

	} //double / add Destination
	
	public void printListBackwards() {
		
		//create temp node at tail
		Node temp = tail;
		//print table header
		System.out.println("");
		System.out.printf("%18s\t%8s\t%s\n", "Dest Name", "Type", "Activity");
		System.out.println("-----------------------------------------------------------------------------");

		//whlie not at head
		while(temp.previous != null) {
			System.out.println(temp.destination.toString());
			temp = temp.previous;
		}
		//print head last
		System.out.println(temp.destination.toString());
		System.out.println("");
		
	} //double / print backwards
	
	private static class Node {
		
		//private data
		private Destination destination;
		private Node previous;
		private Node next;
		
		public Node(Destination destination) {
			
			this.destination = destination;
			this.previous = null;
			this.next = null;
			
		} //node / constructor
		
	} //Node inner class double
	
} //double linked list class

