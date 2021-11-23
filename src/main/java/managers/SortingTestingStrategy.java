package managers;

import algorithms.SortingAlgorithm;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONHandler;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class SortingTestingStrategy implements TestingStrategy{
    Instant startTime;
    Instant endTime;
    Long delta;
    TestResultStrategy testResultStrategy;
    TestResultManager resultManager;
    SortingAlgorithm sortingAlgorithm;
    JSONHandler jsonHandler;

    public SortingTestingStrategy() {
        testResultStrategy  = new SortingTestResultStrategy();
        resultManager = new TestResultManager(testResultStrategy);
        sortingAlgorithm = new SortingAlgorithm();
        jsonHandler = new JSONHandler();
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
            sortingAlgorithm.insertionSort(jsonArray);
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
