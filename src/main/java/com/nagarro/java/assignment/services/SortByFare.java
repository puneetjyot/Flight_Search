package com.nagarro.java.assignment.services;

import com.nagarro.java.assignment.display.PrintInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Called when sorting is done by only fare
 */

public class SortByFare {

    public static ArrayList<PrintInformation> sortByFare(ArrayList<PrintInformation> printlist){

    Collections.sort(printlist, byFare);

    return printlist;

}

    private static Comparator<PrintInformation> byFare = new Comparator<PrintInformation>(){

        public int compare(PrintInformation flight_1, PrintInformation flight_2){

            Double fare_1 = flight_1.getFare();

            Double fare_2 = flight_2.getFare();

            return fare_1.compareTo(fare_2);
        }
    };

}
