package jmh;

import algorithms.BinarySearch;
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
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class SelectionSortPerformanceTest {
    SelectionSort selectionSortLijstWillekeurig10000;
    SelectionSort selectionSortLijstLeeg0;
    SelectionSort selectionSortLijstFloat8001;
    SelectionSort selectionSortLijstAflopend2;
    SelectionSort selectionSortLijstOplopend2;
    SelectionSort selectionSortLlijstAflopend3;
    SelectionSort selectionSortLijstHerhaald1000;
    SelectionSort selectionSortLijstGesorteerdOplopend3;
    SelectionSort selectionSortLijstGesorteerdeStrings;
    SelectionSort selectionSortLijstOplopend10000;
    SelectionSort selectionSortLijstWillekeurig3;
    SelectionSort selectionSortLijstOngesorteerdeStrings;
    SelectionSort selectionSortLijstMetStrings;
    JSONParser parser;
    JSONObject jsonObject;
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
        System.out.println("RUNNING SETUP");
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BinarySearch<Long> binarySearch;
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
        selectionSortLijstWillekeurig10000 = new SelectionSort(lijstWillekeurig10000);
        selectionSortLijstFloat8001 = new SelectionSort(lijstFloat8001);
        selectionSortLijstAflopend2 = new SelectionSort(lijstAflopend2);
        selectionSortLijstOplopend2 = new SelectionSort(lijstOplend2);
        selectionSortLlijstAflopend3 = new SelectionSort(lijstGesorteerdAflopend3);
        selectionSortLijstGesorteerdOplopend3 = new SelectionSort(lijstGesorteerdOplopend3);
        selectionSortLijstLeeg0 = new SelectionSort(lijstLeeg0);
        selectionSortLijstHerhaald1000 = new SelectionSort(lijstHerhaald1000);
        selectionSortLijstGesorteerdeStrings = new SelectionSort(lijstOngesorteerdeStrings);
        selectionSortLijstOplopend10000 = new SelectionSort(lijstOplopend10000);
        selectionSortLijstWillekeurig3 = new SelectionSort(lijstWillekeurig3);
        selectionSortLijstOngesorteerdeStrings = new SelectionSort(lijstOngesorteerdeStrings);
        selectionSortLijstMetStrings = new SelectionSort(lijstMetStrings);
    }



    @Benchmark
    public void performanceTestLijstWillekeurig10000() {
        selectionSortLijstWillekeurig10000.sort();
    }

    @Benchmark
    public void performanceTestLijstFloat8001() {
        selectionSortLijstFloat8001.sort();
    }

    @Benchmark
    public void performanceTestLijstGesorteerdAflopend3() {
        selectionSortLlijstAflopend3.sort();
    }

    @Benchmark
    public void performanceTestLijstAflopend2() {
        selectionSortLijstAflopend2.sort();
    }

    @Benchmark
    public void performanceTestLijstOplopend2() {
        selectionSortLijstOplopend2.sort();
    }

    @Benchmark
    public void performanceTestLijstGesorteerdOplopend3() {
        selectionSortLijstGesorteerdOplopend3.sort();
    }

    @Benchmark
    public void performanceTestLijstLeeg0() {
        selectionSortLijstLeeg0.sort();
    }

    @Benchmark
    public void performanceTestLijstHerhaald1000() {
        selectionSortLijstHerhaald1000.sort();
    }

    @Benchmark
    public void performanceTestLijstGesorteerdeStrings() {
        selectionSortLijstGesorteerdeStrings.sort();
    }

    @Benchmark
    public void performanceTestLijstOplopend10000() {
        selectionSortLijstOplopend10000.sort();
    }

    @Benchmark
    public void performanceTestLijstWillekeurig3() {
        selectionSortLijstWillekeurig3.sort();
    }

    @Benchmark
    public void performanceTestLijstOngesorteerdeStrings() {
        selectionSortLijstOngesorteerdeStrings.sort();
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstMetStrings() {
        selectionSortLijstMetStrings.sort();
    }
}
