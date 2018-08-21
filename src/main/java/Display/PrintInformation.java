package Display;

import java.util.ArrayList;

public class PrintInformation {
    private String Arrival_location;
    private String FlightDate;
    private String FlightClass;
    private String Departure_location;
    private String FLightTime;
    private String FlightNO;
    private int Fare;





    public static void display(ArrayList<PrintInformation> printlist){

        for(PrintInformation print:printlist){
            System.out.println(print.getFlightNO());
            System.out.println(print.getDeparture_location());
            System.out.println(print.getArrival_location());
            System.out.println(print.getFlightDate());
            System.out.println(print.getFLightTime());
            System.out.println(print.getFare());
            System.out.println(print.getFlightClass());
        }

    }




    public void setArrival_location(String arrival_location) {
        Arrival_location = arrival_location;
    }

    public void setFlightDate(String flightDate) {
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

    public void setFare(int fare) {
        Fare = fare;
    }

    public String getArrival_location() {
        return Arrival_location;
    }

    public String getFlightDate() {
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

    public int getFare() {
        return Fare;
    }

}
