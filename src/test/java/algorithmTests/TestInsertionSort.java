package algorithmTests;

import algorithms.SortingAlgorithm;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.IOException;
import java.io.InputStream;


public class TestInsertionSort {
    SortingAlgorithm sortingAlgo;
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        sortingAlgo = new SortingAlgorithm();
    }

    @Test
    public void insertionSortShouldSortList() {
        //Arrange
        JSONArray unsorted1 = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");
        JSONArray unsorted2 = (JSONArray) unsorted1.clone();

        //Act
        sortingAlgo.sortWithSortingLib(unsorted1);
        sortingAlgo.insertionSort(unsorted2);


        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }

    @Test
    public void insertionSortshouldNotSortStringList() {
        //Arrange
        JSONArray lijstOnsorteerbaar = jsonHandler.getJSONArray(jsonObject, "lijst_onsorteerbaar_3");
    }
}
