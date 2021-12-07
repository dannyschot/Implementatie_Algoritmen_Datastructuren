package datastructures;

public class Node<T> {
    public T data;
    Node<T> left;
    Node<T> right;
    int height;
    int count;

    public Node(T data) {
        this.data = data;
    }
}
