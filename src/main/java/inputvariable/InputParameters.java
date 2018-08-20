package inputvariable;

import Enum.OutputPreference;

import java.time.LocalDate;


public class InputParameters {

    private String Arrival_location;
    private LocalDate Flightdate;
    private String Flightclass;
    private OutputPreference outputPreference;
    private String Departure_location;

    public void setArrival_location(String arrival_location) {
        Arrival_location = arrival_location;
    }

    public String getArrival_location() {
        return Arrival_location;
    }

    public void setFlightclass(String flightclass) {
        Flightclass = flightclass;
    }

    public String getFlightclass() {
        return Flightclass;
    }


    public void setFlightdate(LocalDate flightdate) {
        Flightdate = flightdate;
    }

    public LocalDate getFlightdate() {
        return Flightdate;
    }


    public void setDepartureLocation(String DepartureLocation) {

        Departure_location = DepartureLocation;
    }

    public String getDepartureLocation() {
        return Departure_location;
    }

    public void setOutputPreference(String outputPreference) {
        this.outputPreference = OutputPreference.valueOf(outputPreference);
    }

    public OutputPreference getOutputPreference() {
        return outputPreference;
    }

}


