package managers;

import org.json.simple.JSONObject;

import java.io.IOException;

public class PerformanceTester {
    TestingStrategy testingStrategy;

    public PerformanceTester(TestingStrategy strategy) {
        this.testingStrategy = strategy;
    }

    public void startTest(JSONObject object) throws IOException {
        testingStrategy.runTests(object);
    }
}
