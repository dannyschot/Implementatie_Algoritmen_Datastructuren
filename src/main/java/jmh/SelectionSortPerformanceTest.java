package jmh;

import algorithms.BinarySearch;
import algorithms.InsertionSort;
import algorithms.SelectionSort;
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
public class SelectionSortPerformanceTest {
    JSONParser parser;
    JSONObject jsonObject;
    SelectionSort selectionSortLijstWillekeurig10000;
    SelectionSort selectionSortLijstFloat8001;

    @Setup
    public void setup() throws IOException, ParseException {
        System.out.println("RUNNING SETUP");
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BinarySearch<Long> binarySearch;
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        JSONArray unsorted2 = (JSONArray) jsonObject.get("lijst_float_8001");
        selectionSortLijstWillekeurig10000 = new SelectionSort(unsorted1);
        selectionSortLijstFloat8001 = new SelectionSort(unsorted2);

    }



    @Benchmark
    public void performanceTestLijstWillekeurig10000() {
        selectionSortLijstWillekeurig10000.sort();
    }

    @Benchmark
    public void performanceTestLijstFloat8001() {
        selectionSortLijstFloat8001.sort();
    }
}
