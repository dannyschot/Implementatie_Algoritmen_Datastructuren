package algorithmTests;

import algorithms.SelectionSort;
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

public class TestSelectionSort {
    SelectionSort selectionSort;
    JSONObject jsonObject;
    JSONParser parser;

    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortList() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }


    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstAflopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstOplopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstGesorteerdAflopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstGesorteerdOplopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstHerhaald1000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstLeeg0() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_leeg_0");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstGesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstOngesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstOplopend10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstWillekeurig10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstWillekeurig3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLib(unsorted1);
        selectionSort.sort();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void selectionSortShouldSortLijstWillekeurig3Descending() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();
        selectionSort = new SelectionSort<>(unsorted2);

        //Act
        selectionSort.sortWithSortingLibDescending(unsorted1);
        selectionSort.sortDescending();

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @AfterClass
    public static void endMessage() {
        System.out.println("\n");
        System.out.println("End of the selection sort test");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
    }
}
