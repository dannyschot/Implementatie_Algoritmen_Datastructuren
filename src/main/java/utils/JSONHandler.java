package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
}
