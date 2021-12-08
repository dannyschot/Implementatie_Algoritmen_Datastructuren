//package algorithmTests;
//
//import algorithms.InsertionSort;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import utils.Dataset;
//import utils.InputStreamResourceReaderStrategy;
//import utils.JSONHandler;
//import utils.ResourceReaderStrategy;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//
//public class TestInsertionSort {
//    InsertionSort sortingAlgo;
//    JSONHandler jsonHandler;
//    JSONObject jsonObject;
//    Dataset dataset;
//
//    @Before
//    public void setup() throws IOException, ParseException, InterruptedException {
//        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
//        jsonHandler = new JSONHandler();
//        InputStream is = reader.getFileFromResource("datasets/sorting.json");
//        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
//        dataset = new Dataset();
//        sortingAlgo = new InsertionSort();
//    }
//
//    @Test
//    public void insertionSortShouldSortList() { // TODO:: Cast verwijderen
//        //Arrange
//        ArrayList<Double> unsorted1 = dataset.getFloat8001();
//        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
//
//        //Act
//        sortingAlgo.sortWithSortingLib(unsorted1);
//        sortingAlgo.sort(unsorted2);
//
//        //Assert
//        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
//    }
//}
