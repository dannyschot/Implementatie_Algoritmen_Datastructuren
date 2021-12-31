package algorithmTests;

import algorithms.InsertionSort;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;


public class TestInsertionSort {
    InsertionSort insertionSort;
    JSONObject jsonObject;
    JSONParser parser;
    Instant startTime;
    Instant endTime;
    long delta;


    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        insertionSort = new InsertionSort();
    }

    @Test
    public void insertionSortShouldSortList() { // TODO:: Cast verwijderen
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @Test
    public void insertionSortShouldThrowExceptionWhenNullInData() { // TODO:: NullPointer asserten
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("eigen_lijst");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        Exception exception = new NullPointerException();

        //Act
//        insertionSort.sortWithSortingLib(unsorted1);
//        insertionSort.sort(unsorted2);

//        Assert.assertTrue();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstAflopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        insertionSort.sort(unsorted2);
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());

    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstOplopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstGesorteerdAflopend3() throws InterruptedException {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());

    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstGesorteerdOplopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);;
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstHerhaald1000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstLeeg0() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_leeg_0");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstGesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstOngesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstOplopend10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstWillekeurig10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        insertionSort.sortWithSortingLib(unsorted1);
        insertionSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortLijstOnsorteerbaar() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_onsorteerbaar_3");
        insertionSort.sort(unsorted1);
    }



    @AfterClass
    public static void endMessage() {
        System.out.println("\n");
        System.out.println("End of the insertion sort test");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
    }
}
