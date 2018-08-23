package com.nagarro.java.assignment.display;

import com.nagarro.java.assignment.enums.OutputPreference;
import java.time.LocalDate;
import java.util.ArrayList;
import static com.nagarro.java.assignment.services.SortByFare.sortByFare;
import static com.nagarro.java.assignment.services.SortByFareAndDuration.sortByFareAndDuration;


public class PrintInformation {

    private String Arrival_location;

    private LocalDate FlightDate;

    private String FlightClass;

    private String Departure_location;

    private String FLightTime;

    private String FlightNO;

    private double Fare;

    private String flight_duration;

    private static String OutputPreference;

    ArrayList<PrintInformation> printlist;


    /**
     * display method accepting arraylist of PrintInformation
     * @param printlist
     */

    public  void  display(ArrayList<PrintInformation> printlist) {


        /**
         * if output preference if by fare
         */
        if(getOutputPreference().equals("BYFARE")){

            sortByFare(printlist);

        }
        else{
            sortByFareAndDuration(printlist);
        }

        System.out.println("Flight Number\tDeparture Location\tArrival Location\tFlight Date\t\tFlight Class \t" +
                "\t\tFlight Fare\t\tFlight Duration\t\t\tFlight Time");

        for (PrintInformation print : printlist) {

            System.out.print("\t"+print.getFlightNO()+"\t\t\t\t");

            System.out.print(print.getDeparture_location()+"\t\t\t\t");

            System.out.print(print.getArrival_location()+"\t\t\t\t ");

            System.out.print(print.getFlightDate()+"\t\t\t\t");

            System.out.print(print.getFlightClass()+"\t\t\t\t");

            /**
             * if user inputs buisness class then increasing the price by 40%
             */

            if (print.getFlightClass().equals("B")) {

                System.out.print(print.getFare() * 1.4+"\t\t\t\t");

            }

            else {

                System.out.print(print.getFare()+"\t\t\t\t");

            }
            System.out.print(print.getFlight_duration()+"\t\t\t\t\t");

            System.out.println(print.getFLightTime());

           // System.out.println("-----------------------");
        }

    }

    /**
     *
     * Getters and setters
     */

    public void setArrival_location(String arrival_location) {
        Arrival_location = arrival_location;
    }

    public void setFlightDate(LocalDate flightDate) {
        FlightDate = flightDate;
    }

    public void setFlightClass(String flightClass) {
        FlightClass = flightClass;
    }


    public void setDeparture_location(String departure_location) {
        Departure_location = departure_location;
    }

    public void setFLightTime(String FLightTime) {
        this.FLightTime = FLightTime;
    }

    public void setFlightNO(String flightNO) {
        FlightNO = flightNO;
    }

    public void setFare(double fare) {
        Fare = fare;
    }

    public void setOutputPreference(OutputPreference outputPreference) {
        this.OutputPreference = outputPreference.toString();
    }

    public void setFlightDuration(String flight_duration) {
        this.flight_duration = flight_duration;
    }

    public String getArrival_location() {
        return Arrival_location;
    }

    public LocalDate getFlightDate() {
        return FlightDate;
    }

    public String getFlightClass() {
        return FlightClass;
    }

    public String getDeparture_location() {
        return Departure_location;
    }

    public String getFLightTime() {
        return FLightTime;
    }

    public String getFlightNO() {
        return FlightNO;
    }

    public double getFare() {
        return Fare;
    }

    public String getFlight_duration() {
        return flight_duration;
    }
    public static String getOutputPreference() {
        return OutputPreference;
    }

}
