package performanceTests;

import algorithms.InsertionSort;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import utils.JSONHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;

public class InsertionSortPerformanceTest {
    Instant startTime;
    Instant endTime;
    Long delta;
    JSONHandler jsonHandler;
    JSONParser parser;
    JSONObject jsonObject;
    InsertionSort insertionSort;

    @Before
    public void setup() throws IOException, ParseException {
        jsonHandler = new JSONHandler();
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        insertionSort = new InsertionSort();
    }

    @Test
    public void performanceTest() {
        for (Object o : jsonObject.keySet()) {
            String key = (String) o;
            JSONArray jsonArray = jsonHandler.getJSONArray(jsonObject, key);
            if (jsonArray.contains("string")) { //TODO:: Flexibiliteit toevoegen
                continue;
            }
            startTime = Instant.now();
            insertionSort.sort(jsonArray);
            endTime = Instant.now();
            delta = Duration.between(startTime, endTime).toMillis();
            System.out.println(delta);
        }
    }
}
