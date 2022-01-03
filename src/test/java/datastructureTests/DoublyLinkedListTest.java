package datastructureTests;

import datastructures.DoublyLinkedList;
import datastructures.ListIterator;
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

public class DoublyLinkedListTest<T> {
    JSONObject jsonObject;
    JSONParser parser;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Test
    public void shouldInsertDataSetDoubleIntoDoublyLinkedList() {
        DoublyLinkedList<Double> doublyLinkedListDouble = new DoublyLinkedList<>();
        JSONArray listWithFloat = (JSONArray) jsonObject.get("lijst_float_8001");
        ListIterator<Double> iter = doublyLinkedListDouble.getIterator();
        int sizeOfJsonArray = listWithFloat.size();

        for (Object element : listWithFloat) {
            iter.insertBefore((Double) element);
        }
        int sizeOfFilledDoublyLinkedList = doublyLinkedListDouble.getSize();

        Assert.assertEquals(sizeOfJsonArray, sizeOfFilledDoublyLinkedList);
    }

    @Test
    public void shouldInsertDataSetLongIntoDoublyLinkedList() {
        DoublyLinkedList<Long> doublyLinkedListLong = new DoublyLinkedList<>();
        JSONArray listWithLong = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        ListIterator<Long> iter = doublyLinkedListLong.getIterator();

        int expected = listWithLong.size();
        for (Object element : listWithLong) {
            iter.insertBefore((Long) element);
        }
        int actual = doublyLinkedListLong.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertDataSetStringIntoDoublyLinkedList() {
        DoublyLinkedList<String> doublyLinkedListString = new DoublyLinkedList<>();
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        ListIterator<String> iter = doublyLinkedListString.getIterator();

        int expected = listWithStrings.size();
        for (Object element : listWithStrings) {
            iter.insertBefore((String) element);
        }
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

    @Test
    public void shouldNotBeEmpty() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.insertAfter(50);

        boolean expected = false;
        boolean actual = doublyLinkedList.isEmpty();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEmpty() {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        ListIterator<Integer> iter = doublyLinkedList.getIterator();
        iter.insertBefore(10);
        iter.insertBefore(20);
        iter.insertAfter(50);

        for (int i = 0; i < 3; i++) {
            iter.deleteCurrent();
        }

        boolean expected = true;
        boolean actual = doublyLinkedList.isEmpty();

        Assert.assertEquals(expected, actual);
    }

}
