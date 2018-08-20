package Readfiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;
import java.util.concurrent.*;


public class FileReaders implements Runnable {

    private final File file;
    final long timeInterval = 10000;
    public FileReaders(File file) {
        this.file = file;
    }

    public void run() {
       while(true)
       {
           try {

               synchronized (this) {
                   readFile(file);
               }

           } catch (IOException e) {
               e.printStackTrace();
           }
           try{
               Thread.sleep(timeInterval);
           }
           catch (InterruptedException ie){
               ie.printStackTrace();
           }
       }
    }



    public synchronized void readFile(File file) throws IOException {


        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');



        CSVParser parser = new CSVParser(new FileReader(file), format);


        //  System.out.println("DEP_LOC" + " " + "ARR_LOC" + " " + "VALID_TILL" + " " + "CLASS");
        for (CSVRecord record : parser) {


            System.out.print(" " + record.get("DEP_LOC") + "     ");
            System.out.print(" " + record.get("ARR_LOC") + "     ");
            System.out.print(record.get("VALID_TILL") + "  ");
            System.out.println(record.get("CLASS") + "   ");


        }
        parser.close();


    }


}