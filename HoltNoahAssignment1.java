import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HoltNoahAssignment1 {

	public static void main(String[] args) throws IOException{
		/*Noah Holt
		 * CS1450 Data Structures
		 * T/Thr section
		 * Due 2 Sept
		 * Assignment 1
		 * This assignment is to refresh on what was forgotten after last semester
         * we will hard code two arrays and then minipulate them and write them to 
         * a file, and lastly read that file into a new array.
		 */

        int[] array1 = {13,18, 1, 4, 8, 16, 11};
        int[] array2 = {9, 10, 5, 12, 3, 7, 14};

        //print out arrays

        System.out.println("Array1: original");
        System.out.println("--------------------------");

        for (int i = 0; i < array1.length; i++) {

            System.out.print("array1[" + i + "] = ");
            System.out.println(array1[i]);

        } //print out for loop

        System.out.println("");
        System.out.println("");
        System.out.println("Array2: original");
        System.out.println("--------------------------");

        for (int i = 0; i < array2.length; i++) {

            System.out.print("array2[" + i + "] = ");
            System.out.println(array2[i]);

        } //print out for loop

        

        //find out how to reassign and place here.

        for (int i = 0; i < array1.length; i++) {

            int isOdd = array1[i];
            if (isOdd%2 != 0) {

                int j = 0;
                boolean found = false;

                while (j < array2.length && found == false) {

                    if (array2[j]%2 == 0) {
                        found = true;
                    } else {
                        j = j+1;
                    }

                } //find even while loop

                if (found == true) {

                    array1[i] = array2[j];
                    array2[j] = isOdd;

                } //swap it if loop

            } //if array1 odd

        } //swap values for loop

        //sort through and reassign arrays.

        Arrays.sort(array1);
        Arrays.sort(array2);


        //print out new arrays

        System.out.println("");
        System.out.println("");
        System.out.println("Array1: Sorted with Even Values");
        System.out.println("--------------------------");

        for (int i = 0; i < array1.length; i++) {

            System.out.print("array1[" + i + "] = ");
            System.out.println(array1[i]);

        } //print out for loop

        System.out.println("");
        System.out.println("");
        System.out.println("Array2: Sorted with Odd Values");
        System.out.println("--------------------------");

        for (int i = 0; i < array2.length; i++) {

            System.out.print("array2[" + i + "] = ");
            System.out.println(array2[i]);

        } //print out for loop
        
        //writing the file

        File orderdList = new File("assignment1.txt");
        PrintWriter outputList = new PrintWriter(orderdList);



        outputList.close();
        //reading the file

        Scanner readFile = new Scanner(orderdList);


    
        readFile.close();

    } //main
    
} //assignment class 