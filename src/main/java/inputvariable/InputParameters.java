package inputvariable;

import Enum.OutputPreference;


public class InputParameters {

    private String Arrival_location;
    private String Flightdate;
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


    public void setFlightdate(String flightdate) {
        Flightdate = flightdate;
    }

    public String getFlightdate() {
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


