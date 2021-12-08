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
import java.util.ArrayList;

public class TestParallelMergeSort {
    ParallelMergeSort parallelMergeSort;
    JSONObject jsonObject;
    JSONParser parser;


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
    public void shouldSortList() { // TODO:: Cast verwijderen
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        parallelMergeSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }
}
