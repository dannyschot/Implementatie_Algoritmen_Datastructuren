package algorithmTests;

import algorithms.TimSort;
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

public class TestTimSort {
    TimSort timSort;
    JSONObject jsonObject;
    JSONParser parser;

    @SuppressWarnings("unchecked")
    @Before
    public void setup() throws IOException, ParseException, InterruptedException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/sorting.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        timSort = new TimSort<>();
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortList() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_float_8001");
        Double[] unsorted2 = new Double[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Double) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }
}
