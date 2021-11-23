package datastructures;

public class Link<E> {
    E data;
    Link<E> next;
    Link<E> previous;

    public Link(E data) {
        this.data = data;
    }

    public void displayNodeData() {
        System.out.println(data + " ");
    }

    public E getData() {
        return data;
    }
}
