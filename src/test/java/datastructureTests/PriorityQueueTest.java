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
    public void shouldInsertDataSetDoubleIntoPriorityQueue() {
        JSONArray listWithDouble = (JSONArray) jsonObject.get("lijst_float_8001");
        PriorityQueueCris<Double> doublePriorityQueue = new PriorityQueueCris<>(listWithDouble.size());
        Instant startTime;
        long delta;

        int actual = listWithDouble.size();

        startTime = Instant.now();
        for (Object element : listWithDouble) {
            doublePriorityQueue.enqueue((Double) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Double into Priority Queue: " + delta + "ms");

        int expected = doublePriorityQueue.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertDataSetLongIntoPriorityQueue() {
        JSONArray listWithLong = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        PriorityQueueCris<Long> longPriorityQueue = new PriorityQueueCris<>(listWithLong.size());
        Instant startTime;
        long delta;

        int expected = listWithLong.size();

        startTime = Instant.now();
        for (Object element : listWithLong) {
            longPriorityQueue.enqueue((Long) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into Priority Queue: " + delta + "ms");
        int actual = longPriorityQueue.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringsIntoPriorityQueue() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        PriorityQueueCris<String> stringPriorityQueue = new PriorityQueueCris<>(listWithStrings.size());

        Instant startTime;
        long delta;

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringPriorityQueue.enqueue((String) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting String into Priority Queue: " + delta + "ms");

        int actual = stringPriorityQueue.size();

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
