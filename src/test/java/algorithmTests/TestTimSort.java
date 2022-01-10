package algorithmTests;

import algorithms.TimSort;
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

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstAflopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_aflopend_2");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstOplopend2() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_2");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstGesorteerdAflopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_aflopend_3");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstGesorteerdOplopend3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerd_oplopend_3");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstHerhaald1000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_herhaald_1000");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstLeeg0() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_leeg_0");
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

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstGesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_gesorteerde_strings");
        String[] unsorted2 = new String[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (String) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstOngesorteerdeStrings() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_ongesorteerde_strings");
        String[] unsorted2 = new String[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (String) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstLijstOplopend10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_oplopend_10000");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstWillekeurig10000() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_10000");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstWillekeurig3() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_3");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstWillekeurig4() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_4");
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

    @SuppressWarnings("unchecked")
    @Test
    public void timSortShouldSortLijstWillekeurig5() {
        //Arrange
        JSONArray unsorted1 = (JSONArray) jsonObject.get("lijst_willekeurig_5");
        Long[] unsorted2 = new Long[unsorted1.size()];

        for (int i = 0; i < unsorted1.size(); i++) {
            unsorted2[i] = (Long) unsorted1.get(i);
        }

        //Act
        timSort.sortWithSortingLib(unsorted1);
        timSort.timSort(unsorted2, unsorted2.length);

        //Assert
        Assert.assertArrayEquals(unsorted1.toArray(), unsorted2);
    }

    @AfterClass
    public static void endMessage() {
        System.out.println("\n");
        System.out.println("End of the tim sort test");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("\n");
    }
}
