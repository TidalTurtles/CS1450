
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class HoltNoahAssignment8 {

    public static void main(String[] args) throws IOException {

        // 2 step proccess

        //step 1 (known message) w/ Array Lists
        //open files
        File charFile = new File("arrayMessage1.txt");
        File intFile = new File("arrayMessage2.txt");
        File keyFile = new File("arrayKey.txt");

        //scanners for files
        Scanner getChars = new Scanner(charFile);
        Scanner getAscii = new Scanner(intFile);
        Scanner getKey = new Scanner(keyFile);

        //declare array lists
        ArrayList<Character> charArray = new ArrayList<>();
        ArrayList<Integer> intArray = new ArrayList<>();
        ArrayList<Integer> keyArray = new ArrayList<>();

        //making the arrayLists
        //first char files
        String decodeMe = getChars.nextLine();
        for(int i = 0; i < decodeMe.length(); i++) {
            charArray.add(decodeMe.charAt(i));
        }

        //ascii values
        while(getAscii.hasNext()) {
            intArray.add(getAscii.nextInt());
        } //adds till completion

        //key values
        while(getKey.hasNext()) {
            keyArray.add(getKey.nextInt());
        }
        
        //create iterators
        Iterator<Character> arrayListIterator1 = charArray.iterator();
        Iterator<Integer> arrayListIterator2 = intArray.iterator();
        Iterator<Integer> arrayListIteratorKey = keyArray.iterator();

        //time to decode this message
        //make decoder
        SecretTranslator arrayListMessage = new SecretTranslator();
        //use decoder
        String message1 = arrayListMessage.decode(arrayListIterator1, arrayListIterator2, arrayListIteratorKey);

        System.out.println("the secret string 1 is: " + message1);

        //dont forget to close files
        getChars.close();
        getAscii.close();
        getKey.close();

        //step 2 (mystery message) w/ queues
        //open files
        File charFile2 = new File("queueMessage1.txt");
        File intFile2 = new File("queueMessage2.txt");
        File keyFile2 = new File("queueKey.txt");

        //scanners for files
        Scanner getChars2 = new Scanner(charFile2);
        Scanner getAscii2 = new Scanner(intFile2);
        Scanner getKey2 = new Scanner(keyFile2);

        //declare array lists
        Queue<Character> charQueue = new LinkedList<>();
        Queue<Integer> intQueue = new LinkedList<>();
        Queue<Integer> keyQueue = new LinkedList<>();

        //making the arrayLists
        //first char files
        String decodeMe2 = getChars2.nextLine();
        for(int i = 0; i < decodeMe2.length(); i++) {
            charQueue.add(decodeMe2.charAt(i));
        }

        //ascii values
        while(getAscii2.hasNext()) {
            intQueue.add(getAscii2.nextInt());
        } //adds till completion

        //key values
        while(getKey2.hasNext()) {
            keyQueue.add(getKey2.nextInt());
        }
        
        //create iterators
        Iterator<Character> queueIterator1 = charQueue.iterator();
        Iterator<Integer> queueIterator2 = intQueue.iterator();
        Iterator<Integer> queueIteratorKey = keyQueue.iterator();

        //time to decode this message
        //make decoder
        SecretTranslator queueMessage = new SecretTranslator();
        //use decoder
        String message2 = queueMessage.decode(queueIterator1, queueIterator2, queueIteratorKey);

        System.out.println("the secret string 2 is: " + message2);

        //dont forget to close files
        getChars2.close();
        getAscii2.close();
        getKey2.close();

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

        //step 1
        while(keyIterator.hasNext()) {
            int fromKey = keyIterator.next();
            if(fromKey == 0) {
                myStack.push(msg1Iterator.next());
            } else {
                int changeMe = msg2Interator.next();
                char pushMe = (char)changeMe;
                myStack.push(pushMe);
            } // if one or zero
        } //while loop has next

        //now turn the stack into a string
        char[] secretMessage = new char[myStack.getSize()];
        for(int i = 0; i < secretMessage.length; i++) {
            secretMessage[i] = myStack.pop();
        }
        String finalMessage = new String(secretMessage);
        
        return finalMessage; //placeHolder

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
