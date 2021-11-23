package datastructureTests;

import datastructures.IStack;
import datastructures.StackCris;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Dataset;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class StackTest {
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;
    IStack<Integer> testStack;

    @Before
    public void setup() throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        dataset = new Dataset();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        testStack = new StackCris<>(5);
    }

    @Test
    public void shouldInsertDataSetDoubleIntoStack() {
        ArrayList<Double> listWithDouble = dataset.getFloat8001();
        IStack<Double> doubleStack = new StackCris<>(listWithDouble.size());
        Instant startTime;
        long delta;

        int actual = listWithDouble.size();

        startTime = Instant.now();
        for (Double element : listWithDouble) {
            doubleStack.push(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Double into Stack: " + delta + "ms");

        int expected = doubleStack.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertDataSetLongIntoStack() {
        ArrayList<Long> listWithLong = dataset.getLijstHerhaald1000();
        IStack<Long> longStack = new StackCris<>(listWithLong.size());
        Instant startTime;
        long delta;

        int expected = listWithLong.size();

        startTime = Instant.now();
        for (Long element : listWithLong) {
            longStack.push(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into Stack: " + delta + "ms");
        int actual = longStack.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringsIntoStack() {
        ArrayList<String> listWithStrings = dataset.getLijstMetStrings();;
        IStack<String> stringStack = new StackCris<>(listWithStrings.size());

        Instant startTime;
        long delta;

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (String element : listWithStrings) {
            stringStack.push(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting String into Stack: " + delta + "ms");

        int actual = stringStack.size();

        Assert.assertEquals(expected, actual);
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
