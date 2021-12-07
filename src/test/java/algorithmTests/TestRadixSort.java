package algorithmTests;

import algorithms.QuickSort;
import algorithms.RadixSort;
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

public class TestRadixSort {
    RadixSort radixSort;
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;

    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        dataset = new Dataset();
        radixSort = new RadixSort();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortList() { // TODO:: Cast verwijderen
        //Arrange
        ArrayList<Long> unsorted1 = dataset.getLijstWillekeurig10000();
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = unsorted1.get(i);
        }


        //Act
        radixSort.sortWithSortingLib(unsorted1);
        radixSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }
}
