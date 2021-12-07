package managers;

import algorithms.InsertionSort;
import algorithms.ParallelMergeSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONHandler;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class SortingTestingStrategy implements TestingStrategy { // TODO:: Cleanup en zorgen dat alle sorteringsalgoritmes door de test gaan
    Instant startTime;
    Instant endTime;
    Long delta;
    TestResultStrategy testResultStrategy;
    TestResultManager resultManager;
    ParallelMergeSort parallelMergeSort;
    JSONHandler jsonHandler;

    public SortingTestingStrategy() {
        testResultStrategy  = new SortingTestResultStrategy();
        resultManager = new TestResultManager(testResultStrategy);
        jsonHandler = new JSONHandler();
        parallelMergeSort = new ParallelMergeSort<>();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void runTests(JSONObject dataset) throws IOException {
        clearResultsFile();
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
            resultManager.handleTestResults(key, delta);
        }
    }

    private void clearResultsFile() throws IOException {
        FileOutputStream writer = new FileOutputStream("sortingTestResults.txt");
        writer.write(("").getBytes());
        writer.close();
    }
}
