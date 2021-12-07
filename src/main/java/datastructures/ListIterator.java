package datastructures;

import datastructures.DoublyLinkedList;
import datastructures.Link;

public class ListIterator<T> {
    private Link<T> current;
    private Link<T> previous;
    private DoublyLinkedList<T> ourList;

    public ListIterator(DoublyLinkedList<T> list) {
        ourList = list;
        reset();
    }
    public void reset() {
        current = ourList.getFirstLink();
        previous = null;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link<T> getCurrent() {
        return current;
    }

    public void insertAfter(T data) {
        Link<T> newLink = new Link<>(data);

        if (ourList.isEmpty()) {
            ourList.insertFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(T data) {
        Link<T> newLink = new Link<>(data);

        if (previous == null) {
            newLink.next = ourList.getFirstLink();
            ourList.insertFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public T deleteCurrent() {
        T value = current.getData();
        if (previous == null) {
            ourList.insertFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return value;
    }
}
