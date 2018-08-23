package com.nagarro.java.assignment.read_files;

import com.nagarro.java.assignment.display.PrintInformation;
import com.nagarro.java.assignment.input_variable.InputParameters;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.Callable;


public class FileReaders implements Callable<ArrayList<PrintInformation>> {

    private  File file;

    private InputParameters input;

    final long timeInterval = 10000;

    /**
     *
     * @param file
     * @param input
     * Called everytime for a new file
     */
    public FileReaders(File file,InputParameters input) {
       // System.out.println("hello");

        this.file = file;

        this.input=input;

    }

//    public void run() {
//       while(true)
//       {
//           try {
//
//               synchronized (this) {
//                   readFile(file,input);
//               }
//
//           } catch (IOException e) {
//               e.printStackTrace();
//           }
//           try{
//               Thread.sleep(timeInterval);
//           }
//           catch (InterruptedException ie){
//               ie.printStackTrace();
//           }
//       }
   // }


    /**
     *
     * @param file
     * @param input
     * @return
     * @throws IOException
     * Reading file here
     */

    public ArrayList<PrintInformation> readFile(File file,InputParameters input) throws IOException {

        /**
         * Reading CSV files using csv parser
         * CSVFORMAT sets the format of the csv file you are going to read
         */



        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

        PrintInformation print;

        ArrayList<PrintInformation>  printlist=new ArrayList<>();

        CSVParser parser = new CSVParser(new FileReader(file), format);



        for (CSVRecord record : parser) {

            LocalDate date=LocalDate.parse(record.get("VALID_TILL"),DateTimeFormatter.ofPattern("d-MM-yyyy"));

            /**
             * Parse the values from csv files using there headers
             *
             * Filter the result while reading the file
             * and if record satisfies the condition then storing it in arraylist
             */

            if(record.get("DEP_LOC").equalsIgnoreCase(input.getDepartureLocation())&&

                    record.get("ARR_LOC").equalsIgnoreCase(input.getArrival_Location())&&

                    (date.isEqual(input.getFlightDate() )||

                    input.getFlightDate().isBefore(date))&&

                    record.get("SEAT_AVAILABILITY").equalsIgnoreCase("Y"))


            {

                if(input.getFlightclass().equalsIgnoreCase("B")) {
                    if (record.get("CLASS").equals("EB")) {
                        print = new PrintInformation();

                        print.setDeparture_location(record.get("DEP_LOC"));

                        print.setArrival_location(record.get("ARR_LOC"));

                        /**
                         * DateTimeFormatter helps you to set the format in which you want to parse date
                         */

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

                        LocalDate flightDate = LocalDate.parse(record.get("VALID_TILL"), formatter);

                        print.setFlightDate(flightDate);

                        print.setFLightTime(record.get("FLIGHT_TIME"));

                        print.setFare(Double.parseDouble(record.get("FARE")));

                        print.setFlightClass(record.get("CLASS"));

                        print.setFlightNO(record.get("FLIGHT_NO"));

                        print.setFlightDuration(record.get("FLIGHT_DUR"));

                        print.setOutputPreference(input.getOutputPreference());

                        printlist.add(print);

                    }
                }
              //  System.out.println(record.get("FLIGHT_NO"));
                /**
                 * making a object of PrintInformation class everytime
                 * to store search results in arraylist
                 */

                else {

                    print = new PrintInformation();

                    print.setDeparture_location(record.get("DEP_LOC"));

                    print.setArrival_location(record.get("ARR_LOC"));
                    // print.setFlightDate(record.get("VALID_TILL"));

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

                    LocalDate flightDate = LocalDate.parse(record.get("VALID_TILL"), formatter);

                    print.setFlightDate(flightDate);

                    print.setFLightTime(record.get("FLIGHT_TIME"));

                    print.setFare(Double.parseDouble(record.get("FARE")));

                    print.setFlightClass(record.get("CLASS"));

                    print.setFlightNO(record.get("FLIGHT_NO"));

                    print.setFlightDuration(record.get("FLIGHT_DUR"));

                    print.setOutputPreference(input.getOutputPreference());

                    printlist.add(print);
                }
            }
        }


        /**
         * closing parser
         */
        parser.close();

         return printlist;

    }


    /**
     *  Overriding call method of Callable interface
     * @return
     * @throws Exception
     */
    @Override

    public ArrayList<PrintInformation> call() throws Exception {

            return readFile(this.file, this.input);


        }
    }



