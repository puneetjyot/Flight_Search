package FlightSearch;

import Readfiles.FileReaders;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FlightSearch {


    private static void crawlDirectoryAndProcessFiles(File directory, Executor executor) {

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                crawlDirectoryAndProcessFiles(file, executor);
            } else {
                executor.execute(new FileReaders(file));
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {



        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.awaitTermination(5, TimeUnit.MILLISECONDS);
        final File folder = new File("C:\\Users\\puneetkhurana01\\IdeaProjects\\Flightsearch\\files");
        crawlDirectoryAndProcessFiles(folder, executor);
        executor.shutdown();
    }

}
