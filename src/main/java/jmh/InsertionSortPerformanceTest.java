package jmh;

import algorithms.BinarySearch;
import algorithms.InsertionSort;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class InsertionSortPerformanceTest {
    JSONParser parser;
    JSONObject jsonObject;
    InsertionSort insertionSort;
    ArrayList<Double> unsorted2;

    @Setup
    public void setup() throws IOException, ParseException {
        System.out.println("RUNNING SETUP");
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BinarySearch<Long> binarySearch;
        JSONArray jsonArray = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        insertionSort = new InsertionSort();
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        unsorted2 = (ArrayList<Double>) unsorted1.clone();
    }



    @Benchmark
    public void performanceTest() {
        insertionSort.sort(unsorted2);
    }
}
