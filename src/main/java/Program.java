import algorithms.SortingAlgorithm;
import datastructures.DynamicArray;
import exceptions.DynamicArrayException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.*;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) throws IOException, ParseException, DynamicArrayException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        JSONHandler jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        JSONObject jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        JSONArray currentArray = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");
        SortingAlgorithm sortingAlgo = new SortingAlgorithm();

        sortingAlgo.sort(currentArray);

        DynamicArray<Integer>  testArray = new DynamicArray<>();
        testArray.add(5);
        testArray.add(10);
        testArray.add(20);
        testArray.showElements();
    }
}
