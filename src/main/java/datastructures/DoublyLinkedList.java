package datastructures;

public class DoublyLinkedList<E>  {
    private Link<E> first;
    private Link<E> last;
    private int size;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(E data) {
        Link<E> newLink = new Link<>(data);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
        size++;
    }

    public void insertLast(E data) {
        Link<E> newLink = new Link<>(data);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
        size++;
    }

    public Link<E> deleteFirst() {
        Link<E> temp = first;

        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        size--;
        return temp;
    }

    public Link<E> deleteLast() {
        Link<E> temp = last;
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        size--;
        return temp;
    }

    public boolean insertAfter(E key, E data) {
        Link<E> current = first;

        while (current.data != key) {
            current = current.next;

            if (current == null) {
                return false;
            }
        }
        Link<E> newLink = new Link<>(data);

        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        size++;
        return true;
    }

    public Link<E> deleteKey(E key) {
        Link<E> current = first;

        while (current.data != key) {
            current = current.next;

            if (current == null) {
                return null;
            }
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        size--;
        return current;
    }

    public void displayForward() {
        System.out.println("List (first --> last): ");
        Link current = first;

        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println("");
    }

    public void displayBackward() {
        System.out.println("List (last --> first): ");
        Link current = last;

        while (current != null) {
            current.displayNodeData();
            current = current.previous;
        }
        System.out.println("");
    }

    public int getSize() {
        return size;
    }

    public E getFirst() {
        return first.getData();
    }

    public E getLast() {
        return last.getData();
    }
}
