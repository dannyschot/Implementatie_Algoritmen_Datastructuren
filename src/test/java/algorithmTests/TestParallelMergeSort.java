package algorithmTests;

import algorithms.MergeSort;
import algorithms.ParallelMergeSort;
import algorithms.QuickSort;
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

public class TestParallelMergeSort {
    ParallelMergeSort parallelMergeSort;
//    MergeSort<Integer> mergeSort;
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
        parallelMergeSort = new ParallelMergeSort<>();
    }


    @SuppressWarnings("unchecked")
    @Test
    public void parallelMergeSortShouldSortList() {
        //Arrange
        ArrayList<Double> unsorted1 = dataset.getFloat8001();
        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();

        //Act
        parallelMergeSort.sortWithSortingLib(unsorted1);
        parallelMergeSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
    }
}
