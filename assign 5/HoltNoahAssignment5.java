
import java.io.IOException;
import java.util.*;

public class HoltNoahAssignment5 {

    public static void main(String[] args) throws IOException{

        //part 1 of 2

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

    } //main method

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

        double result = (double)total / iterations; //filler
        return result; //filler

    } //find average

    public static void printStack(Stack<Integer> stack) {

        int iteration = stack.size();
        Stack<Integer> placeHolder = new Stack<Integer>();
        //re-orient stack so reading from front to back
        for(int i = 0; i < iteration; i++) {
            placeHolder.push(stack.pop());
        }
        // now print and reassign to original stack
        for(int i = 0; i < iteration; i++) {
            System.out.println(placeHolder.peek());
            stack.push(placeHolder.pop());
        }

    } //print stack

} //assignment class

//for part 2 of assignment

class GenericStack<E> {

    public GenericStack() {


    } //generic stack method

    public boolean isEmpty() {

        return false; //filler

    } // is empty method

    public int getSize() {

        return 0; //filler

    } // get size method

    /*  need to create later

    public E peek() {

        

    } //peek method

    public E pop() {



    } // pop method
    */
    public void push () {



    } // push method

} //generic stack class
