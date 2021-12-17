package algorithmTests;

import algorithms.QuickSort;
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
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class TestQuickSort {
    QuickSort quickSort;
    JSONObject jsonObject;
    JSONParser parser;


    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        quickSort = new QuickSort();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortList() { // TODO:: Cast verwijderen
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @Test
    public void quickSortShouldThrowExceptionWhenNullInData() { // TODO:: NullPointer asserten
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("eigen_lijst");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        Exception exception = new NullPointerException();

        //Act
//        quickSort.sortWithSortingLib(unsorted1);
//        quickSort.sort(unsorted2);

//        Assert.assertTrue();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstAflopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstOplopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstGesorteerdAflopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstGesorteerdOplopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstHerhaald1000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstLeeg0() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_leeg_0");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstGesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstOngesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstOplopend10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void quickSortShouldSortLijstWillekeurig10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        quickSort.sortWithSortingLib(unsorted1);
        quickSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @AfterClass
    public static void endMessage() {
        System.out.println("\n");
        System.out.println("End of the quick sort test");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
    }
}
