package managers;

import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface TestingStrategy {

    <T> void runTests(JSONObject data) throws IOException;
}
