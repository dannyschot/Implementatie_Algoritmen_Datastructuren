import algorithms.SortingAlgorithm;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import utils.InputStreamResourceReaderStrategy;
import utils.JSONHandler;
import utils.JSONHandler;
import utils.ResourceReaderStrategy;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        JSONHandler jsonHandler = new JSONHandler();
        InputStream is = reader.getFileFromResource("datasets/sorting.json");
        JSONObject jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        JSONArray currentArray = jsonHandler.getJSONArray(jsonObject, "lijst_float_8001");
        SortingAlgorithm sortingAlgo = new SortingAlgorithm();

        sortingAlgo.sort(currentArray);

    }

}
