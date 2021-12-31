package jmh;

import datastructures.DynamicArray;
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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class DynamicArrayPerformanceTest {
    JSONObject jsonObject;
    JSONParser parser;
    DynamicArray<Double> dsFloat8001;
    DynamicArray<Long> dsLijstAflopend2;
    DynamicArray<Long> dsLijstOplopend2;
    DynamicArray<Long> dsLijstGesorteerdAflopend3;
    DynamicArray<Long> dsLijstGesorteerdOplopend3;
    DynamicArray<Long> dsLijstHerhaald1000;
    DynamicArray<Long> dsLijstLeeg0;
    DynamicArray<String> dsLijstGesorteerdeStrings;
    DynamicArray<Long> dsLijstWillekeurig10000;
    DynamicArray<Long> dsLijstWillekeurig3;
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
        dsFloat8001 = new DynamicArray<>();
        dsLijstAflopend2 = new DynamicArray<>();
        dsLijstOplopend2 = new DynamicArray<>();
        dsLijstGesorteerdAflopend3 = new DynamicArray<>();
        dsLijstGesorteerdOplopend3 = new DynamicArray<>();
        dsLijstLeeg0 = new DynamicArray<>();
        dsLijstWillekeurig10000 = new DynamicArray<>();
        dsLijstGesorteerdeStrings = new DynamicArray<>();
        dsLijstHerhaald1000 = new DynamicArray<>();
        dsLijstWillekeurig3 = new DynamicArray<>();
    }

    @Benchmark
    public void shouldInsertLijstOplend2(){
        for (Object element : lijstOplend2) {
            dsLijstOplopend2.add((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertFloat8001(){
        for (Object element : lijstFloat8001) {
            dsFloat8001.add((Double) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstGesorteerdAflopend3(){
        for (Object element : lijstGesorteerdAflopend3) {
            dsLijstGesorteerdAflopend3.add((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstGesorteerdOplopend3(){
        for (Object element : lijstGesorteerdOplopend3) {
            dsLijstGesorteerdOplopend3.add((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstHerhaald1000(){
        for (Object element : lijstHerhaald1000) {
            dsLijstHerhaald1000.add((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstLeeg0(){
        for (Object element : lijstLeeg0) {
            dsLijstLeeg0.add((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstGesorteerdeStrings(){
        for (Object element : lijstGesorteerdeStrings) {
            dsLijstGesorteerdeStrings.add((String) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstWillekeurig10000(){
        for (Object element : lijstWillekeurig10000) {
            dsLijstWillekeurig10000.add((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstWillekeurig3(){
        for (Object element : lijstWillekeurig3) {
            dsLijstWillekeurig3.add((Long) element);
        }
    }
}
