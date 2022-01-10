package algorithmTests;

import algorithms.BinarySearch;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TestBinearySearch {
    JSONParser parser;
    JSONObject jsonObject;
    BinarySearch<String> binarySearchWithStrings;


    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Test
    public void binarySearchShouldReturnCorrectIndexWithLongData() {
        BinarySearch<Long> binarySearch;
        JSONArray jsonArray = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        binarySearch = new BinarySearch<>(jsonArray);

        int actual = binarySearch.find(400L);
        int expected = 400 - 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binarySearchShouldReturnCorrectIndexWithStringData() {
        ArrayList<String> sortedArray = new ArrayList<>();
        sortedArray.add("a");
        sortedArray.add("b");
        sortedArray.add("c");
        sortedArray.add("d");
        sortedArray.add("e");
        sortedArray.add("f");

        binarySearchWithStrings = new BinarySearch<>(sortedArray);

        int actual = binarySearchWithStrings.find("d");
        int expected = 4 - 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void binarySearchShouldReturnSizeIfItemNotExists() {
        ArrayList<String> sortedArray = new ArrayList<>();
        sortedArray.add("a");
        sortedArray.add("b");
        sortedArray.add("c");
        sortedArray.add("d");
        sortedArray.add("e");
        sortedArray.add("f");

        binarySearchWithStrings = new BinarySearch<>(sortedArray);

        int actual = binarySearchWithStrings.find("k");
        int expected = sortedArray.size();

        Assert.assertEquals(expected, actual);
    }

    @AfterClass
    public static void endMessage() {
        System.out.println("\n");
        System.out.println("End of the binary search test");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
    }
}
