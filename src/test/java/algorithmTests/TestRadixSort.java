package algorithmTests;

import algorithms.RadixSort;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TestRadixSort {
    RadixSort radixSort;
    JSONObject jsonObject;
    JSONParser parser;


    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        radixSort = new RadixSort();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortList() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        radixSort.sortWithSortingLib(unsorted1);
        radixSort.sortLong(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void radixSortShouldNotSortListWithNulls() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_null_1");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();


        radixSort.sortLong(unsorted2);

        String expected = "Dataset contains null values. Cannot sort null values.";
        String actual = radixSort.getErrorMessage();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void radixSortShouldNotSortListWithNulls3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_null_3");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        radixSort.sortLong(unsorted2);

        String expected = "Dataset contains null values. Cannot sort null values.";
        String actual = radixSort.getErrorMessage();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void radixSortShouldNotSortLijstOnsorteerbaar() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_onsorteerbaar_3");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();


        radixSort.sortLong(unsorted2);

        String expected = "Contains elements which are not of equal type";
        String actual = radixSort.getErrorMessage();

        //Assert
        Assert.assertEquals(expected, actual);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void radixSortShouldDoubleList() {
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_4");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        radixSort.sortWithSortingLib(unsorted1);
        radixSort.sortDouble(unsorted2);

        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @AfterClass
    public static void endMessage() {
        System.out.println("\n");
        System.out.println("End of the radix sort test");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
    }
}
