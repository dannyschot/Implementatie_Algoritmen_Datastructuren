package jmh;

import algorithms.TimSort;
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
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class TimSortPerformanceTest {
    TimSort timSort;
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
    Double[] lijstA2;
    Double[] lijstW1000;
    Double[] lijstF8001;
    Long[] lijstAfl3;
    Long[] lijstOpl2;
    Long[] lijstOpl3;
    Long[] lijstLeeg;
    Long[] lijstH1000;
    String[] lijstGeStr;
    Long[] lijstOpl10;
    Long[] lijstW3;
    String[] lijstOngStr;
    String[] lijstMStr;


    @Setup
    public void setup() throws IOException, ParseException {
        System.out.println("RUNNING SETUP");
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        timSort = new TimSort();
        lijstAflopend2 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        lijstA2 = getListDouble(lijstAflopend2);
        lijstOplend2 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        lijstOpl2 = getListLong(lijstOplend2);
        lijstGesorteerdAflopend3 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        lijstAfl3 = getListLong(lijstGesorteerdAflopend3);
        lijstGesorteerdOplopend3 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        lijstOpl3 = getListLong(lijstGesorteerdOplopend3);
        lijstWillekeurig10000 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        lijstW1000 = getListDouble(lijstWillekeurig10000);
        lijstLeeg0 = (JSONArray) jsonObject.get("lijst_leeg_0");
        lijstLeeg = getListLong(lijstLeeg0);
        lijstHerhaald1000 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        lijstH1000 = getListLong(lijstHerhaald1000);
        lijstGesorteerdeStrings = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        lijstOngStr = getListString(lijstOngesorteerdeStrings);
        lijstGeStr = getListString(lijstGesorteerdeStrings);
        lijstOplopend10000 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        lijstOpl10 = getListLong(lijstOplopend10000);
        lijstWillekeurig3 = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        lijstW3 = getListLong(lijstWillekeurig3);
        lijstFloat8001 = (JSONArray) jsonObject.get("lijst_float_8001");
        lijstF8001 = getListDouble(lijstFloat8001);
        lijstOngesorteerdeStrings = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        lijstMetStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        lijstMStr = getListString(lijstMetStrings);
    }

    private Double[] getListDouble(JSONArray array) {
        Double[] doubleList = new Double[array.size()];

        for (int i = 0; i < array.size(); i++) {
            doubleList[i] = (Double) array.get(i);
        }

        return doubleList;
    }

    private Long[] getListLong(JSONArray array) {
        Long[] longList = new Long[array.size()];

        for (int i = 0; i < array.size(); i++) {
            longList[i] = (Long) array.get(i);
        }

        return longList;
    }

    private String[] getListString(JSONArray array) {
        String[] stringList = new String[array.size()];

        for (int i = 0; i < array.size(); i++) {
            stringList[i] = (String) array.get(i);
        }

        return stringList;
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstWillekeurig10000() {
        timSort.timSort(lijstW1000, lijstW1000.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstFloat8001() {
        timSort.timSort(lijstF8001, lijstF8001.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstGesorteerdAflopend3() {
        timSort.timSort(lijstAfl3, lijstAfl3.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstAflopend2() {
        timSort.timSort(lijstA2, lijstA2.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstOplend2() {
        timSort.timSort(lijstOpl2, lijstOpl2.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstGesorteerdOplopend3() {
        timSort.timSort(lijstOpl3, lijstOpl3.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstLeeg0() {
        timSort.timSort(lijstLeeg, lijstLeeg.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstHerhaald1000() {
        timSort.timSort(lijstH1000, lijstH1000.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstGesorteerdeStrings() {
        timSort.timSort(lijstGeStr, lijstGeStr.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstOplopend10000() {
        timSort.timSort(lijstOpl10, lijstOpl10.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstWillekeurig3() {
        timSort.timSort(lijstW3, lijstW3.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstOngesorteerdeStrings() {
        timSort.timSort(lijstOngStr, lijstOngStr.length);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    public void performanceTestLijstMetStrings() {
        timSort.timSort(lijstMStr, lijstMStr.length);
    }

}
