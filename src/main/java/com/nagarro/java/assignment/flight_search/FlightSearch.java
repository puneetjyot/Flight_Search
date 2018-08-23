
/*
 * Assignment Advance java 1
 *
 * JDK Version 1.8
 *
 * Puneetjyot Singh(Trainee Technology)
 *
 * Creation date-16/07/2018
 *
 * Last updated By- 22/07/2018
 *
 * Description-Java program that accepts flight details and search for the flights accordingly
 * This is our main class where inputs are fetched and output is displayed to the user

 */





package com.nagarro.java.assignment.flight_search;

import com.nagarro.java.assignment.display.PrintInformation;
import com.nagarro.java.assignment.read_files.FileReaders;
import com.nagarro.java.assignment.validations.ValidationCheck;
import com.nagarro.java.assignment.input_variable.InputParameters;

import javax.jws.soap.SOAPBinding;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.*;

public class FlightSearch {

    /**
     *
     * @param directory
     * @param input
     * @throws ExecutionException
     * @throws InterruptedException
     * Read all the files from directory
     */

    private void crawlDirectoryAndProcessFiles(File directory,InputParameters input) throws ExecutionException, InterruptedException {

        int index=0;

        /**
         * Making Thread pool using executor service
         */
        ExecutorService executorService=Executors.newCachedThreadPool();


        /**
         * Future waits for the thread to complete the task and return the result
         */

        Future<ArrayList<PrintInformation>>[] result=new Future[directory.listFiles().length];



        for (File file : directory.listFiles()) {

            if (file.isFile()) {
               // System.out.println("hello");

                FileReaders flight= new FileReaders(file,input);

                result[index]=executorService.submit(flight);

                index++;

            }

        }

        ArrayList<PrintInformation> resultlist=new ArrayList<>();

        for(Future<ArrayList<PrintInformation>> future:result) {



            resultlist.addAll(future.get());

        }
        PrintInformation print=new PrintInformation();

        print.display(resultlist);

        /**
         * await Termination works as join in threads
         */

        executorService.awaitTermination(500,TimeUnit.MILLISECONDS);

        executorService.shutdown();
    }


    /**
     *Getting user inputs and validation check
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ValidationCheck valid=new ValidationCheck();

        FlightSearch obj=new FlightSearch();

        InputParameters input=new InputParameters();

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Departure Location");

        /**
         * validation will keep on asking for correct departure location
         */

        while(true)
        {

            String departure = sc.nextLine();

            if(valid.isValidDapartureLoactaion(departure)){

                input.setDepartureLocation(departure);

                break;

            }

            else{

                System.out.println("Enter valid Departure Location");

            }

        }


        System.out.println("Enter Arrival Location");


        /**
         * validation will keep on asking for correct arrival location
         */

        while(true) {

            String arrival = sc.nextLine();

            if(valid.isValidArrivalLoactaion(arrival)) {

                input.setArrival_Location(arrival);

                break;

            }

            else{

                System.out.println("Enter Valid Arrival Location");

            }

        }


        System.out.println("Enter Date of flight");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");

        /**
         * validation will keep on asking for correct  flight date
         */

        while(true) {
            try {
                input.setFlightDate(LocalDate.parse(sc.nextLine(), formatter));
                break;
            }
            catch (Exception e){
                System.out.println("Enter the valid date");
            }
        }
       // input.setFlightDate(sc.next());

        System.out.println("Enter the CLASS in which you want to fly");

        /**
         * validation will keep on asking for correct  flight class
         */

        while (true)

        {

            String FlightClass=sc.nextLine();


            if(valid.isValidClass(FlightClass)) {

                input.setFlightclass(FlightClass);

                break;

            }

            else {
                System.out.println("Enter the valid flight class");
            }
        }

        System.out.println("Enter the output Criteria as BYFARE OR BYFAREANDDURATION");

        input.setOutputPreference(sc.nextLine());


        /**
         * Getting the folder where files are present
         * Relative path
         */



        File folder = new File("files");


        /**
         * Reloading the files from directory after every 5 seconds so that if new file is added ,it gets loaded
         */

        while(true) {

            try{

               obj.crawlDirectoryAndProcessFiles(folder, input);

                for(int i=0;i<150;i++){

                    System.out.print("*");

                }

               System.out.println();

               Thread.sleep(5000);
           }

           catch (Exception e){

               e.printStackTrace();

            }


        }



    }

}
