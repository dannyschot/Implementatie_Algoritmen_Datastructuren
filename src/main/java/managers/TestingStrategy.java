package managers;

import org.json.simple.JSONObject;
import java.io.IOException;


public interface TestingStrategy {

    <T> void runTests(JSONObject data) throws IOException;
}
