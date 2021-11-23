package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JSONHandler {
    JSONParser parser;

    public JSONHandler() {
        parser = new JSONParser();
    }

    public JSONObject getJSONObjectFromInputStream(InputStream is) throws IOException, ParseException {
        return (JSONObject) parser.parse(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

    public JSONArray getJSONArray(JSONObject object, String value) {
        return (JSONArray) object.get(value);
    }

    public ArrayList<Double> convertToDoubleArray(JSONArray jsonArray) {
        ArrayList<Double> listWithDoubles = new ArrayList<>();

        for (Object o : jsonArray) {
            listWithDoubles.add((Double) o);
        }

        return listWithDoubles;
    }

    public ArrayList<Long> convertToLongArray(JSONArray jsonArray) {
        ArrayList<Long> listWithLongs = new ArrayList<>();

        for (Object o : jsonArray) {
            listWithLongs.add((Long) o);
        }

        return listWithLongs;
    }

    public ArrayList<String> convertToStringArray(JSONArray jsonArray) {
        ArrayList<String> listWithStrings = new ArrayList<>();

        for (Object o : jsonArray) {
            listWithStrings.add((String) o);
        }

        return listWithStrings;
    }

    public ArrayList<Integer> convertToIntegerArray(JSONArray jsonArray) {
        ArrayList<Integer> listWithIntegers = new ArrayList<>();

        for (Object o : jsonArray) {
            listWithIntegers.add((Integer) o);
        }
        return listWithIntegers;
    }

    public ArrayList<Float> convertToFloatArray(JSONArray jsonArray) {
        ArrayList<Float> listWithFloats = new ArrayList<>();

        for (Object o : jsonArray) {
            listWithFloats.add((Float) o);
        }
        return listWithFloats;
    }
}
