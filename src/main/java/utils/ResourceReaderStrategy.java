package utils;

public interface ResourceReaderStrategy <T>{
    public T getFileFromResource(String fileName);
}
