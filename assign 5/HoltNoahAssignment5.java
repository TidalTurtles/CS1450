
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.util.Scanner;

public class HoltNoahAssignment5 {

    public static void main(String[] args) throws IOException{

        //part 1 of 2

        // hard array 
        int willBeStack[] = {8, 17, 62, 4, 6, 2, 42, 10, 3, 7};
        
        //now make it a stack
        Stack<Integer> partOneStack = new Stack<Integer>();

        for(int i = 0; i < willBeStack.length; i++) {

            partOneStack.push(willBeStack[i]);

        } //for create stack

       double averageValue = findAverage(partOneStack);

       //part 1 final print out
       System.out.println(" ");
       System.out.println("Stack Values After Finding Average");
       System.out.println("-----------------------------------------------");
       printStack(partOneStack);
       System.out.println(" ");
       System.out.printf("%s\t%, .2f\n\n\n", "Average:", averageValue);

       // part 2 of 2

       // part 2a: numbers.txt

       //open scanner to get numbers
       File numList = new File("numbers.txt");
       Scanner readNums = new Scanner(numList);

       //initialize generic stack
       GenericStack<Integer> numStack = new GenericStack<Integer>();

       //put nums on stack
       do {
            numStack.push(readNums.nextInt());
       } while (readNums.hasNext());

       //don't forget to close scanner
       readNums.close();

       //initial print out
       System.out.println("Numbers from file placed on number stack (unsorted)");
       System.out.println("---------------------------------------------------------------");
       printMyStack(numStack);
       System.out.println(" ");

       //sorted print
       System.out.println("Sorted Number Stack");
       System.out.println("---------------------------------------------------------------");
       GenericStack<Integer> sortNums = new GenericStack<Integer>();
       sortStack(numStack, sortNums);
       printMyStack(sortNums);
       System.out.println(" ");

       //displayAppearanceCounts
       displayAppearanceCounts(sortNums);
       System.out.println(" ");

       //part2b: strings.txt (same as 2a but with strings not ints)
       File stringList = new File("strings.txt");
       Scanner readStrings = new Scanner(stringList);

       GenericStack<String> stringStack = new GenericStack<String>();

       do {
            stringStack.push(readStrings.nextLine().trim());
       } while(readStrings.hasNext());

       readStrings.close();

       System.out.println("Strings from file placed on string stack (unsorted)");
       System.out.println("---------------------------------------------------------------");
       printMyStack(stringStack);
       System.out.println(" ");

       //sorted print
       System.out.println("Sorted String Stack");
       System.out.println("---------------------------------------------------------------");
       GenericStack<String> sortString = new GenericStack<String>();
       sortStack(stringStack, sortString);
       printMyStack(sortString);
       System.out.println(" ");

       //displayAppearanceCounts
       displayAppearanceCounts(sortString);
       System.out.println(" ");

    } //main method

    //part one methods

    public static double findAverage(Stack<Integer> stack) {

        int total = 0;
        //remember that stack.size will change after every iteration
        int iterations = stack.size();
        Stack<Integer> placeHolder = new Stack<Integer>();

        //getting total of all values
        for(int i = 0; i < iterations; i++) {
            total += stack.peek();
            placeHolder.push(stack.pop());
        }

        //now reset original stack
        for(int i = 0; i < iterations; i++) {
            stack.push(placeHolder.pop());
        }

        //calculate average
        double result = (double)total / iterations; 
        return result; 

    } //find average

    public static void printStack(Stack<Integer> stack) {

        //set up variables
        int iteration = stack.size();
        Stack<Integer> placeHolder = new Stack<Integer>();

        //just print and place
        for(int i = 0; i < iteration; i++) {
            System.out.println(stack.peek());
            placeHolder.push(stack.pop());
        }
        // reorder
        for(int i = 0; i < iteration; i++) {
            stack.push(placeHolder.pop());
        }

    } //print normal stack

    //part two methods

    public static <E> void printMyStack(GenericStack<E> stack) {

        //mostly stolen from above printout
        //set up variables
        int iteration = stack.getSize();
        GenericStack<E> placeHolder = new GenericStack<E>();

        //print and place
        for(int i = 0; i < iteration; i++) {
            System.out.println(stack.peek());
            placeHolder.push(stack.pop());
        }
        // re order
        for(int i = 0; i < iteration; i++) {
            stack.push(placeHolder.pop());
        }

    } // print generic stack method

    public static <E extends Comparable<E>> void sortStack(GenericStack<E> unsortedStack, GenericStack<E> sortedStack) {

        while (!unsortedStack.isEmpty()) {
           
            E currentValue = unsortedStack.pop();
            
            while(!sortedStack.isEmpty() && sortedStack.peek().compareTo(currentValue) < 0) {
                unsortedStack.push(sortedStack.pop());
            } // inside while

            sortedStack.push(currentValue);

        } //overaching while

    } // sort stack method.

    public static <E extends Comparable<E>> void displayAppearanceCounts(GenericStack<E> stack) {

        GenericStack<E> blankStack = new GenericStack<E>();
        while(!stack.isEmpty()) {

            E currentValue = stack.pop();
            blankStack.push(currentValue);
            int counter = 1;
            boolean done = false;

            while(!stack.isEmpty() && !done) {

                E nextValue = stack.pop();
                blankStack.push(nextValue);
                if(currentValue.compareTo(nextValue) == 0) {
                    counter += 1;
                }else {
                    done = true;
                    stack.push(nextValue);
                }

            } // inside
            
            while(!blankStack.isEmpty()) {
                blankStack.pop();
            } //

            System.out.println(currentValue + " appeared " + counter + " time(s) on the stack");

        } //Over arching while

    } // display appearance method

} //assignment class

//for part 2 of assignment

class GenericStack<E> {

    private ArrayList<E> list = new ArrayList<E>();

    public GenericStack() {

        

    } //generic stack method

    public boolean isEmpty() {

        if(list.size() == 0) {
            return true;
        } else {
            return false;
        } //if 0 else not

    } // is empty method

    public int getSize() {

        return list.size();  //is this cheating or not?

    } // get size method

    public E peek() {

        int last = list.size() -1;
        return list.get(last);

    } //peek method

    public E pop() {

        int last = list.size() -1;
        E wasRemoved = list.get(last);
        list.remove(last);
        return wasRemoved;

    } // pop method
    
    public void push(E value) {

        list.add(value);

    } // push method

} //generic stack class
