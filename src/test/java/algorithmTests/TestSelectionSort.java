//package algorithmTests;
//
//import algorithms.InsertionSort;
//import algorithms.SelectionSort;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import utils.Dataset;
//import utils.InputStreamResourceReaderStrategy;
//import utils.JSONHandler;
//import utils.ResourceReaderStrategy;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//public class TestSelectionSort { // TODO:: Testen toevoegen voor uitzonderlijke gevallen
//    SelectionSort selectionSort;
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
//    }
//
//    @SuppressWarnings("unchecked")
//    @Test
//    public void insertionSortShouldSortList() { // TODO:: Cast verwijderen
//        //Arrange
//        ArrayList<Double> unsorted1 = dataset.getFloat8001();
//        ArrayList<Double> unsorted2 = (ArrayList<Double>) unsorted1.clone();
//        selectionSort = new SelectionSort<>(unsorted2);
//
//        //Act
//        selectionSort.sortWithSortingLib(unsorted1);
//        selectionSort.sort();
//
//        int i = 0;
//        for (Double element : unsorted1) {
//            if (element == -0.0) {
//                i++;
//            }
//        }
//
//        //Assert
//        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2.toArray());
//    }
//}
