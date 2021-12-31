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
    Instant startTime;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        testDequeue = new Deque<>(4);
    }

    @Test
    public void shouldInsertEigenLijst() {
        JSONArray list = (JSONArray) jsonObject.get("eigen_lijst");

        Deque<Long> doubleStack = new Deque<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Eigen Lijst insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstFloat8001() {
        JSONArray listWithDouble = (JSONArray) jsonObject.get("lijst_float_8001");

        Deque<Double> doubleStack = new Deque<>(listWithDouble.size());

        int actual = listWithDouble.size();
        startTime = Instant.now();
        for (Object element : listWithDouble) {
            doubleStack.enqueFront((Double) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_float_8001 insertion takes: " +duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstAflopend2() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_aflopend_2");

        Deque<Long> doubleStack = new Deque<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_aflopend_2 insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstOplopend2() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_oplopend_2");

        Deque<Long> doubleStack = new Deque<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_oplopend_2 insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstHerhaald1000() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        Deque<Long> longStack = new Deque<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            longStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_herhaald_1000 insertion takes: " + duration + " ms");

        int actual = longStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstMetStrings() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        Deque<String> stringStack = new Deque<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueFront((String) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_met_strings insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertGesorteerdAflopend3() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        Deque<Long> stringStack = new Deque<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerd_aflopend_3 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertGesorteerdOplopend3() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        Deque<Long> stringStack = new Deque<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerd_oplopend_3 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertHerhaald1000() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        Deque<Long> stringStack = new Deque<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_herhaald_1000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstLeeg0() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_leeg_0");
        Deque<Long> stringStack = new Deque<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_leeg_0 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstGesorteerdeStrings() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        Deque<String> stringStack = new Deque<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueFront((String) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerde_strings insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstOplopend10000() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        Deque<Long> stringStack = new Deque<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_oplopend_10000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstWillekeurig10000() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        Deque<Long> stringStack = new Deque<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_willekeurig_10000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstWillekeurig3() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        Deque<Long> stack = new Deque<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stack.enqueFront((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_willekeurig_3 insertion takes: " + duration + " ms");

        int actual = stack.size();
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
