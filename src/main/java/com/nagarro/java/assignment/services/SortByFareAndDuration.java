package com.nagarro.java.assignment.services;

import com.nagarro.java.assignment.display.PrintInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.nagarro.java.assignment.services.SortByFare.sortByFare;


/**
 * Called when sorting is done by  fare and duration
 */

public class SortByFareAndDuration {

    public static ArrayList<PrintInformation> sortByFareAndDuration(ArrayList<PrintInformation> printlist){


        printlist = sortByFare(printlist);

        Collections.sort(printlist, byFareAndDuration);

        return printlist;

    }

    private static Comparator<PrintInformation> byFareAndDuration = new Comparator<PrintInformation>(){

        public int compare(PrintInformation flight_1, PrintInformation flight_2){

            Double duration_1 = Double.parseDouble(flight_1.getFlight_duration());

            Double duration_2 = Double.parseDouble(flight_2.getFlight_duration());

            Double fare_1 = flight_1.getFare();

            Double fare_2 = flight_2.getFare();

            if(fare_1.compareTo(fare_2) == 0){

                return duration_1.compareTo(duration_2);

            }else{

                return fare_1.compareTo(fare_2);
            }
        }
    };


}
