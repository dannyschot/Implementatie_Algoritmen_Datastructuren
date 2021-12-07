package algorithmTests;

import algorithms.BinarySearch;
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

public class TestBinearySearch {
    BinarySearch<Long> binarySearchWithLong;
    BinarySearch<String> binarySearchWithStrings;
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
    }

    @Test
    public void binarySearchShouldReturnCorrectIndexWithIntegerData() {
        ArrayList<Long> sortedArray = dataset.getLijstOplopend1000();
        binarySearchWithLong = new BinarySearch<>(sortedArray);

        int actual = binarySearchWithLong.find(4L);
        int expected = 4 - 1;

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
}
