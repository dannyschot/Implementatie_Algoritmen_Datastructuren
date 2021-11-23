package datastructureTests;

import datastructures.Deque;
import datastructures.IDequeue;
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

public class DequeueTest {
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;
    IDequeue<Integer> testDequeue;

    @Before
    public void setup() throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        dataset = new Dataset();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        testDequeue = new Deque<>(4);
    }

    @Test
    public void shouldInsertDataSetDoubleIntoDequeue() {
        ArrayList<Double> listWithDouble = dataset.getFloat8001();
        IDequeue<Double> doubleDequeue = new Deque<>(listWithDouble.size());
        Instant startTime;
        long delta;

        int actual = listWithDouble.size();

        startTime = Instant.now();
        for (Double element : listWithDouble) {
            doubleDequeue.enqueFront(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Double into Dequeue: " + delta + "ms");

        int expected = doubleDequeue.size();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldInsertDataSetLongIntoDequeue() {
        ArrayList<Long> listWithLong = dataset.getLijstHerhaald1000();
        IDequeue<Long> longDequeue = new Deque<>(listWithLong.size());
        Instant startTime;
        long delta;

        int expected = listWithLong.size();

        startTime = Instant.now();
        for (Long element : listWithLong) {
            longDequeue.enqueFront(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into Dequeue: " + delta + "ms");
        int actual = longDequeue.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringsIntoDequeue() {
        ArrayList<String> listWithStrings = dataset.getLijstMetStrings();;
        IDequeue<String> stringDequeue = new Deque<>(listWithStrings.size());

        Instant startTime;
        long delta;

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (String element : listWithStrings) {
            stringDequeue.enqueFront(element);
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
