package managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SortingTestResultStrategy implements TestResultStrategy { // TODO:: Ervoor zorgen dat er per algoritme een test bestandje wordt gemaakt

    public SortingTestResultStrategy(){
        createNewFile();
    }

    private void createNewFile() {
        try {
            File myObj = new File("sortingTestResults.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String dataset, Long results) {
        try{
            String insertString = "\nFor dataset: " + dataset + ": The running time for the sorting algorithm is: " + results.toString() + "ms";
            Files.write(Paths.get("sortingTestResults.txt"), insertString.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
