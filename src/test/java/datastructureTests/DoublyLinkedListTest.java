package datastructureTests;

import datastructures.DoublyLinkedList;
import org.json.simple.JSONArray;
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

public class DoublyLinkedListTest<T> {
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;

    @Before
    public void setup() throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        dataset = new Dataset();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
    }

    @Test
    public void shouldInsertDataSetDoubleIntoDoublyLinkedList() {
        DoublyLinkedList<Double> doublyLinkedListDouble = new DoublyLinkedList<>();
        ArrayList<Double> listWithFloat = dataset.getFloat8001();
        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (Double element : listWithFloat) {
            doublyLinkedListDouble.insertFirst(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Double into Doubly Linked List: " + delta + "ms");
        int sizeOfFilledDoublyLinkedList = doublyLinkedListDouble.getSize();

        Assert.assertEquals(sizeOfJsonArray, sizeOfFilledDoublyLinkedList);
    }

    @Test
    public void shouldInsertDataSetLongIntoDoublyLinkedList() {
        DoublyLinkedList<Long> doublyLinkedListInteger = new DoublyLinkedList<>();
        ArrayList<Long> listWithLong = dataset.getLijstHerhaald1000();
        Instant startTime;
        long delta;

        int expected = listWithLong.size();

        startTime = Instant.now();
        for (Long element : listWithLong) {
            doublyLinkedListInteger.insertFirst(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Long into Doubly Linked List: " + delta + "ms");

        int actual = doublyLinkedListInteger.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringIntoDoublyLinkedList() {
        DoublyLinkedList<String> doublyLinkedListInteger = new DoublyLinkedList<>();
        ArrayList<String> listWithStrings = dataset.getLijstMetStrings();
        Instant startTime;
        long delta;

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (String element : listWithStrings) {
            doublyLinkedListInteger.insertFirst(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting String into Doubly Linked List: " + delta + "ms");

        int actual = doublyLinkedListInteger.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAtStart() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertFirst(20);

        Integer expected = 20;
        Integer actual = doublyLinkedList.getFirst();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAtEnd() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertFirst(20);

        Integer expected = 10;
        Integer actual = doublyLinkedList.getLast();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAfter() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertFirst(20);
        doublyLinkedList.insertFirst(50);


        boolean expected = true;
        boolean actual = doublyLinkedList.insertAfter(20, 30);

        int expectedValue = 10;
        int actualValue = doublyLinkedList.getLast();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldDeleteFirst() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertFirst(20);
        doublyLinkedList.insertFirst(50);

        doublyLinkedList.deleteFirst();

        Integer expected = 20;
        Integer actual = doublyLinkedList.getFirst();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteLast() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.insertFirst(10);
        doublyLinkedList.insertFirst(20);
        doublyLinkedList.insertFirst(50);
        doublyLinkedList.insertFirst(100);

        doublyLinkedList.deleteLast();

        Integer expected = 20;
        Integer actual = doublyLinkedList.getLast();

        Assert.assertEquals(expected, actual);

    }
}
