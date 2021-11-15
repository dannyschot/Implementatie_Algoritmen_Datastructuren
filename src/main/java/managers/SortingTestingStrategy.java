package managers;

import algorithms.SortingAlgorithm;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.JSONHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Iterator;

public class SortingTestingStrategy implements TestingStrategy{
    Instant startTime;
    Instant endTime;
    Long delta;
    TestResultStrategy testResultStrategy = new SortingTestResultStrategy();
    TestResultManager resultManager = new TestResultManager(testResultStrategy);
    SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
    JSONHandler jsonHandler = new JSONHandler();


    @Override
    public <T> void runTests(JSONObject dataset) throws IOException {
        FileOutputStream writer = new FileOutputStream("sortingTestResults.txt");
        writer.write(("").getBytes());
        writer.close();
        Iterator iterator = dataset.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            JSONArray jsonArray = jsonHandler.getJSONArray(dataset, key);
            if (jsonArray.contains("string")) {
                continue;
            }
            startTime = Instant.now();
            sortingAlgorithm.insertionSort(jsonArray);
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toMillis();
            resultManager.handleTestResults(key, delta);
        }
    }
}
