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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public <T> void insertionSortShouldSortList() {
        //Arrange
        JSONArray floatArray = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");
        List<Float> sortedWithLib;
        List<Float> sortedWithAlgo;

        //Act
        sortedWithLib = sortingAlgo.sortWithSortingLib(floatArray);
        sortedWithAlgo = sortingAlgo.insertionSort(floatArray);

        //Assert
        Assert.assertArrayEquals(sortedWithLib.toArray(), sortedWithAlgo.toArray());
    }

    @Test
    public void insertionSortshouldNotSortStringList() {
        //Arrange
        JSONArray lijstOnsorteerbaar = jsonHandler.getJSONArray(jsonObject, "lijst_onsorteerbaar_3");

    }
}
