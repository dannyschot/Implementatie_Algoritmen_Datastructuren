package managers;

import java.util.ArrayList;

public interface TestResultStrategy {

    void writeToFile(String dataset, Long results);
}
