package datastructures;

/**
 * Een generieke Link klasse welke gebruikt wordt als link/node in de Doubly Linked List klasse.
 * Een link bevat enkel data en een pointer naar de volgende en de vorige link.
 * @param <E>
 */
public class Link<E> {
    private E data;
    public Link<E> next;
    Link<E> previous;

    public Link(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }
}
