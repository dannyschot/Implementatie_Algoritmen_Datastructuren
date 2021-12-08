package datastructureTests;

import datastructures.DynamicArray;
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


public class DynamicArrayTest {
    JSONObject jsonObject;
    JSONParser parser;
    DynamicArray<Integer> integerArray;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        integerArray = new DynamicArray<>();
    }

    @Test
    public void shouldInsertDataSetDoubleIntoDynamicArray(){
        DynamicArray<Double> dynamicArrayDouble = new DynamicArray<>();
        JSONArray listWithDouble = (JSONArray) jsonObject.get("lijst_float_8001");
        Instant startTime;
        long delta;

        int expectedSize = listWithDouble.size();
        startTime = Instant.now();
        dynamicArrayDouble.addAll(listWithDouble);
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting Double into Dynamic Array: " + delta + "ms");

        int actualSize = dynamicArrayDouble.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldInsertDataSetLongIntoDynamicArray() {
        DynamicArray<Long> dynamicArrayInteger = new DynamicArray<>();
        JSONArray listWithLong = (JSONArray) jsonObject.get("lijst_herhaald_1000");


        Instant startTime;
        long delta;

        int expectedSize = listWithLong.size();

        startTime = Instant.now();
        dynamicArrayInteger.addAll(listWithLong);
        delta = Duration.between(startTime, Instant.now()).toMillis();

        System.out.println("Duration for inserting Long into Dynamic Array: " + delta + "ms");
        int actualSize = dynamicArrayInteger.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldInsertDataSetStringIntoDoublyLinkedList() {
        // Arrange
        DynamicArray<String> dynamicArrayString = new DynamicArray<>();
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");
        Instant startTime;
        long delta;

        //Act
        int expectedSize = listWithStrings.size();

        startTime = Instant.now();
        dynamicArrayString.addAll(listWithStrings);
        delta = Duration.between(startTime, Instant.now()).toMillis();
        System.out.println("Duration for inserting String into Dynamic Array: " + delta + "ms");
        int actualSize = dynamicArrayString.size();

        //Assert
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldAddToListAfterLastElement() {
        integerArray.add(10);
        integerArray.add(20);

        int expectedValue = 20;
        int actualValue = integerArray.get(1);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldAddAtSpecificIndex() {
        integerArray.add(20);
        integerArray.add(30);
        integerArray.add(40);
        integerArray.add(1, 5);

        int expected = 30;
        int actual = integerArray.get(2);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldRetreiveElementAtIndex() {
        integerArray.add(20);
        integerArray.add(30);
        integerArray.add(40);

        int expected = 40;
        int actual = integerArray.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteLastElement() {
        integerArray.add(20);
        integerArray.add(30);
        integerArray.add(50);
        integerArray.add(40);

        integerArray.delete();
        int expected = 50;
        int actual = integerArray.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectSizeWhenAdding() {
        integerArray.add(20);
        integerArray.add(30);
        integerArray.add(50);
        integerArray.add(40);


    }
}
