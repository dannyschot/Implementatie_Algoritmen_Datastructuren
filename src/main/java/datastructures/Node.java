package datastructures;

/**
 * Representeerd een node in de AVLTree datastructuur
 * Bevat data, de linker- en rechter kind nodes, de hoogte en hoevaak een data element in de boom is opgeslagen
 * @param <T>
 */
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
