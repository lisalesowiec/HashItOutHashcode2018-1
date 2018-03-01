import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RideParser {
    public int numOfRows;
    public int numOfColumns;
    public int numOfCarsInFleet;
    public int numberOfRides;
    public int onTimeBonus;
    public int maxSteps;

    public int coordinateA, rows = 0;
    public int coordinateB, cols = 1;
    public int coordinateC, cars = 2;
    public int coordinateD, rides = 3;
    public int start, timeBonus = 4;
    public int end, totalSteps = 5;

    ArrayList rideArray = new ArrayList();

    public RideParser()
    {
        getFileInformation();
    }

    public void getFileInformation() throws IOException
    {
        String line;
        String path = "C:\\Users\\Will Deary\\IdeaProjects\\HashCode\\test.txt";
        FileReader file = new FileReader(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int counter =0;

        int[] ride = new int[5];
        while((line = br.readLine()) != null )
        {
            String[] columns = line.split(" ");
            if(counter==0)
            {
                numOfRows = Integer.parseInt(columns[rows]);
                numOfColumns = Integer.parseInt(columns[cols]);
                numOfCarsInFleet = Integer.parseInt(columns[cars]);
                numberOfRides = Integer.parseInt(columns[rides]);
                onTimeBonus = Integer.parseInt(columns[timeBonus]);
                maxSteps = Integer.parseInt(columns[totalSteps]);
            }
            else if(counter>=1)
            {
                ride[0] = Integer.parseInt(columns[coordinateA]);  //coordinate 1(a) [a,b]
                ride[1] = Integer.parseInt(columns[coordinateB]);  //coordinate 2 (b) [a,b]
                ride[2] = Integer.parseInt(columns[coordinateC]); //coordinate 3 (c) [a,b],[c,d]
                ride[3] = Integer.parseInt(columns[coordinateD]);//coordinate 4(d) [a,b], [b,c]
                ride[4] = Integer.parseInt(columns[start]);//earliest startTime
                ride[5] = Integer.parseInt(columns[end]);//latest finishTime
                rideArray.add(ride);
            }
            counter++;
        }
    }

    public int getRows()
    {
        return numOfRows;
    }
    public int getColumns()
    {
        return numOfColumns;
    }
    public int getNumOfCars()
    {
        return numOfCarsInFleet;
    }

    public int getNumberOfRides()
    {
        return numberOfRides;
    }

    public int getBonus()
    {
        return onTimeBonus;
    }

    public int getMaxSteps()
    {
        return maxSteps;
    }
    public ArrayList getAllRides()
    {
        return rideArray;
    }
}
