package algorithmTests;

import algorithms.ParallelMergeSort;
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
import java.util.ArrayList;

public class TestParallelMergeSort {
    ParallelMergeSort parallelMergeSort;
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
        parallelMergeSort = new ParallelMergeSort();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortList() { // TODO:: Cast verwijderen
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_float_8001 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @Test
    public void parallelMergeSortShouldThrowExceptionWhenNullInData() { // TODO:: NullPointer asserten
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("eigen_lijst");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
        Exception exception = new NullPointerException();

        //Act
//        parallelMergeSort.sortWithSortingLib(unsorted1);
//        parallelMergeSort.sort(unsorted2);

//        Assert.assertTrue();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstAflopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_aflopend_2 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstOplopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_oplopend_2 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstGesorteerdAflopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_gesorteerd_aflopend_3 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstGesorteerdOplopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_gesorteerd_oplopend_3 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstHerhaald1000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_herhaald_1000 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstLeeg0() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_leeg_0");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts llijst_leeg_0 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstGesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sort sorts lijst_gesorteerde_strings in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstOngesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        ArrayList<String> unsorted2 = (ArrayList<String>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sort sorts lijst_ongesorteerde_strings in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstOplopend10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sort sorts lijst_oplopend_10000 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortLijstWillekeurig10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        ArrayList<Long> unsorted2 = (ArrayList<Long>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        startTime = Instant.now();
        parallelMergeSort.sort(unsorted2);
        endTime = Instant.now();
        delta = Duration.between(startTime, endTime).toNanos();
        System.out.println("parallelMergeSort sorts lijst_willekeurig_10000 in: " + delta + " nanoseconds");

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }
}
