package managers;

import algorithms.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONHandler;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class SortingTestingStrategy<T extends Comparable<T>> implements TestingStrategy { // TODO:: Cleanup en zorgen dat alle sorteringsalgoritmes door de test gaan
    Instant startTime;
    Instant endTime;
    Long delta;
    TestResultStrategy testResultStrategy;
    TestResultManager resultManager;
    ParallelMergeSort<T> parallelMergeSort;
    InsertionSort<T> insertionSort;
    SelectionSort<T> selectionSort;
    QuickSort<T> quickSort;
    TimSort<T> timSort;
    JSONHandler jsonHandler;

    public SortingTestingStrategy() {
        testResultStrategy  = new SortingTestResultStrategy();
        resultManager = new TestResultManager(testResultStrategy);
        jsonHandler = new JSONHandler();
        parallelMergeSort = new ParallelMergeSort<>();
        insertionSort = new InsertionSort<>();
        quickSort = new QuickSort<>();
        timSort = new TimSort<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void runTests(JSONObject dataset) throws IOException {
        clearResultsFiles();
        runTestForParallelMergeSort(dataset);
        runTestForInsertionSort(dataset);
        runTestForSelectionSort(dataset);
        runTestForQuickSort(dataset);
//        runTestForRadixSort(dataset); is nog niet generiek
        runTestForTimSort(dataset);
    }

    private void clearResultsFiles() throws IOException {
        clearInsertionResults();
        clearMergeResults();
        clearQuickResults();
        clearRadixResults();
        clearTimResults();
        clearSelectionResults();
    }

    private void runTestForParallelMergeSort(JSONObject dataset) {
        for (Object o : dataset.keySet()) {
            String key = (String) o;
            JSONArray jsonArray = jsonHandler.getJSONArray(dataset, key);
            if (jsonArray.contains("string")) { //TODO:: Flexibiliteit toevoegen
                continue;
            }
            startTime = Instant.now();
            parallelMergeSort.sort(jsonArray);
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toMillis();
            resultManager.handleTestResults(key, delta, "mergeTestResults.txt");
        }
    }

    private void runTestForInsertionSort(JSONObject dataset) {
        for (Object o : dataset.keySet()) {
            String key = (String) o;
            JSONArray jsonArray = jsonHandler.getJSONArray(dataset, key);
            if (jsonArray.contains("string")) { //TODO:: Flexibiliteit toevoegen
                continue;
            }
            startTime = Instant.now();
            insertionSort.sort(jsonArray);
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toMillis();
            resultManager.handleTestResults(key, delta, "insertionTestResults.txt");
        }
    }

    private void runTestForSelectionSort(JSONObject dataset) {
        for (Object o : dataset.keySet()) {
            String key = (String) o;
            JSONArray jsonArray = jsonHandler.getJSONArray(dataset, key);
            if (jsonArray.contains("string")) { //TODO:: Flexibiliteit toevoegen
                continue;
            }
            selectionSort = new SelectionSort(jsonArray);
            startTime = Instant.now();
            selectionSort.sort();
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toMillis();
            resultManager.handleTestResults(key, delta, "selectionTestResults.txt");
        }
    }

    private void runTestForQuickSort(JSONObject dataset) {
        for (Object o : dataset.keySet()) {
            String key = (String) o;
            JSONArray jsonArray = jsonHandler.getJSONArray(dataset, key);
            if (jsonArray.contains("string")) { //TODO:: Flexibiliteit toevoegen
                continue;
            }
            startTime = Instant.now();
            quickSort.sort(jsonArray);
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toMillis();
            resultManager.handleTestResults(key, delta, "quickTestResults.txt");
        }
    }

    @SuppressWarnings("unchecked")
    private void runTestForTimSort(JSONObject dataset) {
        for (Object o : dataset.keySet()) {
            String key = (String) o;
            JSONArray jsonArray = jsonHandler.getJSONArray(dataset, key);
            T[] list = (T[]) new Comparable[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                list[i] = (T) jsonArray.get(i);
            }
            if (jsonArray.contains("string")) { //TODO:: Flexibiliteit toevoegen
                continue;
            }
            startTime = Instant.now();
            timSort.timSort(list, jsonArray.size());
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toNanos();
            resultManager.handleTestResults(key, delta, "timTestResults.txt");
        }
    }

    private void clearInsertionResults() throws IOException {
        FileOutputStream writer = new FileOutputStream("insertionTestResults.txt");
        writer.write(("").getBytes());
        writer.close();
    }

    private void clearSelectionResults() throws IOException {
        FileOutputStream writer = new FileOutputStream("selectionTestResults.txt");
        writer.write(("").getBytes());
        writer.close();
    }

    private void clearMergeResults() throws IOException {
        FileOutputStream writer = new FileOutputStream("mergeTestResults.txt");
        writer.write(("").getBytes());
        writer.close();
    }

    private void clearQuickResults() throws IOException {
        FileOutputStream writer = new FileOutputStream("quickTestResults.txt");
        writer.write(("").getBytes());
        writer.close();
    }

    private void clearTimResults() throws IOException {
        try {
            FileOutputStream writer = new FileOutputStream("timTestResults.txt");
            writer.write(("").getBytes());
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not yet exist");
        }
    }

    private void clearRadixResults() throws IOException {
        try {
            FileOutputStream writer = new FileOutputStream("radixTestResults.txt");
            writer.write(("").getBytes());
            writer.close();
        } catch (Exception e) {
            System.out.println("File does not yet exist");
        }
    }
}
