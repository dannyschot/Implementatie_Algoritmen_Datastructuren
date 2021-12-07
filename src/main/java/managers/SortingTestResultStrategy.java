package managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SortingTestResultStrategy implements TestResultStrategy { // TODO:: Ervoor zorgen dat er per algoritme een test bestandje wordt gemaakt

    public SortingTestResultStrategy(){
        createNewFiles();
    }

    private void createNewFiles() {
        try {
            File insertion = new File("insertionTestResults.txt");
            File selection = new File("selectionTestResults.txt");
            File quick = new File("quickTestResults.txt");
            File merge = new File("mergeTestResults.txt");
            File tim = new File("timTestResults.txt");
            File radix = new File("radixTestResults.txt");

            if (insertion.createNewFile()) {
                System.out.println("File created: " + insertion.getName());
            } else if (selection.createNewFile()) {
                System.out.println("File created: " + selection.getName());
            } else if (quick.createNewFile()) {
                System.out.println("File created: " + quick.getName());
            } else if (merge.createNewFile()) {
                System.out.println("File created: " + merge.getName());
            } else if (tim.createNewFile()) {
                System.out.println("File created: " + tim.getName());
            } else if (radix.createNewFile()) {
                System.out.println("File created: " + radix.getName());
            } else {
                System.out.println("One of the file already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(String dataset, Long results, String fileName) {
        try{
            String insertString = "\nFor dataset: " + dataset + ": The running time for the sorting algorithm is: " + results.toString() + " nanoseconds";
            Files.write(Paths.get(fileName), insertString.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
