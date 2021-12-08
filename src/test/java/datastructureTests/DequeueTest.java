package datastructureTests;

import datastructures.Deque;
import datastructures.IDequeue;
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

public class DequeueTest {
    JSONObject jsonObject;
    JSONParser parser;
    IDequeue<Integer> testDequeue;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        testDequeue = new Deque<>(4);
    }

    @Test
    public void shouldInsertDataSetDoubleIntoDequeue() {
        JSONArray listWithDouble = (JSONArray) jsonObject.get("lijst_float_8001");
        IDequeue<Double> doubleDequeue = new Deque<>(listWithDouble.size());
        Instant startTime;
        long delta;

        int actual = listWithDouble.size();

        startTime = Instant.now();
        for (Object element : listWithDouble) {
            doubleDequeue.enqueFront((Double) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Double into Dequeue: " + delta + "ms");

        int expected = doubleDequeue.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertDataSetLongIntoDequeue() {
        JSONArray listWithLong = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        IDequeue<Long> longDequeue = new Deque<>(listWithLong.size());
        Instant startTime;
        long delta;

        int expected = listWithLong.size();

        startTime = Instant.now();
        for (Object element : listWithLong) {
            longDequeue.enqueFront((Long) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into Dequeue: " + delta + "ms");
        int actual = longDequeue.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringsIntoDequeue() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        IDequeue<String> stringDequeue = new Deque<>(listWithStrings.size());

        Instant startTime;
        long delta;

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringDequeue.enqueFront((String) element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting String into Dequeue: " + delta + "ms");

        int actual = stringDequeue.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAtFrontOfDequeue() {
        testDequeue.enqueFront(10);
        testDequeue.enqueFront(30);
        testDequeue.enqueFront(50);

        int expected = 50;
        int actual = testDequeue.peekFront();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAtRearOfDequeue() {
        testDequeue.enqueRear(10);
        testDequeue.enqueRear(30);
        testDequeue.enqueRear(50);

        int expected = 50;
        int actual = testDequeue.peekRear();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFromFrontOfDequeue() {
        testDequeue.enqueFront(10);
        testDequeue.enqueFront(30);
        testDequeue.enqueFront(50);
        testDequeue.enqueFront(100);
        testDequeue.dequeFront();

        int expected = 50;
        int actual = testDequeue.peekFront();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveFromRearOfDequeue() {
        testDequeue.enqueRear(10);
        testDequeue.enqueRear(30);
        testDequeue.enqueRear(50);
        testDequeue.enqueRear(100);
        testDequeue.dequeRear();

        int expected = 50;
        int actual = testDequeue.peekRear();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldPeekAtFrontOfDequeueWithoutDecrementingSize() {
        testDequeue.enqueFront(10);
        testDequeue.enqueFront(30);
        testDequeue.enqueFront(50);
        testDequeue.enqueFront(100);

        int expected = 100;
        int actual = testDequeue.peekFront();
        int expectedSize = 4;
        int actualSize = testDequeue.size();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldPeekAtRearOfDequeueWithoutDecrementingSize() {
        testDequeue.enqueRear(10);
        testDequeue.enqueRear(30);
        testDequeue.enqueRear(50);
        testDequeue.enqueRear(100);

        int expected = 100;
        int actual = testDequeue.peekRear();
        int expectedSize = 4;
        int actualSize = testDequeue.size();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldReturnTrueIfDequeueIsFull() {
        testDequeue.enqueFront(10);
        testDequeue.enqueFront(30);
        testDequeue.enqueFront(50);
        testDequeue.enqueFront(100);

        boolean actual = testDequeue.isFull();

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfDequeueIsEmpty() {
        boolean actual = testDequeue.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnCorrectSizeOfDequeue() {
        testDequeue.enqueFront(10);
        testDequeue.enqueFront(30);
        testDequeue.enqueFront(50);

        int expected = 3;
        int actual = testDequeue.size();

        Assert.assertEquals(expected, actual);

    }
}
