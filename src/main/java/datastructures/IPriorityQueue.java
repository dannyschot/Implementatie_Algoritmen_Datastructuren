package datastructures;

public interface IPriorityQueue<E> {
    void enqueue(E data);
    E dequeue();
    E peekMin();
    boolean isEmpty();
    boolean isFull();
}
