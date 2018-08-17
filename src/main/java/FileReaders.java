import com.opencsv.CSVReader;
import inputvariable.InputParameters;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaders {

    public static void main(String[] args) throws FileNotFoundException, IOException {
      //  File csvData = new File("C:\\Users\\puneetkhurana01\\IdeaProjects\\Flightsearch\\AirIndia");
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser =new CSVParser(new FileReader("AirIndia.csv"),format);


//        for (CSVRecord csvRecord : parser) {
//            System.out.println(csvRecord);
//        }

        List<InputParameters> list = new ArrayList<>();
        for(CSVRecord record : parser){
            InputParameters inp = new InputParameters();
            inp.setDepartureLocation(record.get("DEP_LOC"));
            inp.setArrival_location(record.get("ARR_LOC"));
            inp.setFlightdate(record.get("VALID_TILL"));
            inp.setFlightclass(record.get("CLASS"));
           // inp.setOutputPreference(record.get(""));
            list.add(inp);
        }
        parser.close();

        for(InputParameters ip:list){
            System.out.println(ip.getDepartureLocation()+" "+ip.getArrival_location()+" "+ip.getFlightclass()+" "+ip.getFlightdate());
        }


        }
    }

