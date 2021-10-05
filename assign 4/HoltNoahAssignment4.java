
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class HoltNoahAssignment4 {
    
    public static void main(String[] args) throws IOException{

        //open things up
        File trainList = new File("Trains.txt");
        Scanner readTrains = new Scanner(trainList);

        //read and create railroad
        int numSortingTracks = readTrains.nextInt();
        Railroad myRailroad = new Railroad(numSortingTracks);

        //send in the trains
        while(readTrains.hasNext()) { 

            int trackNum = readTrains.nextInt();
            int engineNumber = readTrains.nextInt();
            String companyName = readTrains.next();
            int carNumber = readTrains.nextInt();
            String trainType = readTrains.next();
            String trainCity = readTrains.next().trim();

            //now make train
            Train aTrain = new Train(engineNumber, companyName, carNumber, trainType, trainCity);
            //send to sorting yard
            myRailroad.addTrainToSortingYard(trackNum, aTrain);

        } // while loop

        //closing out
        readTrains.close();

        myRailroad.displaySortingYard();
        
        printTrainReport(myRailroad);
        
        

    } // main method

    public static void printTrainReport(Railroad railroad) {

        // init array list
        ArrayList<Train> reportTrains = new ArrayList<Train>();
        // put trains in array list
        for(int i = 0; i < railroad.getNumberTracks(); i++) {

            if(railroad.getTrainInSortingYard(i) != null){
                reportTrains.add(railroad.getTrainInSortingYard(i));
            } // single if

        } // for loop

        //now to sort trains
        Collections.sort(reportTrains);

        // finally print it out
        System.out.println("-------------------------------------------------------");
        System.out.println(String.format("\t\t%s", "Train Report"));
        System.out.println(String.format("\t%s", "(Ordered by Number of Rail Cars)"));
        System.out.println("-------------------------------------------------------");
        System.out.println(String.format("%s\t%s\t\t%s\t%s\t\t%s", "Engine", "Company", "Rail Cars", "Type", "Departing to"));
        System.out.println("-------------------------------------------------------");
        for(int i = 0; i < reportTrains.size(); i++) {
            System.out.println(reportTrains.get(i).toString());
        } //display for loop

    } // print display

} //assignment class

class Railroad {

    private int numberTracks;
    private Train[] sortingYard;

    public Railroad(int numberTracks) {

        this.numberTracks = numberTracks;
        sortingYard = new Train[numberTracks];

    } // railroad method

    public int getNumberTracks() {

        return this.numberTracks;

    } //getter method

    public void addTrainToSortingYard(int trackNumber, Train train) {

        sortingYard[trackNumber] = train;

    } // add trains

    public Train getTrainInSortingYard(int trackNumber) {

       if(sortingYard[trackNumber] == null) {
           return null;
       } else {
           return sortingYard[trackNumber];
       } // if else
        
    } //get trains

    public void displaySortingYard() {
       
        // header of table
        System.out.println("---------------------------------------------------------------------");
        String printable = String.format("%s\t%s\t%s\t\t%s\t%s\t%s", "Tracks", "Engine", "Company", "Rail Cars", "Type", "Destination");
        System.out.println(printable);
        System.out.println("---------------------------------------------------------------------");

        // print actual trains
        for(int i = 0; i < sortingYard.length; i++) {

            //if null
            if(sortingYard[i] == null) {
                System.out.print(i);
                String printBlank = String.format("\t%s\t%s\t\t%s\t%s\t%s", "---", "---", "---", "---", "---");
                System.out.println(printBlank);
            } else {
                System.out.print(i);
                String printActual = String.format("\t%d\t%s\t\t%d\t%s\t%s", sortingYard[i].getEngineNumber(), sortingYard[i].getCompany(), sortingYard[i].getNumRailCars(), sortingYard[i].getType(), sortingYard[i].getCity());
                System.out.println(printActual);
            } // if else

        } // display for loop

    } // display table 

} //railroad class

class Train implements Comparable<Train> {

    private int engineNumber;
    private String company;
    private int numRailCars;
    private String type;
    private String destinationCity;

    public Train(int engineNumber, String company, int numRailCars, String type, String destinationCity) {

        this.engineNumber = engineNumber;
        this.company = company;
        this.numRailCars = numRailCars;
        this.type = type;
        this.destinationCity = destinationCity;

    } // train method

    public int getEngineNumber() {
        return this.engineNumber;
    } // getter engine number

    public String getCompany() {
        return this.company;
    } //getter company

    public int getNumRailCars() {
        return this.numRailCars;
    } // getter rail cars
    
    public String getType() {
        return this.type;
    } // get type

    public String getCity() {
        return this.destinationCity;
    } // get city

    @Override
    public String toString() {

        return String.format("%d\t%s\t\t%d\t\t%-15s\t%s", engineNumber, company, numRailCars, type, destinationCity);

    } // to string method

    @Override
    public int compareTo(Train otherTrain) {

        if(numRailCars < otherTrain.numRailCars) {
            return 1;
        } else if (numRailCars > otherTrain.numRailCars) {
            return -1;
        } else {
            return 0;
        } //if else

    } // compare method

}// train class
