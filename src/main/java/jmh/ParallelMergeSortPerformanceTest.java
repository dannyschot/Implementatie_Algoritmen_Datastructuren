package jmh;

import algorithms.ParallelMergeSort;
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
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ParallelMergeSortPerformanceTest {
    JSONParser parser;
    JSONObject jsonObject;
    ParallelMergeSort parallelMergeSort;
    JSONArray lijstAflopend2;
    JSONArray lijstOplend2;
    JSONArray lijstGesorteerdAflopend3;
    JSONArray lijstGesorteerdOplopend3;
    JSONArray lijstLeeg0;
    JSONArray lijstHerhaald1000;
    JSONArray lijstGesorteerdeStrings;
    JSONArray lijstOplopend10000;
    JSONArray lijstWillekeurig3;
    JSONArray lijstOngesorteerdeStrings;
    JSONArray lijstMetStrings;
    JSONArray lijstWillekeurig10000;
    JSONArray lijstFloat8001;

    @Setup
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        parallelMergeSort = new ParallelMergeSort();
        lijstAflopend2 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        lijstOplend2 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        lijstGesorteerdAflopend3 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        lijstGesorteerdOplopend3 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        lijstWillekeurig10000 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        lijstLeeg0 = (JSONArray) jsonObject.get("lijst_leeg_0");
        lijstHerhaald1000 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        lijstGesorteerdeStrings = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        lijstOplopend10000 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        lijstWillekeurig3 = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        lijstFloat8001 = (JSONArray) jsonObject.get("lijst_float_8001");
        lijstOngesorteerdeStrings = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        lijstMetStrings = (JSONArray) jsonObject.get("lijst_met_strings");
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstWillekeurig10000() {
        parallelMergeSort.sort(lijstWillekeurig10000);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstFloat8001() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstGesorteerdAflopend3() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstAflopend2() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstOplend2() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstGesorteerdOplopend3() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstLeeg0() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstHerhaald1000() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstGesorteerdeStrings() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstOplopend10000() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstWillekeurig3() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstOngesorteerdeStrings() {
        parallelMergeSort.sort(lijstFloat8001);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstMetStrings() {
        parallelMergeSort.sort(lijstFloat8001);
    }
}