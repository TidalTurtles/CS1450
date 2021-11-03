
/* Noah Holt
 * CS1450 Data Structures
 * T/Thr section
 * Due 4 Nov
 * Assignment 8
 * This assignment is a Decoder to find out the mystery of the parrots
 * next location that we will use to help us explore further Array Lists,
 * Queues, Stacks as well as start our understandings of how to use iterators.
 */

 // copied over all imports from assignment 7, probably won't need all 
 // but might need some more too.
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class HoltNoahAssignment8 {

    public static void main(String[] args) throws IOException {

        

    } // main method

} //assignment class

// class that will do all the work
class SecretTranslator {

    //private data fields
    private Stack myStack;

    //constructor method
    public SecretTranslator() {

        this.myStack = new Stack();

    } //constructor

    // actually decodes the message in 2 steps
    //step 1: traverse the key to see where to get the char
    //step 2: undo the reversal of the message from where it was put on the stack
    public String decode(Iterator<Character> msg1Iterator, Iterator<Integer> msg2Interator, Iterator<Integer> keyIterator) {

        //example for/if loop in assignment notes
        //step 1

        return "Hello"; //placeHolder

    }

} //secret translator class

//class defining what our stack can do
class Stack {

    //private data fields
    private ArrayList<Character> storage;

    //constructor method
    public Stack() {

        this.storage = new ArrayList<Character>();

    } // constructor method

    //is empty method (return bool)
    public boolean isEmpty() {
        if(storage.isEmpty() == true) {
            return true;
        } else {
            return false;
        } //if empty
    } //is empty method

    //get size of stack
    public int getSize() {
        return storage.size();
    } //get size method

    //push: add element to the stack
    public void push(Character value) {
        storage.add(value);
    } // push method 

    //pop: remove and return
    public char pop() {
        int last = storage.size();
        return (char)storage.remove(last-1);
    } //pop method

} // stack class
