package jmh;

import datastructures.DoublyLinkedList;
import datastructures.ListIterator;
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
public class DoubleLinkedListPerformanceTest {
    JSONObject jsonObject;
    JSONParser parser;
    DoublyLinkedList<Double> dsFloat8001;
    DoublyLinkedList<Long> dsLijstAflopend2;
    DoublyLinkedList<Long> dsLijstOplopend2;
    DoublyLinkedList<Long> dsLijstGesorteerdAflopend3;
    DoublyLinkedList<Long> dsLijstGesorteerdOplopend3;
    DoublyLinkedList<Long> dsLijstHerhaald1000;
    DoublyLinkedList<Long> dsLijstLeeg0;
    DoublyLinkedList<String> dsLijstGesorteerdeStrings;
    DoublyLinkedList<Long> dsLijstWillekeurig10000;
    DoublyLinkedList<Long> dsLijstWillekeurig3;
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
    ListIterator<Double> iteratorFloat8001;
    ListIterator<Long> iteratorAflopend2;
    ListIterator<Long> iteratorOplopend2;
    ListIterator<Long> iteratorGesorteerdAflopend3;
    ListIterator<Long> iteratorGesorteerdOplopend3;
    ListIterator<Long> iteratorLeeg0;
    ListIterator<Long> iteratorLijstWillekeurig10000;
    ListIterator<String> iteratorGesorteerdeStrings;
    ListIterator<Long> iteratorHerhaald1000;
    ListIterator<Long> iteratorWillekeurig3;

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
        dsFloat8001 = new DoublyLinkedList<>();
        dsLijstAflopend2 = new DoublyLinkedList<>();
        dsLijstOplopend2 = new DoublyLinkedList<>();
        dsLijstGesorteerdAflopend3 = new DoublyLinkedList<>();
        dsLijstGesorteerdOplopend3 = new DoublyLinkedList<>();
        dsLijstLeeg0 = new DoublyLinkedList<>();
        dsLijstWillekeurig10000 = new DoublyLinkedList<>();
        dsLijstGesorteerdeStrings = new DoublyLinkedList<>();
        dsLijstHerhaald1000 = new DoublyLinkedList<>();
        dsLijstWillekeurig3 = new DoublyLinkedList<>();
        iteratorFloat8001 = dsFloat8001.getIterator();
        iteratorAflopend2 = dsLijstAflopend2.getIterator();
        iteratorOplopend2 = dsLijstOplopend2.getIterator();
        iteratorGesorteerdAflopend3 = dsLijstGesorteerdAflopend3.getIterator();
        iteratorGesorteerdOplopend3 = dsLijstGesorteerdOplopend3.getIterator();
        iteratorLeeg0 = dsLijstLeeg0.getIterator();
        iteratorLijstWillekeurig10000 = dsLijstWillekeurig10000.getIterator();
        iteratorGesorteerdeStrings = dsLijstGesorteerdeStrings.getIterator();
        iteratorHerhaald1000 = dsLijstHerhaald1000.getIterator();
        iteratorWillekeurig3 = dsLijstWillekeurig3.getIterator();
    }

    @Benchmark
    public void shouldInsertLijstAflopend2(){
        for (Object element : lijstAflopend2) {
            iteratorAflopend2.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstOplend2(){
        for (Object element : lijstOplend2) {
            iteratorOplopend2.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertFloat8001(){
        for (Object element : lijstFloat8001) {
            iteratorFloat8001.insertBefore((Double) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstGesorteerdAflopend3(){
        for (Object element : lijstGesorteerdAflopend3) {
            iteratorGesorteerdAflopend3.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstGesorteerdOplopend3(){
        for (Object element : lijstGesorteerdOplopend3) {
            iteratorGesorteerdOplopend3.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstHerhaald1000(){
        for (Object element : lijstHerhaald1000) {
            iteratorHerhaald1000.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstLeeg0(){
        for (Object element : lijstLeeg0) {
            iteratorLeeg0.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstGesorteerdeStrings(){
        for (Object element : lijstGesorteerdeStrings) {
            iteratorGesorteerdeStrings.insertBefore((String) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstWillekeurig10000(){
        for (Object element : lijstWillekeurig10000) {
            iteratorLijstWillekeurig10000.insertBefore((Long) element);
        }
    }

    @Benchmark
    public void shouldInsertLijstWillekeurig3(){
        for (Object element : lijstWillekeurig3) {
            iteratorWillekeurig3.insertBefore((Long) element);
        }
    }
}
