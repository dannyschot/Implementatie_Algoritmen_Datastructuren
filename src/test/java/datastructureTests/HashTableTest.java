package datastructureTests;

import com.google.gson.Gson;
import datastructures.HashTableCris;
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
import java.util.HashMap;
import java.util.List;

public class HashTableTest {
    JSONObject jsonObject;
    JSONParser parser;

    @Before
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/hashing.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
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
