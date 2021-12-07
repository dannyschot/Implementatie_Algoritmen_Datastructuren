package managers;


public interface TestResultStrategy {

    void writeToFile(String dataset, Long results, String fileName);
}
