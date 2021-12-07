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

    public ListIterator<E> getIterator() {
        return new ListIterator<>(this);
    }

    public void insertFirst(Link<E> link) {
        first = link;
        size++;
    }


    public void deleteFirst() {
        Link<E> temp = first;

        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
        size--;
    }

    public int getSize() {
        return size;
    }

    public E getFirstElement() {
        return first.getData();
    }

    public E getLastElement() {
        return last.getData();
    }

    public Link<E> getFirstLink() {
        return this.first;
    }

    public Link<E> getLastLink() {
        return this.last;
    }
}
