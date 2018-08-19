import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.*;


public class FileReaders implements Runnable {

    private final File file;

    public FileReaders(File file) {
        this.file = file;
    }

    public void run() {
        try {
            synchronized(this) {
                readFile(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static  void crawlDirectoryAndProcessFiles(File directory, Executor executor) {

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                crawlDirectoryAndProcessFiles(file, executor);
            } else {
                executor.execute(new FileReaders(file));
            }
        }
    }

    public synchronized void   readFile(File file) throws IOException {



        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');

      //  Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));

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

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        executor.awaitTermination(5, TimeUnit.MILLISECONDS);
        final File folder = new File("C:\\Users\\puneetkhurana01\\IdeaProjects\\Flightsearch\\files");
        crawlDirectoryAndProcessFiles(folder,executor);
        executor.shutdown();
    }
}