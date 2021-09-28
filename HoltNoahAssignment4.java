
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class HoltNoahAssignment4 {
    
    public static void main(String[] args) throws IOException {

        //open things up
        File trainList = new File("Trains.txt");
        Scanner readTrains = new Scanner(trainList);

        //read and create railroad
        int numSortingTracks = readTrains.nextInt();
        Railroad myRailroad = new Railroad(numSortingTracks);

        //send in the trains
        for(int i = 0; i < numSortingTracks; i++) {

            int trackNum = readTrains.nextInt();
            int engineNumber = readTrains.nextInt();
            String companyName = readTrains.next();
            int carNumber = readTrains.nextInt();
            String trainType = readTrains.next();
            String trainCity = readTrains.nextLine();

            //now make train
            Train aTrain = new Train(engineNumber, companyName, carNumber, trainType, trainCity);
            //send to sorting yard
            myRailroad.addTrainToSortingYard(trackNum, aTrain);
            
        }

        // closing out
        readTrains.close();

    } // main method

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



    } // add trains

    public Train getTrainInSortingYard(int numberTracks) {

        return sortingYard[1]; //place holder

    } //get trains

} //railroad class

class Train implements Comparable<Train>{

    private int engineNumber;
    private String company;
    private int numRailCars;
    private String type;
    private String destinationCity;

    public Train(int engineNumber, String company, int numRailCars, String type, String destinationCity) {



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

    public String getCity(String destinationCity) {
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
