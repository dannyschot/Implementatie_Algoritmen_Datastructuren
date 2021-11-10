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

    public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        JSONHandler jsonHandler = new JSONHandler();
        System.out.println("Please enter the dataset: ");
        BufferedReader readFromConsole =
                new BufferedReader(new InputStreamReader(System.in));
        String dataset = readFromConsole.readLine();
        String fileName = String.format("datasets/%s.json", dataset);
        InputStream is = reader.getFileFromResource(fileName);

        System.out.println("Please enter which list needs to be sorted:  ");
        String jsonList = readFromConsole.readLine();
        JSONObject jsonObject = jsonHandler.getJSONObjectFromInputStream(is);
        JSONArray currentArray = jsonHandler.getJSONArray(jsonObject, jsonList);
        SortingAlgorithm sortingAlgo = new SortingAlgorithm();

        sortingAlgo.sort(currentArray);

    }

}
