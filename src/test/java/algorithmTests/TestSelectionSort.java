package algorithmTests;

import algorithms.SelectionSort;
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

public class TestSelectionSort { // TODO:: Testen toevoegen voor uitzonderlijke gevallen
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
    public void insertionSortShouldSortList() { // TODO:: Cast verwijderen
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
}
