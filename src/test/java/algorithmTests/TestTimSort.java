package algorithmTests;

import algorithms.SelectionSort;
import algorithms.TimSort;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Dataset;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TestTimSort {
    TimSort timSort;
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        dataset = new Dataset();
        timSort = new TimSort<>();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortList() {
        //Arrange
        ArrayList<Double> unsorted1 = dataset.getFloat8001();
        Double[] unsorted2 = new Double[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }
}
