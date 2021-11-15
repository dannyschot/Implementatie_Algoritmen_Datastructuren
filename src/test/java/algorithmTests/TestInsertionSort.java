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
        JSONArray aflopendeArray = jsonHandler.getJSONArray(jsonObject, "lijst_aflopend_2");
        JSONArray oplopendeArray = jsonHandler.getJSONArray(jsonObject, "lijst_oplopend_2");
        JSONArray oplopendeArray3 = jsonHandler.getJSONArray(jsonObject, "lijst_willekeurig_3");
        JSONArray lijstHerhaald = jsonHandler.getJSONArray(jsonObject, "lijst_herhaald_1000");
        JSONArray legeLijst = jsonHandler.getJSONArray(jsonObject, "lijst_leeg_0");
        JSONArray lijstNull1 = jsonHandler.getJSONArray(jsonObject, "lijst_null_1");
        JSONArray lijstOplopend = jsonHandler.getJSONArray(jsonObject, "lijst_oplopend_10000");
        JSONArray lijstWillekeurig10000 = jsonHandler.getJSONArray(jsonObject, "ijst_willekeurig_10000");

        sortingAlgo = new SortingAlgorithm();
    }

    @Test
    public <T> void insertionSortShouldSortList() {
        //Arrange
        JSONArray floatArray = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");
        ArrayList<Float> sortedWithLib;
        ArrayList<Float> sortedWithAlgo;

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
