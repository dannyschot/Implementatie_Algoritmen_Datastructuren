package datastructureTests;

import datastructures.DoublyLinkedList;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.*;
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
        ListIterator<Double> iter = doublyLinkedListDouble.getIterator();
        int sizeOfJsonArray = listWithFloat.size();
        Instant startTime;
        long delta;

        startTime = Instant.now();
        for (Double element : listWithFloat) {
            iter.insertBefore(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Double into Doubly Linked List: " + delta + "ms");
        int sizeOfFilledDoublyLinkedList = doublyLinkedListDouble.getSize();

        Assert.assertEquals(sizeOfJsonArray, sizeOfFilledDoublyLinkedList);
    }

    @Test
    public void shouldInsertDataSetLongIntoDoublyLinkedList() {
        DoublyLinkedList<Long> doublyLinkedListLong = new DoublyLinkedList<>();
        ArrayList<Long> listWithLong = dataset.getLijstHerhaald1000();
        ListIterator<Long> iter = doublyLinkedListLong.getIterator();
        Instant startTime;
        long delta;

        int expected = listWithLong.size();

        startTime = Instant.now();
        for (Long element : listWithLong) {
            iter.insertBefore(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Long into Doubly Linked List: " + delta + "ms");

        int actual = doublyLinkedListLong.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringIntoDoublyLinkedList() {
        DoublyLinkedList<String> doublyLinkedListString = new DoublyLinkedList<>();
        ArrayList<String> listWithStrings = dataset.getLijstMetStrings();
        ListIterator<String> iter = doublyLinkedListString.getIterator();
        Instant startTime;
        long delta;

        int expected = listWithStrings.size();

        startTime = Instant.now();
        for (String element : listWithStrings) {
            iter.insertBefore(element);
        }
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting String into Doubly Linked List: " + delta + "ms");

        int actual = doublyLinkedListString.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAtStart() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);

        Integer expected = 20;
        Integer actual = doublyLinkedList.getFirstElement();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteFirst() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.insertBefore(50);

        doublyLinkedList.deleteFirst();

        Integer expected = 20;
        Integer actual = doublyLinkedList.getFirstElement();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCorrectCurrent() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.insertBefore(50);

        int expected = 50;
        int actual = iter.getCurrent().getData();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteCorrectCurrentAndSetNewCorrectCurrent() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.insertBefore(50);

        int expectedDeletedCurrent = 50;
        int actualDeletedCurrent = iter.deleteCurrent();

        int expected = 20;
        int actual = iter.getCurrent().getData();

        Assert.assertEquals(expectedDeletedCurrent, actualDeletedCurrent);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertAfter() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.insertAfter(50);

        int expected = 20;
        int actual = doublyLinkedList.getFirstElement();

        Assert.assertEquals(expected, actual);
    }

}
