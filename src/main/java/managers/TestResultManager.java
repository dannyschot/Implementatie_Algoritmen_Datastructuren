package managers;

import java.util.ArrayList;

public class TestResultManager {
    TestResultStrategy resultStrategy;

    public TestResultManager(TestResultStrategy resultStrategy) {
        this.resultStrategy = resultStrategy;
    }

    public void handleTestResults(String dataset, Long results) {
        resultStrategy.writeToFile(dataset, results);
    }
}
