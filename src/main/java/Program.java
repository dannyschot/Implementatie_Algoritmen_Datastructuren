import algorithms.SortingAlgorithm;
import datastructures.DynamicArray;
import exceptions.DynamicArrayException;
import managers.PerformanceTester;
import managers.SortingTestingStrategy;
import managers.TestingStrategy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Program {

    public static void main(String[] args) throws IOException, ParseException, DynamicArrayException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        JSONHandler jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        JSONObject jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        TestingStrategy sortingTestStrategy = new SortingTestingStrategy();
        PerformanceTester sortingTester = new PerformanceTester(sortingTestStrategy);

        sortingTester.startTest(jsonObject);

    }
}
