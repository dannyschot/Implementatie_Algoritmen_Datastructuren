package algorithmTests;

import algorithms.RadixSort;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TestRadixSort {
    RadixSort radixSort;
    JSONObject jsonObject;
    JSONParser parser;


    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        radixSort = new RadixSort();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void insertionSortShouldSortList() { // TODO:: Cast verwijderen
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }


        //Act
        radixSort.sortWithSortingLib(unsorted1);
        radixSort.sort(unsorted2);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }
}
