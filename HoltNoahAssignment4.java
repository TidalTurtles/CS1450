
import java.io.File;
import java.io.IOException;
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
        for(int i = 0; i < 6; i++) { //hard coded 6 because of missing values
            // need to figure out how to itterate through without the hardcode.

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

        } // for loop

        //closing out
        readTrains.close();

        myRailroad.displaySortingYard();
        

        
        

    } // main method

    public static void printTrainReport(Railroad railroad) {

        

    }

} //assignment class

class Railroad {

    private int numberTracks;
    private Train[] sortingYard;

    public Railroad(int numberTracks) {

        sortingYard = new Train[numberTracks];

    } // railroad method

    public int getNumberTracks(int numberTracks) {

        return this.numberTracks;

    } //getter method

    public void addTrainToSortingYard(int trackNumber, Train train) {

        sortingYard[trackNumber] = train;

    } // add trains

    public Train getTrainInSortingYard(int numberTracks) {

        return sortingYard[1]; //place holder

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

class Train implements Comparable<Train>{

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
            return -1;
        } else if (numRailCars > otherTrain.numRailCars) {
            return 1;
        } else {
            return 0;
        } //if else

    } // compare method

}// train class
