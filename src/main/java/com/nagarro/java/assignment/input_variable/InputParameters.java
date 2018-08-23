package com.nagarro.java.assignment.input_variable;

import com.nagarro.java.assignment.enums.OutputPreference;

import java.time.LocalDate;

/**
 * This class takes input from user and store it in the variable
 * Helps to get these values via getter
 */



public class InputParameters {

    private String Arrival_location;

    private LocalDate Flightdate;

    private String Flightclass;

    private OutputPreference outputPreference;

    private String Departure_location;


    /**
     *
     * Getters and Setters
     */

    public void setArrival_Location(String arrival_location)
    {

        Arrival_location = arrival_location;

    }

    public String getArrival_Location() {

        return Arrival_location;
    }

    public void setFlightclass(String flightclass) {

        Flightclass = flightclass;
    }

    public String getFlightclass() {

        return Flightclass;
    }



    public void setFlightDate(LocalDate flightdate)
    {
        Flightdate = flightdate;
    }

    public LocalDate getFlightDate()
    {
        return Flightdate;
    }


    public void setDepartureLocation(String DepartureLocation)
    {

        Departure_location = DepartureLocation;
    }

    public String getDepartureLocation()
    {
        return Departure_location;
    }

    public void setOutputPreference(String outputPreference)
    {
        this.outputPreference = OutputPreference.valueOf(outputPreference);
    }

    public OutputPreference getOutputPreference()
    {
        return outputPreference;
    }

}


