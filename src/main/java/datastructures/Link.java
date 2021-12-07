package datastructures;

public class Link<E> {
    E data;
    public Link<E> next;
    Link<E> previous;

    public Link(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }
}
