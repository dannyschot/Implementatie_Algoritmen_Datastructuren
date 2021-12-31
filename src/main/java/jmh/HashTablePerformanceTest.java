package jmh;

import com.google.gson.Gson;
import datastructures.Deque;
import datastructures.HashTableCris;
import datastructures.IDequeue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openjdk.jmh.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.NANOSECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class HashTablePerformanceTest<K, V> {
    JSONObject jsonObject;
    JSONParser parser;
    HashMap<String, V> result;
    HashTableCris<String, V> hashTableCris;

    @Setup
    public void setup() throws IOException, ParseException {
        parser = new JSONParser();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("datasets/hashing.json");
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        result = new Gson().fromJson(jsonObject.get("hashtabelsleutelswaardes").toString(), HashMap.class);
        hashTableCris = new HashTableCris<>(result.size());
    }

    @Benchmark
    public void hashMapDataInsertion() {
        for (String key : result.keySet()) {
            hashTableCris.insert(key, result.get(key));
        }
    }
}
