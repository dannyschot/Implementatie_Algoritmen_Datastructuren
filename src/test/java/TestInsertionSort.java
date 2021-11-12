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
        sortingAlgo = new SortingAlgorithm();
    }

    @Test
    public <T> void testSpeedOfInsertionSortFloat8001() {
        //Arrange
        JSONArray floatArray = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");
        ArrayList<Float> list;
        list = sortingAlgo.convertToArrayList(floatArray);
        ArrayList<Float> sortedWithLib;
        ArrayList<Float> sortedWithAlgo;

        //Act
        sortedWithLib = sortingAlgo.sortWithSortingLib(list);
        sortedWithAlgo = sortingAlgo.insertionSort(list);

        //Assert
        Assert.assertArrayEquals(sortedWithLib.toArray(), sortedWithAlgo.toArray());
    }
}
