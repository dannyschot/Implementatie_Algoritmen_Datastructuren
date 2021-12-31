package datastructures;

public class Vertex<T> {
    public T label;
    boolean wasVisited;
    public boolean isInTree;

    public Vertex(T label) {
        this.label = label;
        this.isInTree = false;
    }
}
