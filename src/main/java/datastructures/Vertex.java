package datastructures;

public class Vertex<T> {
    T data;
    boolean wasVisited;

    public Vertex(T data) {
        this.data = data;
    }
}
