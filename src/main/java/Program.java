import datastructures.Deque;
import datastructures.DynamicArray;
import datastructures.PriorityQueueCris;
import managers.PerformanceTester;
import managers.SortingTestingStrategy;
import managers.TestingStrategy;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.*;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        JSONHandler jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        JSONObject jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        TestingStrategy sortingTestStrategy = new SortingTestingStrategy();
        PerformanceTester sortingTester = new PerformanceTester(sortingTestStrategy);

//        sortingTester.startTest(jsonObject);

    }
}
