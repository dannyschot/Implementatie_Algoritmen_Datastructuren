package jmh;

import algorithms.BinarySearch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openjdk.jmh.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class BinarySearchPerformanceTest {
    JSONParser parser;
    JSONObject jsonObject;
    BinarySearch<Long> binarySearch;

    @Setup
    public void setup() throws IOException, ParseException {
        System.out.println("RUNNING SETUP");
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BinarySearch<Long> binarySearch;
        JSONArray jsonArray = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        this.binarySearch = new BinarySearch<>(jsonArray);
    }



    @Benchmark
    public void performanceTest() {
        int actual = binarySearch.find(8500L);
    }

}
