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

        int expectedSize = listWithDouble.size();
        for(Object element : listWithDouble) {
            dynamicArrayDouble.addElement((Double) element);
        }
        int actualSize = dynamicArrayDouble.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldInsertDataSetLongIntoDynamicArray() {
        DynamicArray<Long> dynamicArrayInteger = new DynamicArray<>();
        JSONArray listWithLong = (JSONArray) jsonObject.get("lijst_herhaald_1000");

        int expectedSize = listWithLong.size();
        for(Object element : listWithLong) {
            dynamicArrayInteger.addElement((Long) element);
        }
        int actualSize = dynamicArrayInteger.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldInsertDataSetStringIntoDoublyLinkedList() {
        // Arrange
        DynamicArray<String> dynamicArrayString = new DynamicArray<>();
        JSONArray listWithStrings = (JSONArray) jsonObject.get("lijst_met_strings");

        //Act
        int expectedSize = listWithStrings.size();
        for(Object element : listWithStrings) {
            dynamicArrayString.addElement((String) element);
        }
        int actualSize = dynamicArrayString.size();

        //Assert
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void shouldaddElementToListAfterLastElement() {
        integerArray.addElement(10);
        integerArray.addElement(20);

        int expectedValue = 20;
        int actualValue = integerArray.get(1);

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void shouldaddElementAtSpecificIndex() {
        integerArray.addElement(20);
        integerArray.addElement(30);
        integerArray.addElement(40);
        integerArray.addElement(40);
        integerArray.addElement(1, 5);

        int expected = 30;
        int actual = integerArray.get(2);

        int expectedValueAtIndex1 = 5;
        int actualValueAtIndex1 = integerArray.get(1);

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedValueAtIndex1, actualValueAtIndex1);
    }

    @Test
    public void shouldRetreiveElementAtIndex() {
        integerArray.addElement(20);
        integerArray.addElement(30);
        integerArray.addElement(40);

        int expected = 40;
        int actual = integerArray.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteLastElement() {
        integerArray.addElement(20);
        integerArray.addElement(30);
        integerArray.addElement(50);
        integerArray.addElement(40);

        integerArray.delete();
        int expected = 50;
        int actual = integerArray.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectSizeWhenaddElementing() {
        integerArray.addElement(20);
        integerArray.addElement(30);
        integerArray.addElement(50);
        integerArray.addElement(40);

        int expected = 4;
        int actual = integerArray.size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldDoubleCapacity() {
        integerArray.addElement(20);
        integerArray.addElement(30);
        integerArray.addElement(40);


        int expected = 4;
        int actual = integerArray.getCapacity();

        Assert.assertEquals(expected, actual);

    }
}
