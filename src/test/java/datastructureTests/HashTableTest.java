package datastructureTests;

import com.google.gson.Gson;
import datastructures.HashTableCris;
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
import java.util.HashMap;
import java.util.List;

public class HashTableTest {
    JSONHandler jsonHandler;
    JSONObject jsonObject;
    Dataset dataset;

    @Before
    public void setup() throws IOException, ParseException {
        ResourceReaderStrategy<InputStream> reader = new InputStreamResourceReaderStrategy();
        jsonHandler = new JSONHandler();
        dataset = new Dataset();
        InputStream is = reader.getFileFromResource("datasets/hashing.json");

        jsonObject = jsonHandler.getJSONObjectFromInputStream(is);

    }

    @Test
    public <K, V> void shouldInsertDataSetIntoHashTable() {
        HashMap<K, V> result = new Gson().fromJson(jsonObject.get("hashtabelsleutelswaardes").toString(), HashMap.class);

        HashTableCris<K, V> testHashTable = new HashTableCris<>(result.size());

        for (K key : result.keySet()) {
            testHashTable.insert(key, result.get(key));
        }

        int expected = result.size();
        int actual = testHashTable.size;

        Assert.assertEquals(expected, actual);
    }

    @SuppressWarnings("unchecked")
    @Test
    public <K, V> void shouldInsertCorrectValuesIntoHashTable() {
        HashMap<String, V> result = new Gson().fromJson(jsonObject.get("hashtabelsleutelswaardes").toString(), HashMap.class);

        HashTableCris<String, V> testHashTable = new HashTableCris<>(result.size());

        for (String key : result.keySet()) {
            testHashTable.insert(key, result.get(key));
        }

        Double expected = 45454.0;
        List<V> value = (List<V>) testHashTable.get("w");
        Double actual = (Double) value.get(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public <K, V> void shouldRemoveCorrectValueFromHashTable() {
        HashMap<String, V> result = new Gson().fromJson(jsonObject.get("hashtabelsleutelswaardes").toString(), HashMap.class);

        HashTableCris<String, V> testHashTable = new HashTableCris<>(result.size());

        for (String key : result.keySet()) {
            testHashTable.insert(key, result.get(key));
        }

        testHashTable.remove("w");

        V expected = null;
        V actual = testHashTable.get("w");

        Assert.assertEquals(expected, actual);
    }

}
