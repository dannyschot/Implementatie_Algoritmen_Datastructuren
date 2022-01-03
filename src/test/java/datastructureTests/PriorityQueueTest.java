package datastructureTests;

import datastructures.PriorityQueueCris;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;

public class PriorityQueueTest {
    JSONObject jsonObject;
    JSONParser parser;
    PriorityQueueCris<Integer> testPriorityQueueWithNumbers;
    PriorityQueueCris<String> testPriorityQueueWithStrings;
    Instant startTime;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        testPriorityQueueWithNumbers = new PriorityQueueCris<>(4);
        testPriorityQueueWithStrings = new PriorityQueueCris<>(4);
    }


    @Test
    public void shouldInsertEigenLijst() {
        JSONArray list = (JSONArray) jsonObject.get("eigen_lijst");

        PriorityQueueCris<Long> doubleStack = new PriorityQueueCris<>(list.size());

        int actual = list.size() - 1;

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Eigen Lijst insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstFloat8001() {
        JSONArray listWithDouble = (JSONArray) jsonObject.get("lijst_float_8001");

        PriorityQueueCris<Double> doubleStack = new PriorityQueueCris<>(listWithDouble.size());

        int actual = listWithDouble.size();
        startTime = Instant.now();
        for (Object element : listWithDouble) {
            doubleStack.enqueue((Double) element);
        }


        int expected = doubleStack.size();


        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstAflopend2() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_aflopend_2");

        PriorityQueueCris<Long> doubleStack = new PriorityQueueCris<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_aflopend_2 insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstOplopend2() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_oplopend_2");

        PriorityQueueCris<Long> doubleStack = new PriorityQueueCris<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_oplopend_2 insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstHerhaald1000() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        PriorityQueueCris<Long> longStack = new PriorityQueueCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            longStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_herhaald_1000 insertion takes: " + duration + " ms");

        int actual = longStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstMetStrings() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        PriorityQueueCris<String> stringStack = new PriorityQueueCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueue((String) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_met_strings insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertGesorteerdAflopend3() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        PriorityQueueCris<Long> stringStack = new PriorityQueueCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerd_aflopend_3 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertGesorteerdOplopend3() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        PriorityQueueCris<Long> stringStack = new PriorityQueueCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerd_oplopend_3 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertHerhaald1000() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        PriorityQueueCris<Long> stringStack = new PriorityQueueCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_herhaald_1000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstLeeg0() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_leeg_0");
        PriorityQueueCris<Long> stringStack = new PriorityQueueCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_leeg_0 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstGesorteerdeStrings() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        PriorityQueueCris<String> stringStack = new PriorityQueueCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueue((String) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerde_strings insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstOplopend10000() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        PriorityQueueCris<Long> stringStack = new PriorityQueueCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_oplopend_10000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstWillekeurig10000() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        PriorityQueueCris<Long> stringStack = new PriorityQueueCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_willekeurig_10000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstWillekeurig3() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        PriorityQueueCris<Long> stack = new PriorityQueueCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stack.enqueue((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_willekeurig_3 insertion takes: " + duration + " ms");

        int actual = stack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldRemoveHighestPriorityElement() {
        testPriorityQueueWithStrings.enqueue("b");
        testPriorityQueueWithStrings.enqueue("a");
        testPriorityQueueWithStrings.enqueue("c");
        testPriorityQueueWithStrings.enqueue("d");

        String expected = "a";
        String actual = testPriorityQueueWithStrings.dequeue();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void lowerNumbersShouldGetHigherPriority() {
        testPriorityQueueWithNumbers.enqueue(10);
        testPriorityQueueWithNumbers.enqueue(50);
        testPriorityQueueWithNumbers.enqueue(4);
        testPriorityQueueWithNumbers.enqueue(122);

        int expected = 4;
        int actual = testPriorityQueueWithNumbers.peekMin();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lowerLexicalStringValueShouldGetHigherPriority() {
        testPriorityQueueWithStrings.enqueue("b");
        testPriorityQueueWithStrings.enqueue("c");
        testPriorityQueueWithStrings.enqueue("a");
        testPriorityQueueWithStrings.enqueue("d");

        String expected = "a";
        String actual = testPriorityQueueWithStrings.peekMin();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void shouldReturnHighestPriorityElementWithoutDecrementingQueue() {
        testPriorityQueueWithStrings.enqueue("b");
        testPriorityQueueWithStrings.enqueue("a");
        testPriorityQueueWithStrings.enqueue("c");
        testPriorityQueueWithStrings.enqueue("d");

        String expected = "a";
        String actual = testPriorityQueueWithStrings.peekMin();

        int expectedSize = 4;
        int actualSize = testPriorityQueueWithStrings.size();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldReturnTrueIfQueueIsFull() {
        testPriorityQueueWithStrings.enqueue("b");
        testPriorityQueueWithStrings.enqueue("a");
        testPriorityQueueWithStrings.enqueue("c");
        testPriorityQueueWithStrings.enqueue("d");

        boolean expected = testPriorityQueueWithStrings.isFull();

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnTrueIfQueueIsEmpty() {
        boolean expected = testPriorityQueueWithStrings.isEmpty();

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnCorrectSizeOfQueue() {
        testPriorityQueueWithStrings.enqueue("b");
        testPriorityQueueWithStrings.enqueue("a");
        testPriorityQueueWithStrings.enqueue("c");

        int expected = 3;
        int actual = testPriorityQueueWithStrings.size();

        Assert.assertEquals(expected, actual);
    }
}
