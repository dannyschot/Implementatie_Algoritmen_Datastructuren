import datastructures.HashTableCris;
import managers.PerformanceTester;
import managers.SortingTestingStrategy;
import managers.TestingStrategy;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.*;

class Program {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        JSONHandler jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        JSONObject jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        TestingStrategy sortingTestStrategy = new SortingTestingStrategy<>();
        PerformanceTester sortingTester = new PerformanceTester(sortingTestStrategy);

        sortingTester.startTest(jsonObject);

//        HashTableCris<String, Integer> tbl = new HashTableCris<String, Integer>(5);
//
//        tbl.insert("one", 1);
//        tbl.insert("three", 3);
//        tbl.insert("nineteen", 19);
//        tbl.insert("fifteen", 15);
//        tbl.insert("six", 6);
//
//        System.out.println("After Insert");
//
//        System.out.println("three :: "+tbl.get("three"));
//        System.out.println("six :: "+tbl.get("six"));

        /*tbl.remove("three");

        System.out.println(tbl.get("three"));*/

//        tbl.resize(8);
//
//        System.out.println("After Resize");
//
//        System.out.println("three :: "+tbl.get("three"));
//        System.out.println("six :: "+tbl.get("six"));
//
//        tbl.insert("hundred", 100);
//
//        System.out.println("hundred :: "+tbl.get("hundred"));

    }
}
