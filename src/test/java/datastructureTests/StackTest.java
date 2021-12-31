package datastructureTests;

import datastructures.IStack;
import datastructures.StackCris;
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

public class StackTest {
    JSONObject jsonObject;
    JSONParser parser;
    IStack<Integer> testStack;
    Instant startTime;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        testStack = new StackCris<>(5);
    }

    @Test
    public void shouldInsertEigenLijstIntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("eigen_lijst");

        IStack<Long> doubleStack = new StackCris<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Eigen Lijst insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstFloat8001IntoStack() {
        JSONArray listWithDouble = (JSONArray) jsonObject.get("lijst_float_8001");

        IStack<Double> doubleStack = new StackCris<>(listWithDouble.size());

        int actual = listWithDouble.size();
        startTime = Instant.now();
        for (Object element : listWithDouble) {
            doubleStack.push((Double) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_float_8001 insertion takes: " +duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstAflopend2IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_aflopend_2");

        IStack<Long> doubleStack = new StackCris<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_aflopend_2 insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstOplopend2IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_oplopend_2");

        IStack<Long> doubleStack = new StackCris<>(list.size());

        int actual = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            doubleStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_oplopend_2 insertion takes: " + duration + " ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertLijstHerhaald1000IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        IStack<Long> longStack = new StackCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            longStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_herhaald_1000 insertion takes: " + duration + " ms");

        int actual = longStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstMetStringsIntoStack() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        IStack<String> stringStack = new StackCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.push((String) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_met_strings insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertGesorteerdAflopend3IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        IStack<Long> stringStack = new StackCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerd_aflopend_3 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertGesorteerdOplopend3IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        IStack<Long> stringStack = new StackCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerd_oplopend_3 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertHerhaald1000IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        IStack<Long> stringStack = new StackCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stringStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_herhaald_1000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstLeeg0IntoStack() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_leeg_0");
        IStack<Long> stringStack = new StackCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_leeg_0 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstGesorteerdeStringsIntoStack() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        IStack<String> stringStack = new StackCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.push((String) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_gesorteerde_strings insertion takes: " + duration + " ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertLijstOplopend10000IntoStack() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        IStack<Long> stringStack = new StackCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_oplopend_10000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstWillekeurig10000IntoStack() {
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        IStack<Long> stringStack = new StackCris<>(listWithStrings.size());

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (Object element : listWithStrings) {
            stringStack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_willekeurig_10000 insertion takes: " + duration + " ms");

        int actual = stringStack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldInsertLijstWillekeurig3IntoStack() {
        JSONArray list = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        IStack<Long> stack = new StackCris<>(list.size());

        int expected = list.size();

        startTime = Instant.now();
        for (Object element : list) {
            stack.push((Long) element);
        }
        long duration = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("lijst_willekeurig_3 insertion takes: " + duration + " ms");

        int actual = stack.size();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void insertionShouldTakeConstantTime() {
        JSONArray listWithLong = (JSONArray) jsonObject.get("lijst_herhaald_1000");

        IStack<Long> longStack = new StackCris<>(listWithLong.size() * 2);
        Instant startTime;
        long delta;

        for (Object element : listWithLong) {
            longStack.push((Long) element);
        }

        startTime = Instant.now();
        longStack.push(10L);
        delta = Duration.between(startTime, Instant.now()).toNanos();

        IStack<Long> longStackEmpty = new StackCris<>(listWithLong.size());

        startTime = Instant.now();
        longStackEmpty.push(10L);
        delta = Duration.between(startTime, Instant.now()).toNanos();
    }

    @Test
    public void shouldAddElementOnTopOfStack() {
        testStack.push(10);
        testStack.push(5);

        int expected = 5;
        int actual = testStack.peek();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveElementFromTopOfStack() {
        testStack.push(10);
        testStack.push(5);
        testStack.pop();

        int expected = 10;
        int actual = testStack.peek();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void peekShouldReturnTopElementWithoutDecrementingSize() {
        testStack.push(10);
        testStack.push(5);
        testStack.push(20);


        int expected = 20;
        int actual = testStack.peek();

        int expectedSize = 3;
        int actualSize = testStack.size();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldReturnTrueIfStackIsEmpty() {
        boolean actual = testStack.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueIfStackIsFull() {
        testStack.push(10);
        testStack.push(5);
        testStack.push(20);
        testStack.push(50);
        testStack.push(70);

        boolean actual = testStack.isFull();

        Assert.assertTrue(actual);
    }
}
